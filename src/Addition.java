import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Addition extends Remote {

    AddResponse add(AddRequest req) throws RemoteException;
}
