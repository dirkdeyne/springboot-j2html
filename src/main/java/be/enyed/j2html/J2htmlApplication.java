package be.enyed.j2html;

import static j2html.TagCreator.body;
import static j2html.TagCreator.document;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.html;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class J2htmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(J2htmlApplication.class, args);
	}
	
	@GetMapping("/")
	public String home(){
		return "redirect:/hello/Hello j2html World";
	}
	
	@GetMapping("/hello/{message}")
	@ResponseBody
	public String hello(@PathVariable String message ){
		return document(
				html(
					body(
							h1().withText(message)
						)
					)
			);
	}	
	
}
