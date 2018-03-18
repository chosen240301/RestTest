package rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 * Created by Aliaksei on 22.11.2017.
 */


public class RestClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(getBaseURI());
        /*Invocation invokation = target.request(MediaType.APPLICATION_JSON).buildGet();
        Response response = invokation.invoke();*/
        GenericType<List<Message>> genericType = new GenericType<List<Message>>() {
        };
        List<Message> messages = target.path("rest").path("message").request(MediaType.APPLICATION_XML).get(genericType);

        for (Message temp : messages) {
            System.out.println(temp);
        }
    }



    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/RestTest").build();
    }


}
