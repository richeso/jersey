package autologin.resources;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.sun.jersey.core.util.Base64;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;
 
@Path("/testsecurity")
@RolesAllowed("admin")
public class TestSecurity {
 
    @GET
    @Produces("text/plain")
    @RolesAllowed("user")
    public String printRequestData(@Context HttpHeaders headers){
        String reply =( dumpData(headers));
 
        return reply;
    }
 
     @GET
     @Path("/Secure")
     @RolesAllowed("admin")
     @Produces("text/plain")
    public String getSecureNumber(@Context HttpHeaders headers){
         System.out.println( dumpData(headers));
 
        return "2 Secured with Admin";
    }
 
    private String dumpData(HttpHeaders headers) {
		  MultivaluedMap <String, String>  m =  headers.getRequestHeaders();
		  Collection<String>keys = m.keySet();
		  int i=0;
		  StringBuffer result = new StringBuffer("");
		  String msg = "";
		  for (String key : keys) {
			  ++i;
			  
			  msg = ("header key: "+i+" :"+key + ": -- contents -->");
			  result.append(msg+"\n");
			  System.out.println(msg);
			  List<String> keyvals = headers.getRequestHeader(key);
			  for (String keyvalstr: keyvals) {
				  msg = ("  --> "+keyvalstr);
				  result.append(msg+"\n");
				  System.out.println(msg);
			  }
		  }
    	/*
    	i = 0;
    	for ( String auth : headers.getRequestHeader(HttpHeaders.AUTHORIZATION)) {
    		++i;
    		System.out.println(i+" --> "+auth);
    	}
        String auth = headers.getRequestHeader("authorization").get(0);
 
        auth = auth.substring("Basic ".length());
        String[] values = new String(Base64.base64Decode(auth)).split(":");
        String username = values[0];
        String password = values[1];
 
        String return_val = "Username = " + username + " Password = "+ password;
 		*/
        return result.toString();
    }
 
}