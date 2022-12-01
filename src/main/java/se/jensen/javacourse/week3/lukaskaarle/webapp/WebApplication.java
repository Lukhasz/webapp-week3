package se.jensen.javacourse.week3.lukaskaarle.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebApplication {

	private double squareRoot;

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);



	}

	@GetMapping("/")
	public String index() {
		return "Greetings, please use /author, /author/name, or /square-number/{number, without curlies}";
	}

	@GetMapping("/author")
	public Person getPerson() {
		Person person = new Person(27, "Lukas", "Kaarle");
		return person;
	}

	@GetMapping("/author/name")
	public String author() {
		return "Lukas";
	}

	@GetMapping("/square-number/{nr}")
	public String read(@PathVariable(name = "nr") double squareRoot) {
		return "square root of " + squareRoot + " is " + Math.sqrt(squareRoot);
	}



}
