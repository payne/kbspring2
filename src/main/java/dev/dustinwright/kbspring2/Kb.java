package hello;

import java.util.Date;

public class Kb {

	private Long kbNumber;
	private String title;
	private String keywords;
	private String summary;
	private String solution;
	private String appliesTo;

	public Long getKbNumber() {
		return this.kbNumber;
	}

	public void setKbNumber(Long k) {
		this.kbNumber = k;
		System.out.println("\n\nJust set this.kbNumber="+this.kbNumber);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getAppliesTo() {
		return appliesTo;
	}

	public void setAppliesTo(String appliesTo) {
		this.appliesTo = appliesTo;
	}

	public Long generateKbNumber() {
		Date date = new Date();
		long timeStamp = date.getTime();
		Long rval =  new Long(timeStamp); // TODO(DEW): read about Autoboxing
		System.out.println("About to return " + rval);
		return rval;
	}

	public String toString() {
		return "KB Article: (Number: " + this.kbNumber + ", Title: " + this.title + ", Keywords: " + this.keywords
				+ ", Summary: " + this.summary + ", Solution: " + this.solution + ", Applies To: " + this.appliesTo
				+ ")";
	}
}
