
package org.captains;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

// The Java class will be hosted at the URI path "/summoner/{id}/"
@Path("/summoner/{name}/")
public class SummonerInfo {

    // The Java method will process HTTP GET requests
    @GET 
    // The Java method will produce content identified by the MIME Media
    // type "text/plain"
    @Produces("text/plain")
    public String getIt(@PathParam("name") String name) {
    	return (new FetchSummoners()).ByName(name, Region.EUW).toJSON();
    }
}


