package Ms.India.demoRest;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("api")
public class MyResource {

  StudentRepositry rep=new StudentRepositry();
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "This is the api creation!";
    }
    
    
    @GET
    @Path("student")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent() {
    	List<Student> list=rep.getStudends();
    	
    	
    	
		return list;
    }
    
    @PUT
    @Path("S1")
    @Consumes(MediaType.APPLICATION_JSON)
    public String putStudent(Student s1) {
    	int result=rep.postStudent(s1);
    	
    	System.out.println(s1);
    	if(result==0) {
    		return "failed";
    	}else {
    		return "ok";
    	}
			
    }
    
    
    
    @DELETE
    @Path("DelStudent/{stuname}")
    @Consumes(MediaType.APPLICATION_JSON)
    public String delStudent(@PathParam("stuname")String name) {
    	
    	
    	
    	
		return name;
    	
    	
    	
    }
}
