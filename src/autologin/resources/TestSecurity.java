package autologin.resources;

import com.sun.jersey.core.util.Base64;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
 
@Path("/autologin/Test")
@RolesAllowed("admin")
public class TestSecurity {
 
    @GET
    @Produces("text/plain")
    @RolesAllowed("user")
    public String getNumber(@Context HttpHeaders headers){
        System.out.println( getCredentials(headers));
 
        return "1 Secured with User";
    }
 
     @GET
     @Path("/Secure")
     @RolesAllowed("admin")
     @Produces("text/plain")
    public String getSecureNumber(@Context HttpHeaders headers){
         System.out.println( getCredentials(headers));
 
        return "2 Secured with Admin";
    }
 
    private String getCredentials(HttpHeaders headers) {
        String auth = headers.getRequestHeader("authorization").get(0);
 
        auth = auth.substring("Basic ".length());
        String[] values = new String(Base64.base64Decode(auth)).split(":");
        String username = values[0];
        String password = values[1];
 
        String return_val = "Username = " + username + " Password = "+ password;
 
        return return_val;
    }
 
}