package Chat_server;

public interface IChatRoom {

    String name();

    void connect(IParticipant p);

    void leave(IParticipant p);

    String[] who();

    void send(IParticipant p, String msg);
}