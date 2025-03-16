package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {

        String chatRoomName;
        String msg = "";
        System.out.println("Entrer your pseudo : ");
        String pseudo = System.console().readLine();
        try {
            while (!msg.equals("exit")) {
                Registry registry = LocateRegistry.getRegistry("localhost", 9999);
                System.out.print("Chatroom name :");
                chatRoomName = System.console().readLine();

                try {
                    IChatRoomManager stub = (IChatRoomManager) registry.lookup("ChatRoomManager");
                    IChatRoom chatRoom = stub.getChatRoom(chatRoomName);

                    Participant p = new Participant(pseudo, chatRoom);
                    chatRoom.connect(p);
                    p.affichePreviousMessage();
                    while (true) {
                        msg = System.console().readLine();
                        if (msg.equals("exit")) {
                            chatRoom.leave(p);
                            break;
                        }
                        if (msg.equals("who")) {
                            String[] participants = chatRoom.who();
                            System.out.println("Liste des participants (vous seul voyez ce message) : ");
                            for (String participant : participants) {
                                System.out.println("-" + participant);
                            }
                        } else {
                            p.send(msg);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Bug de connexion, voulez-vous réessayer ? (oui/non)");
                    String reponse = System.console().readLine();
                    if (reponse.equals("non") || reponse.equals("exit") || reponse.equals("no")
                            || reponse.equals("n")) {
                        msg = "exit";
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Client closed");
        System.exit(0);
    }
}
