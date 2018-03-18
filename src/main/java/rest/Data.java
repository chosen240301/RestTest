package rest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksei on 22.11.2017.
 */


public class Data {
    private static List<Message> data;
    private static long count = 5;

    static {
        data = new ArrayList<Message>();
        data.add(new Message(1, "Hello", "Hello! I'm first entry!"));
        data.add(new Message(2, "2nd", "second messages"));
        data.add(new Message(3, "here again!", "some text"));
        data.add(new Message(4, "HI!", "pam param"));
    }

    public static List<Message> getData() {
        return data;
    }

    public static Message findbyID(int id) {
        for (Message ms : data) {
            if (ms.getMessageId() == id) {
                return ms;
            }

        }
        return null;
    }


    public static boolean deletebyID(int id) {
        Message message = findbyID(id);
        if (message == null)
            return false;
        data.remove(message);
        return true;
    }

    public static void createMessage(Message message) {
        for (Message ms : data) {
            if (message.getMessageId() == ms.getMessageId())
                return;
        }
        data.add(message);

    }

    public static boolean update(Message message) {
        for (Message ms : data) {
            if (message.getMessageId() == ms.getMessageId()) {
                ms.setMessageText(message.getMessageText());
                ms.setMessageTitle(message.getMessageTitle());
                return true;
            }
        }
        return false;
    }

}
