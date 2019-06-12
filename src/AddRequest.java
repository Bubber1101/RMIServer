import java.io.Serializable;

public class AddRequest implements Serializable {
    private int a;
    private int b;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public AddRequest(int a, int b) {

        this.a = a;
        this.b = b;
    }
}
