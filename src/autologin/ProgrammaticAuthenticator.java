package autologin;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.authenticator.AuthenticatorBase;
import org.apache.catalina.authenticator.Constants;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.RequestFacade;
import org.apache.catalina.connector.Response;
import org.apache.catalina.connector.ResponseFacade;
import org.apache.catalina.deploy.LoginConfig;
import org.apache.catalina.realm.GenericPrincipal;

/**
 * 
 * @author SergeyZ
 *
 */
public class ProgrammaticAuthenticator extends AuthenticatorBase {

    private Field request;
    private Field response;

    {
        Field[] fields = RequestFacade.class.getDeclaredFields();
        request = filter(fields, "request");
        request.setAccessible(true);
        fields = ResponseFacade.class.getDeclaredFields();
        response = filter(fields, "response");
        response.setAccessible(true);
    }
    
    public void authenticate(HttpServletRequest rq, HttpServletResponse rs, String user, String password, List<String> roles) {        
        try {
            GenericPrincipal principal = new GenericPrincipal(null, user, password, roles);
            register((Request)request.get(rq), (Response)response.get(rs), principal, Constants.FORM_METHOD, user, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    private Field filter(Field[] fields, String name) {
        for (Field field : fields) {
            if (field.getName().equals(name)) {
                return field;
            }
        }
        return null;
    }

    @Override
    protected boolean authenticate(Request request, Response response, LoginConfig config) throws IOException {
        throw new UnsupportedOperationException("Use authenticate(Principal)");
    }

}
