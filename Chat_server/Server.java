package Chat_server;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) {

        try {
            IChatRoom room = new ChatRoom("chatroom");
            Registry registry = LocateRegistry.createRegistry(9999);
            registry.rebind("chatroom", room);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}