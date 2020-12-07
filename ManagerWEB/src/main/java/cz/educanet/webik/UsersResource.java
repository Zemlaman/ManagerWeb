package cz.educanet.webik;

import sun.rmi.server.UnicastServerRef;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {
    private static List<User> names = new ArrayList<User>();

    @GET
    public Response getAll() {
        return Response.ok(names).build();
    }

    @POST
    public Response createUser(
            @QueryParam("FirstName") String FirstName, @QueryParam("LastName") String LastName,
            @QueryParam("username") String username, @QueryParam("email") String email,
            @QueryParam("password") String password
    ) {
        User user = new User(FirstName, LastName, username, email, password);
        if(userCheck(user)) {
            return Response.ok("This username already exists").build();
        }
        names.add(user);
        return Response.ok("This username is ok").build();
    }

    @POST
    public Response loginUser(User user){
        if(userCheck(user)) {

        }
        return Response.ok().build();
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

    @DELETE
    public Response removeUser(User user) {
        if(userCheck(user)) {
            names.remove(user);
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }
    }


}