import java.io.Serializable;

public class EchoRequest implements Serializable {
    private String value;
    public EchoRequest(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
