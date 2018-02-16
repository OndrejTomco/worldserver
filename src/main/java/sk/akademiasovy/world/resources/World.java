package sk.akademiasovy.world.resources;

import com.fasterxml.jackson.annotation.JsonProperty;
import sk.akademiasovy.world.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/world")
public class World {

    @GET
    @Path("/countries")
    @Produces(MediaType.APPLICATION_JSON)

    public String getCountries(){
        MySQL mySQL=new MySQL();
        List<String> list= mySQL.getCountries();
        System.out.println(list);


        boolean b = false;
        String result= "func({\"name\":[";
        for(String temp:list){
            if(b == true){
                result+=',';
            }
            else
                b=true;
            result+="\""+temp+"\"";
        }
        return result+="]})";

    }

    @GET
    @Path("/cities/{country}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getCities(@PathParam("country") String country){
        System.out.println(country);

        List<String> list = new MySQL().getCities(country);


    boolean b= false;
    String result= "func2({\"name\":[";
        for(String temp:list){
        if(b==true){
            result+=',';
        }
        else
            b=true;
        result+="\""+temp+"\"";
    }
    result+="]})";

        return result;

    }

    @POST
    @Path("/population")
    @Produces(MediaType.APPLICATION_JSON)

    public String getPopulation(City city){
        String population = new MySQL().getPopulation(city.name);

    return population;

    }

    public static class City {

        @JsonProperty("name")
        public String name;
    }

    @GET
    @Path("/city/{city}")
    @Produces(MediaType.APPLICATION_JSON)

    public String getCountry(@PathParam("city") String city){

        String myCity = new MySQL().getCountry(city);
        System.out.println(myCity);
        String res = "{\"name\":\""+myCity+"\"}";
        System.out.println(res);

        return res;

    }


}
