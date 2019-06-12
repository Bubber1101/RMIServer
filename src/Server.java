import com.sun.javaws.exceptions.InvalidArgumentException;

import java.rmi.Remote;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ExecutionException;

public class Server implements Echo, Addition {

    public Server() {}

        public static void main(String args[]) {

        try {
//            Server obj = new Server();
//            if (args[0].equals("ECHO")) {
//                Echo stub = (Echo) UnicastRemoteObject.exportObject(obj, 1099);
//                Registry registry = LocateRegistry.createRegistry(1099);
//                registry.bind(args[1], stub);
//            } else if (args[0].equals("ADD")) {
//                Addition stub = (Addition) UnicastRemoteObject.exportObject(obj, 1099);
//                Registry registry = LocateRegistry.createRegistry(1099);
//                registry.bind(args[1], stub);
//            }else throw new InvalidArgumentException(args);
            Server echoObj = new Server();
            Server addObj = new Server();


                Echo stub1 = (Echo) UnicastRemoteObject.exportObject(echoObj, 1099);
                Registry registry = LocateRegistry.createRegistry(1099);
                registry.bind(args[0], stub1);

                Addition stub2 = (Addition) UnicastRemoteObject.exportObject(addObj, 1099);
                registry.bind(args[1], stub2);



            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }


    @Override
    public EchoResponse reply(EchoRequest req) throws RemoteException {
        return new EchoResponse(req);
    }

    @Override
    public AddResponse add(AddRequest req) throws RemoteException {
        return new AddResponse(req);
    }
}