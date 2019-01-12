package XMLResources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rate")
public class Rate {
	private String no;
	private String effectiveDate;
	private Double bid;
	private Double ask;
	private Double mid;

	public Rate() {
	}

	public Rate(String no, String effectiveDate, Double bid, Double ask, Double mid) {
		this.no = no;
		this.effectiveDate = effectiveDate;
		this.bid = bid;
		this.ask = ask;
		this.mid = mid;
	}
	
	@XmlElement (name = "No")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@XmlElement (name = "EffectiveDate")
	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	
	@XmlElement (name = "Bid")
	public Double getBid() {
		return bid;
	}

	public void setBid(Double bid) {
		this.bid = bid;
	}
	
	@XmlElement (name = "Ask")
	public Double getAsk() {
		return ask;
	}

	public void setAsk(Double ask) {
		this.ask = ask;
	}

	@XmlElement (name = "Mid")
	public Double getMid() {
		return mid;
	}

	public void setMid(Double mid) {
		this.mid = mid;
	}
}
