package resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import model.Person;
import model.Question;
import service.PersonService;
import service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private PersonService personService;

    @Autowired
    private QuestionService questionService;

    public Person createPerson(String firstName, String lastName){
        return personService.createPerson(firstName, lastName);
    }

    public Boolean deletePerson(Integer id){
        return personService.deletePerson(id);
    }

    public Person updatePerson(Integer id, String firstName, String lastName){
        return personService.updatePerson(id, firstName, lastName);
    }

    public Question createQuestion(String question, Integer authorID){
        return questionService.createQuestion(question, authorID);
    }
}
