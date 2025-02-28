package babystep;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 9999);
            IPrinter stub = (IPrinter) registry.lookup("printer");
            stub.print("Hello, World!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
