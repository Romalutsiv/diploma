package com.example.wonderland.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Поле не повинно бути пустим")
    private String name;

    @NotBlank(message = "Поле не повинно бути пустим")
    private String text;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String price;
    @NotBlank(message = "Поле не повинно бути пустим")
    private String weight;

    private DishType dishType;
    private String dishTypeStr;
    private String filename;


    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Dish() {
    }

    public Dish(String name, String text, String price, String weight, DishType dishType) {
        this.name = name;
        this.text = text;
        this.dishType = dishType;
        this.dishTypeStr = this.dishType.toString(this.dishType.ordinal());
        this.weight = weight;
        this.price = price;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public DishType getDishType() {
        return dishType;
    }

    public void setDishType(DishType dishType) {
        this.dishType = dishType;
        this.dishTypeStr = this.dishType.toString(this.dishType.ordinal());
    }

    public String getDishTypeStr() {
        return dishTypeStr;
    }

    public void setDishTypeStr(String dishTypeStr) {
        this.dishTypeStr = dishTypeStr;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
