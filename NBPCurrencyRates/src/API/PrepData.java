package API;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import Internet.ClientNBP;
import XMLResources.Answer;
import XMLResources.Rate;
import XMLResources.Rates;

public abstract class PrepData {

	public static String createTaskResponse(String table, String code, String topCount) {
		Rates clientResponse = ClientNBP.createResponse(table, code, topCount);
		Answer answer = new Answer();
		answer.setName(clientResponse.getName());
		answer.setCode(clientResponse.getCode());
		answer.setTable(clientResponse.getTable());
		answer.setEffectiveDates(
				"to: " + clientResponse.getRates().get(clientResponse.getRates().size() - 1).getEffectiveDate()
						+ "from: " + clientResponse.getRates().get(0).getEffectiveDate());
		if(!clientResponse.hasMid()) answer.setAverageAsk(clientResponse.averageAsk().toString());
		else answer.setAverageAsk("No info");
		if(!clientResponse.hasMid()) answer.setAverageBid(clientResponse.averageBid().toString());
		else answer.setAverageBid("No info");
		if(clientResponse.hasMid()) answer.setAverageMid(clientResponse.averageMid().toString());
		else answer.setAverageMid("No info");
		
		String taskResponse = marshall(answer);
		return taskResponse;
	}

	public static Rates unmarshall(String xml) {
		try {
			JAXBContext jContext = JAXBContext.newInstance(Rates.class, Rate.class);
			Unmarshaller unmarshaller = jContext.createUnmarshaller();
			StringReader reader = new StringReader(xml);
			Rates rates = (Rates) unmarshaller.unmarshal(reader);
			return rates;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public static String marshall(Answer answer) {
		try {
			JAXBContext jc = JAXBContext.newInstance(Answer.class);
			Marshaller marsh = jc.createMarshaller();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter writer = new StringWriter();
			marsh.marshal(answer, writer);
			return writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
			return "<?xml version=\"1.0\"?>" + "<info>Error while marshalling.</info>";
		}
	}
}
