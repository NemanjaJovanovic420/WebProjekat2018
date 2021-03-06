package rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import dao.EmergencyDAO;
import model.Emergency;
import model.EmergencyState;
import model.EmergencyType;

@Path("/emergencyService")
public class EmergencyService {
	
	@POST
	@Path("/emergencyCreate")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Emergency createEmergency(
			@FormDataParam("locationName") String locationName, 
			@FormDataParam("municipalitie") String municipalitie,
			@FormDataParam("description") String description,
			@FormDataParam("gMap") String gMap,
			@FormDataParam("territory") String territory,
			@FormDataParam("emergencyType") EmergencyType emergencyType,
			@FormDataParam("image") InputStream fileInputStream,
			@FormDataParam("image") FormDataContentDisposition contentDispositionHeader,
			@FormDataParam("emergencyState") EmergencyState emergencyState
	) throws URISyntaxException, FileNotFoundException, IOException {
		
		String emergencyId = UUID.randomUUID().toString();
		String relativePathToImage = "";
		if(contentDispositionHeader.getFileName() != null) {
			String imagesDirPath = Util.getAbsolutePathToImagesDir("emergencies");
			Util.savePicture(imagesDirPath, emergencyId, fileInputStream);
			relativePathToImage = Util.getRelativePathToImage("emergencies", emergencyId);
		}
		else {
			relativePathToImage = "./images/default-emergency.jpeg";
		}
		
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.createEmergency(emergencyId, locationName, municipalitie, description,
				gMap, territory, emergencyType, relativePathToImage, emergencyState);
		
	}
	
	@GET
	@Path("/getAllEmergencies")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Emergency> getAllEmergency() throws FileNotFoundException, IOException {
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.getAll();
		
	}
	
	@POST
	@Path("/updateEmergency")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateEmergency(List<Emergency> emergencies) throws FileNotFoundException, IOException{
		EmergencyDAO emergencyDAO  = EmergencyDAO.getInstance();
		emergencyDAO.updateAll(emergencies);
	}
	
	@GET
	@Path("/getActive")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Emergency> getActive() throws FileNotFoundException, IOException {
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.getActive();
	}
	
	@GET
	@Path("/getByType")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Emergency> getByType(@QueryParam("type") EmergencyType type) throws FileNotFoundException, IOException {
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.getByType(type);
	}
	
	@GET
	@Path("/getByTerritory")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Emergency> getByTerritory(@QueryParam("territory") String terrId) throws FileNotFoundException, IOException {
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.getByTerritory(terrId);
	}
	
	@GET
	@Path("/getByVolUsername")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Emergency> getByVolUsername(@QueryParam("volUsername") String volUsername) throws FileNotFoundException, IOException {
		EmergencyDAO emergencyDAO = EmergencyDAO.getInstance();
		return emergencyDAO.getByVolUsername(volUsername);
	}


}
