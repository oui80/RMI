package babystep;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {

        try {
            IPrinter printer = new Printer();
            Registry registry = LocateRegistry.createRegistry(9999);
            registry.bind("printer", printer);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}