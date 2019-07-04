package dev.dustinwright.kbspring2;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {
	
	
	@Autowired
	private KbRepository kbRepository;
	
	@GetMapping("/")
	public String showKB() {
		return "kb/kb"; // First kb is the folder, second refers to the file kb.html
	}

	@PostMapping("/newKB")
	public String writeNewKB(Kb article, Model model) {
		System.out.println(article);
		DataAccessObject dao = new DataAccessObject();
		dao.saveKb("articles.txt", article);
		kbRepository.save(article);
		System.out.println("Back from saveKb article="+article);
    // https://www.baeldung.com/spring-mvc-model-model-map-model-view
    model.addAttribute("KB", article);
		return"kb/reviewNewKB";
	}
	
	@GetMapping("kb/newKB")
	public String showReviewNewKB() {
		return"kb/reviewNewKB";
	}
	
	@GetMapping("/newKB")
	public String showNewKB() {
		return"kb/newKB";
	}

	@GetMapping("/lookupKB")
	public String showLookupKB() {
		return"kb/lookupKB";
	}

	@GetMapping("/listAllKB")
	public String showListAllKB() {
		return"kb/listAllKB";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "form"; // refers to form.html
		}
		personForm.savePerson("data.txt", personForm);  // See PLAN.md
		return "results"; // refers to results.html
	}
}
