import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Echo extends Remote {
    EchoResponse reply(EchoRequest req) throws RemoteException;
}
