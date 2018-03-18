package rest;

import org.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by Aliaksei on 22.11.2017.
 */
@Path("/message")
public class MessageResource {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Message> getAllMessages(){
            List<Message> messages = Data.getData();
            return messages;
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessageByID(@PathParam("id") int id)  {
        Message message = Data.findbyID(id);
        return message;


    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMessage(Message message){
        Data.createMessage(message);
    }

    @DELETE
    @Path("{id}")
    public void deleteMessage(@PathParam("id") int id) {
        if (Data.deletebyID(id) != true) {
            throw new RuntimeException("can't delete mesage with id = " + id);

        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updatedMessage(Message message){
        if(Data.update(message)!=true){
            throw new RuntimeException("can't update mesage with id = " + message.getMessageId());
        }
    }
}
