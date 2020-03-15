package service;

import dao.QuestionRepository;
import model.Person;
import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> findAllQuestions(){
        return questionRepository.findAll();
    }

    public Question findQuestion(Integer id){
        return questionRepository.findById(id).get();
    }

    public Question createQuestion(String questionText, Integer authorId){
        Question question = new Question();
        question.setQuestion(questionText);

        Person author = new Person(authorId);
        question.setAuthor(author);

        return questionRepository.save(question);
    }
}
