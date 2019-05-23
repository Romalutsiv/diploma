package com.example.wonderland.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Поле не повинно бути пустим")
    private String name;

    @NotBlank(message = "Поле не повинно бути пустим")
    private String text;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Post() {
    }

    public Post(String name, String text, User user) {
        this.author = user;
        this.name = name;
        this.text = text;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
