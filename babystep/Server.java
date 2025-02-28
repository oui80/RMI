package babystep;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {
        IPrinter printer = new Printer();
        try {
            Registry registry = LocateRegistry.createRegistry(9999);
            registry.rebind("printer", printer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}