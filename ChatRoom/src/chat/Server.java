package chat;

import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.rmi.registry.LocateRegistry;

public class Server {

    ArrayList<ChatRoom> chatRooms;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(9999);
            IChatRoomManager manager = new ChatRoomManager(registry);
            registry.rebind("ChatRoomManager", manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}