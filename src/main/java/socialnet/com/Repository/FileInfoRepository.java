package socialnet.com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socialnet.com.entity.FileInfo;

@Repository
public interface FileInfoRepository extends JpaRepository <FileInfo,Long> {
}
