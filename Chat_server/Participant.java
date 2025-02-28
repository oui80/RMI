package Chat_server;

public class Participant implements IParticipant {
    private String name;
    private IChatRoom room;

    public Participant(String name, IChatRoom room) {
        this.name = name;
        this.room = room;
    }

    public String name() {
        return name;
    }

    public void receive(String name, String msg) {
        System.out.println(name + ": " + msg);
    }

    public void send(String msg) {
        room.send(this, msg);
    }

}
