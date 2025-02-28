package Chat_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom {
    private String name;
    private ArrayList<IParticipant> participants;

    public ChatRoom(String name) throws RemoteException {
        this.name = name;
        participants = new ArrayList<IParticipant>();

    }

    @Override
    public String name() throws RemoteException {
        return name;
    }

    @Override
    public void connect(IParticipant p) throws RemoteException {
        participants.add(p);

    }

    @Override
    public void leave(IParticipant p) throws RemoteException {
        participants.remove(p);

    }

    @Override
    public String[] who() throws RemoteException {
        String[] names = new String[participants.size()];
        for (int i = 0; i < participants.size(); i++) {
            names[i] = participants.get(i).name();
        }
        return names;
    }

    @Override
    public void send(IParticipant p, String msg) throws RemoteException {
        for (int i = 0; i < participants.size(); i++) {
            participants.get(i).receive(p.name(), msg);
        }
    }

}
