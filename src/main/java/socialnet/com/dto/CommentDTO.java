package socialnet.com.dto;

import java.util.Objects;

public class CommentDTO {
    private Long id;
    private Long PostId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentDTO that = (CommentDTO) o;
        return id.equals(that.id) && PostId.equals(that.PostId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, PostId);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostId() {
        return PostId;
    }

    public void setPostId(Long postId) {
        PostId = postId;
    }


}
