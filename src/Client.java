import com.sun.javaws.exceptions.InvalidArgumentException;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            if (args[0].equals("ECHO")) {
                Echo stub = (Echo) registry.lookup(args[0]);
                String req = "";
                for (int i = 1; i <args.length ; i++) {
                    req += args[i] + " ";
                }
                String response = stub.reply(new EchoRequest(req)).toString();
                System.out.println("response: " + response);
            } else if (args[0].equals("ADD")) {
                Addition stub = (Addition) registry.lookup(args[0]);
                int a = Integer.parseInt(args[1]);
                int b = Integer.parseInt(args[2]);
                int response = stub.add(new AddRequest(a,b)).getValue();
                System.out.println(a + " + " + b +" = " + response);
            }else throw new InvalidArgumentException(args);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}