package com.brunobarbosa.todolist_api.entities;

import com.brunobarbosa.todolist_api.exceptions.EntityArgumentException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    @Size(min = 1, max = 100, message = "message = \"A descrição deve ter entre 1 e 100 caracteres.\"")
    private String description;

    private LocalDateTime date;
    private boolean done;

    protected Todo(){}

    private Todo(String title,
                String description,
                LocalDateTime date,
                boolean done) {

        validate(title, description, date);

        this.title = title;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    // Factory method
    public static Todo create(String title, String description, LocalDateTime date, boolean done){
        return new Todo(title, description, date, done);
    }

    public void update(String title, String description, LocalDateTime date, boolean done){
        validate(title, description, date);
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public void complete(){
        this.done = true;
    }

    private static void validate(String title, String description, LocalDateTime date){

        if(title == null || title.trim().isBlank()){
            throw new EntityArgumentException("O titulo deve ser preenchido.");
        }
        if(description == null || description.trim().isBlank()){
            throw new EntityArgumentException("A descrição deve ser preenchida.");
        }
        if(description.length() > 100){
            throw new EntityArgumentException("A descrição deve ter entre 100 caracteres.");
        }
        if(date == null){
            throw new EntityArgumentException("A data deve ser preenchida.");
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public boolean isDone() {
        return done;
    }
}
