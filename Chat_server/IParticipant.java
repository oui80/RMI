package Chat_server;

public interface IParticipant {
    String name();

    void receive(String name, String msg);
}
