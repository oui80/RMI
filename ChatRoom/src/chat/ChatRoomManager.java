package chat;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class ChatRoomManager implements IChatRoomManager {

    Registry r;

    public ChatRoomManager(Registry r) throws RemoteException {
        super();
        this.r = r;
        
    }

    @Override
    public IChatRoom getChatRoom(String name) throws RemoteException {
        try {
            return (IChatRoom) r.lookup(name);
        } catch (Exception e) {
            System.out.println("On crée une nouvelle chat room "+ name);
            IChatRoom chatRoom = new ChatRoom(name);
            r.rebind(name, chatRoom);
            return chatRoom;
        }
    }

}
