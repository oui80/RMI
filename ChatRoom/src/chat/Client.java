package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        String chatRoomName;

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 9999);
            System.out.print("Chatroom name :");
            chatRoomName = System.console().readLine();
            try {
                IChatRoom stub = (IChatRoom) registry.lookup(chatRoomName);

                

                Participant p = new Participant("jojo", stub);
                stub.connect(p);
                while (true) {
                    String msg = System.console().readLine();
                    p.send(msg);
                }
            } catch (Exception e) {
                System.out.println("Création d'une nouvelle Chatroom");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
