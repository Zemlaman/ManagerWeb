package cz.educanet.webik;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    private UsersManager manager;

    public static List<User> names = new ArrayList<User>();

    @GET
    public Response getAll() {
        return Response.ok(names).build();
    }

    @POST
    @Path("register")
    public Response createUser(
            @FormParam("FirstName") String FirstName, @FormParam("LastName") String LastName,
            @FormParam("username") String username, @FormParam("email") String email,
            @FormParam("password") String password
    ) {
        User user = new User(FirstName, LastName, username, email, password);
        if(userCheck(user)) {
            return Response.ok("This username already exists").build();
        }
        names.add(user);
        return Response.ok("This username:" + user + "is ok").build();
    }

    @POST
    @Path("login")
    public Response loginUser(@FormParam("username") String username, @FormParam("password") String password) {
        for(int x = 0; x < names.size(); x++) {
            User user = names.get(x);
            if (user.username.equals(username) & user.password.equals(password)) {
                manager.user = user;
                return Response.ok("User is logged").build();
            }

        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }


    public Boolean userCheck(User user) {
        for (int i = 0; i < names.size(); i++) {
            if (names.get(i).getUsername().equals(user.getUsername())) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @GET
    public Response getLoggedUser() {
        return  Response.ok(manager.user).build();
    }

    @DELETE
    public Response removeUser() {
            manager.user = null;
            return Response.ok("Done").build();
    }


}