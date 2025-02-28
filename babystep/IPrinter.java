package babystep;
import java.rmi.*;

public interface IPrinter extends Remote {

    public void print(String message) throws RemoteException;
}
