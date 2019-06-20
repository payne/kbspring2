package dev.dustinwright.kbspring2;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Date;

public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    @NotNull
    @Min(2)
    private Integer yearsExperience;
    
    @NotEmpty
    @Email(message = "Email should be valid")
    private String email;

    @NotNull
    @Min(value = 00501, message = "The minimum valid 5 digit zip code is 00501") // see PLAN.md this is not working
    @Max(value = 99950, message = "The maximum valid 5 digit zip code is 99950")
    private Long zip;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    public void setYearsExperience(Integer yearsExperience) {
        this.yearsExperience = yearsExperience;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getZip() {
        return this.zip;
    }

    public void setZip(Long zip) {
        this.zip = zip;
    }

	public static long kbNumber() {
		Date date = new Date();
		long timeStamp = date.getTime();
		return timeStamp;
	}

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ", Zip: " + this.zip + ")";
    }

    public void savePerson(String fileName, PersonForm person) {        
            String personData = "KBA-" + kbNumber() + " " + getName() + ", " +  getAge() + ", " + getYearsExperience() + ", " + getEmail() + ", " + getZip();
            
            try {
                FileWriter fileWriter = new FileWriter(fileName, true);
                PrintWriter printWriter = new PrintWriter(fileWriter);
                printWriter.println(personData);
                printWriter.close();                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
