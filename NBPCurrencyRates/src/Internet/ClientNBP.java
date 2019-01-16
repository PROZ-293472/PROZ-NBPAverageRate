package Internet;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import API.PrepData;
import XMLResources.Rates;

public class ClientNBP {

	static private WebTarget webTarget;

	static public Rates createResponse(String table, String code, String topCount) {

		Client client = ClientBuilder.newClient();
		String sourceUrl = new String(
				"http://api.nbp.pl/api/exchangerates/rates/" + table + "/" + code + "/last/" + topCount + "/");

		URI uri = URI.create(sourceUrl);
		webTarget = client.target(uri);
		String serverResponse = webTarget.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
		String xmlText = webTarget.request().accept(MediaType.TEXT_XML).get(String.class);
		if (serverResponse.contains("OK")) {
			Rates rates = PrepData.unmarshall(xmlText);
			return rates;
		} else
			return null;
	}

}
