package model;

import javax.persistence.*;

@Table
@Entity
public class Question {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Integer id;

    private String question;
    private Integer points;

    @ManyToOne
    @JoinColumn
    private Person author;

    public Question() {
    }

    public Question(String question, Integer points, Person author){
        this.question = question;
        this.points = points;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person person) {
        this.author = person;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", points=" + points +
                ", person=" + author +
                '}';
    }
}
