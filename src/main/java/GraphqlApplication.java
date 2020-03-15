import dao.PersonRepository;
import dao.QuestionRepository;
import model.Person;
import model.Question;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PersonRepository personRepository, QuestionRepository questionRepository) {
		return (args) -> {

			Person linus = new Person("Linus", "Torvalds");
			Person bill = new Person("Bill", "Gates");
			Person john = new Person("John", "Carmack");
			Person elon = new Person("Elon", "Musk");
			Person mark = new Person("Mark", "Zuckerberg");

			personRepository.save(linus);
			personRepository.save(bill);
			personRepository.save(john);
			personRepository.save(elon);
			personRepository.save(mark);

			Stream.of(
					new Question("What is graphql?", 23, elon),
					new Question("How to graphql?", 12, elon),
					new Question("Why my code doesn't work?", 87, bill),
					new Question("Why my code works?", 23, linus),
					new Question("How to exit vim?", 9999, john)
			).forEach(question -> questionRepository.save(question));
		};
	}
}
