package socialnet.com.Service.impl;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import socialnet.com.Repository.CommentRepository;
import socialnet.com.Repository.FileInfoRepository;
import socialnet.com.Repository.PostRepository;
import socialnet.com.Repository.UserRepository;
import socialnet.com.Service.PostService;
import socialnet.com.dto.PostDTO;
import socialnet.com.entity.FileInfo;
import socialnet.com.entity.Post;
import socialnet.com.entity.User;

import javax.persistence.Convert;
import javax.transaction.Transactional;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Logger;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private static final Logger LOGGER = Logger.getLogger(PostServiceImpl.class.getName());

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final FileInfoRepository fileInfoRepository;

    public PostServiceImpl(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository, FileInfoRepository fileInfoRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.fileInfoRepository = fileInfoRepository;
    }

    @Override
    public void createPost(PostDTO postDTO) throws IOException {
        Post newPost = new Post();
        Optional<User> userPostOptional = userRepository.findById(postDTO.getUserId());
        User userPost = null;
        if (userPostOptional.isPresent()) {
            userPost = userPostOptional.get();
        }
        assert userPost != null;
        newPost.setUser(userPost);
        newPost.setCreatedDate(new Date());
        newPost.setContext(postDTO.getContext());
        FileInfo newFileInfo = new FileInfo();
        UUID uuid = UUID.randomUUID();
        Path path = Paths.get("/Users/firefriedchickennoodle/Desktop/new/post-photos/" + uuid + "." + postDTO.getExtension());
        byte[] byteArray = Base64.getDecoder().decode(postDTO.getFile());
        Files.write(path, byteArray);
        newFileInfo.setPath("/Users/firefriedchickennoodle/Desktop/new/post-photos/");
        newFileInfo.setName(uuid + "." + postDTO.getExtension());
        fileInfoRepository.save(newFileInfo);
        newPost.setFileInfo(newFileInfo);
        postRepository.save(newPost);
    }

    @Override
    public Post updatePost(Post post) {

        postRepository.save(post);
        return post;
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deletePostById(id);

    }

    @Override
    public void putLike(Long postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        Post postNew = null;
        if (postOptional.isPresent()) {
            postNew = postOptional.get();
        }
        assert postNew != null;
        int likes = postNew.getLikes();
        likes++;
        postNew.setLikes(likes);
        postRepository.save(postNew);

    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<PostDTO> getPostsOfUser(Long userId) throws IOException {
        List<Post> currentPost = postRepository.findAllByUser_Id(userId);
        List<PostDTO> emptyList = new ArrayList<>();
        for (Post postfor : currentPost) {
            PostDTO postDTO = new PostDTO();
            postDTO.setUserId(userId);
            postDTO.setContext(postfor.getContext());
            String fileName = postfor.getFileInfo().getName();
            String[] array = fileName.split("\\.");
            postDTO.setExtension(array[1]);
            String filePath = postfor.getFileInfo().getPath();
                byte[] byteArray = Files.readAllBytes(Paths.get(filePath + fileName));
                //   byte [] byteArray = filePath.getBytes();
                String s = Base64.getEncoder().encodeToString(byteArray);
                postDTO.setFile(s);
                emptyList.add(postDTO);
        }
        return emptyList;
    }
}



                   // получить файл из локального диска и путь (файл инфо 104 строка). нужно будет массив байт преобразовать в СТроку б64
         //  (вернуть список после цикла фор эмпти лист)


