package socialnet.com.dto;

import java.util.Objects;

public class MessageDTO {
    private  Long idTo;
    private Long idFrom;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageDTO that = (MessageDTO) o;
        return idTo.equals(that.idTo) && idFrom.equals(that.idFrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTo, idFrom);
    }



    public Long getIdTo() {
        return idTo;
    }

    public void setIdTo(Long idTo) {
        this.idTo = idTo;
    }

    public Long getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(Long idFrom) {
        this.idFrom = idFrom;
    }



    public MessageDTO(Long idTo, Long idFrom) {
        this.idTo = idTo;
        this.idFrom = idFrom;
    }

    public MessageDTO() {
    }
}
