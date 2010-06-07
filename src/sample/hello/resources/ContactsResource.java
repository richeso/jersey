package sample.hello.resources;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import sample.hello.bean.Address;
import sample.hello.bean.Contact;
import sample.hello.storage.ContactStore;


@Path("/contacts")
public class ContactsResource {
	
	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Contact> getContacts() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.addAll( ContactStore.getStore().values() );
		return contacts;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ContactStore.getStore().size();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newContact(
			@FormParam("id") String id,
			@FormParam("name") String name,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		Contact c = new Contact(id,name,new ArrayList<Address>());
		ContactStore.getStore().put(id, c);
		
		URI uri = uriInfo.getAbsolutePathBuilder().path(id).build();
		Response.created(uri).build();
		
		servletResponse.sendRedirect("../pages/new_contact.html");
	}
	
	@Path("{contact}")
	public ContactResource getContact(
			@PathParam("contact") String contact) {
		return new ContactResource(uriInfo, request, contact);
	}
	
}
