package Chat_server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatRoom extends UnicastRemoteObject implements IChatRoom {
    private String name;
    private IParticipant[] participants;
    private int count;

    public ChatRoom(String name) throws RemoteException {
        this.name = name;
        participants = new IParticipant[10];
        count = 0;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void connect(IParticipant p) {
        participants[count++] = p;
    }

    @Override
    public void leave(IParticipant p) {
        for (int i = 0; i < count; i++) {
            if (participants[i] == p) {
                for (int j = i; j < count - 1; j++) {
                    participants[j] = participants[j + 1];
                }
                count--;
                break;
            }
        }
    }

    @Override
    public String[] who() {
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = participants[i].name();
        }
        return names;
    }

    @Override
    public void send(IParticipant p, String msg) {
        for (int i = 0; i < count; i++) {
            if (participants[i] != p) {
                participants[i].receive(p.name(), msg);
            }
        }
    }

}
