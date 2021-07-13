package socialnet.com.entity;

import javax.persistence.*;

@Entity
@Table(name = "fileinfo")

public class FileInfo {


    private Long id;
    private String path;
    private String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

}
