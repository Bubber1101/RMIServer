import java.io.Serializable;

public class EchoResponse implements Serializable {
    private String value;

    public EchoResponse(EchoRequest e){
        value = "Echo: " + e.toString();
    }

    @Override
    public String toString() {
        return value;
    }
}
