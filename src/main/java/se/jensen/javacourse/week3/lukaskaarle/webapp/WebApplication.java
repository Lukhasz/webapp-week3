package se.jensen.javacourse.week3.lukaskaarle.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Welcome. Please use \"/author\", \"/author/name\", \"/square-number/*number*\", or \"/square-root/*number*\"";
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
	public String readSquare(@PathVariable(name = "nr") double squared) {
		return "the square of " + squared + " is " + squared * squared;
	}

	@GetMapping("/square-root/{nr}")
	public String readSquareRoot(@PathVariable(name = "nr") double squareRoot) {
			return "square root of " + (squareRoot) + " is " + Math.sqrt(squareRoot) ;
	}
}
