package hello;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class DataAccessObject {

//	public static long kbNumber() {
//		Date date = new Date();
//		long timeStamp = date.getTime();
//		return timeStamp;
//	}
// Moved kbNumber() and setup getters & setters so that attribute can be accessed like the others.

	public void saveKb(String fileName, Kb article) {
		// changed article.kbNumber() to article.getKbNumber() This may explain why the
		// value did not match.
		// No that is not it. KBA-1560717163924 yet KBA-1560717163822 is actually
		// written to the file.
		
					System.out.println("About to call getKbNumber");
Long n = article.generateKbNumber();
System.out.println("n="+n);
	  article.setKbNumber(n);
		String kbData = "KBA-" + article.getKbNumber() + " " + article.getTitle() + ", " + article.getKeywords() + ", "
				+ article.getSummary() + ", " + article.getSolution() + ", " + article.getAppliesTo();

		try {
			FileWriter fileWriter = new FileWriter(fileName, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println(kbData);
			printWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
