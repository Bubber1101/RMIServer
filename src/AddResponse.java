import java.io.Serializable;

public class AddResponse implements Serializable {
    private int value;
    public AddResponse(AddRequest a){
        this.value = a.getA() + a.getB();
    }
    public int getValue() {
        return value;
    }
}
