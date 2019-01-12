package XMLResources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "TaskResponse")
public class Answer {
	private String name;
	private String code;
	private String table;
	private String effectiveDates;
	private String averageMid;
	private String averageBid;
	private String averageAsk;
	
	
	public Answer() {
		
	}

	/*public TaskResponse(String name, String code, String table, String effectiveDates, String averageMid,
			String averageBid, String averageAsk) {
		this.name = name;
		this.code = code;
		this.table = table;
		this.effectiveDates = effectiveDates;
		this.averageMid = averageMid;
		this.averageBid = averageBid;
		this.averageAsk = averageAsk;
	}*/
	
	@XmlElement (name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement (name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElement (name = "Table")
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@XmlElement (name = "EffectiveDates")
	public String getEffectiveDates() {
		return effectiveDates;
	}

	public void setEffectiveDates(String effectiveDates) {
		this.effectiveDates = effectiveDates;
	}

	@XmlElement (name = "AverageMid")
	public String getAverageMid() {
		return averageMid;
	}

	public void setAverageMid(String averageMid) {
		this.averageMid = averageMid;
	}
	
	@XmlElement (name = "AverageBid")
	public String getAverageBid() {
		return averageBid;
	}

	public void setAverageBid(String averageBid) {
		this.averageBid = averageBid;
	}

	@XmlElement (name = "AverageAsk")
	public String getAverageAsk() {
		return averageAsk;
	}

	public void setAverageAsk(String averageAsk) {
		this.averageAsk = averageAsk;
	}

}
