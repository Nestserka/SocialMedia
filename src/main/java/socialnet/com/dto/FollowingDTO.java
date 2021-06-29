package socialnet.com.dto;

public class FollowingDTO {
    private Long idFrom;
    private Long idTo;

    public FollowingDTO(Long idFrom, Long idTo) {
        this.idFrom = idFrom;
        this.idTo = idTo;
    }

    public FollowingDTO() {
    }

    public Long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Long idFrom) {
        this.idFrom = idFrom;
    }

    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }


}
