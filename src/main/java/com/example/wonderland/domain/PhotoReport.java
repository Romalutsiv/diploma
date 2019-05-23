package com.example.wonderland.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class PhotoReport {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Поле не повинно бути пустим")
    private String name;
    private String filenames;
    private String string;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
    public String getFilenames() {
        return filenames;
    }

    public void setFilenames(String filenames) {
        this.filenames = filenames;
    }


    public PhotoReport() {
    }

    public PhotoReport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEmpty(String s){
        if(!(s.equals(""))) return true;
        return false;
    }
  }
