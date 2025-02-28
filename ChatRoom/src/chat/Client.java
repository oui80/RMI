package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 9999);
            IChatRoom stub = (IChatRoom) registry.lookup("chatroom");
            Participant p = new Participant("jojo", stub);
            stub.connect(p);
            while (true) {
                String msg = System.console().readLine();
                p.send(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
