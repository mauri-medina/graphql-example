package resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import model.Person;
import model.Question;
import service.PersonService;
import service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private PersonService personService;

    @Autowired
    private QuestionService questionService;

    public List<Person> findAllPersons(){
        return personService.findAllPersons();
    }

    public Person findPerson(Integer id){
        return personService.findPerson(id);
    }

    public List<Question> findAllQuestions(){
        return questionService.findAllQuestions();
    }

    public Question findQuestion(Integer id){
        return questionService.findQuestion(id);
    }
}
