package Internet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;
import org.json.XML;

import API.PrepData;

@Path("exchangerates/rates/{table}/{code}/{topCount}")
public class GETResources {

	@GET
	@Produces(MediaType.TEXT_XML)
	public String xmlRequest(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {

		String xml = PrepData.createTaskResponse(table, code, topCount);
		return xml;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String jsonRequest(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		try {
			String xml = PrepData.createTaskResponse(table, code, topCount);
			JSONObject json = XML.toJSONObject(xml);
			return json.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "{\"blad\"}";
		}
	}
}
