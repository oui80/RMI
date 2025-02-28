package Chat_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Participant extends UnicastRemoteObject implements IParticipant {
    private String name;
    private IChatRoom room;

    public Participant(String name, IChatRoom room)  throws RemoteException {
        this.name = name;
        this.room = room;
    }

    public String name() throws RemoteException {
        return name;
    }

    public void receive(String name, String msg) throws RemoteException {
        System.out.println(name + ": " + msg);
    }

    public void send(String msg) throws RemoteException  {
        room.send(this, msg);
    }

}
