package babystep;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Printer extends UnicastRemoteObject implements IPrinter {

    protected Printer() throws RemoteException {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
