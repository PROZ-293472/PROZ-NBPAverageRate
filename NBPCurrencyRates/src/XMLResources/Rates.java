package XMLResources;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Rates {
	private String table;
	private String name;
	private String code;
	private List<Rate> rates = new ArrayList<Rate>();

	public Rates() {
	}

	public Rates(String table, String name, String code, List<Rate> rates) {
		this.table = table;
		this.name = name;
		this.code = code;
		this.rates = rates;
	}

	public Double averageBid() {
		Double sum = 0.0;
		for (Rate r : rates) {
			sum += r.getBid();
		}
		sum = sum / rates.size();
		return sum > 0 ? sum : 0.0;
	}

	public Double averageMid() {
		Double sum = 0.0;
		for (Rate r : rates) {
			sum += r.getMid();
		}
		sum = sum / rates.size();
		return sum > 0 ? sum : 0.0;
	}

	public Double averageAsk() {
		Double sum = 0.0;
		for (Rate r : rates) {
			sum += r.getAsk();
		}
		sum = sum / rates.size();
		return sum > 0 ? sum : 0.0;
	}

	@XmlElement(name = "Table")
	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	@XmlElement(name = "Currency")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@XmlElementWrapper(name = "Rates")
	@XmlElement(name = "Rate")
	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

}
