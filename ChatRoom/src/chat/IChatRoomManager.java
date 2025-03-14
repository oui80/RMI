package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IChatRoomManager extends Remote {
    IChatRoom getChatRoom(String name) throws RemoteException;
}