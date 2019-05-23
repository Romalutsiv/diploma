package com.example.wonderland.domain;

public enum DishType {
    HOTDRINK, COLDDRINK, ALCOGOL, COLDSNAK, HOTSNAK, SALAT, GARNISH, DESERT, COCKTAIL, FIRSTDISH;


    public String toString(int index) {
        String newType = "";
        switch (index){
            case (0):
                newType = "Гарячі напої";
                break;
            case (1):
                newType = "Холодні напої";
                break;
            case (2):
                newType = "Алкогольні напої";
                break;
            case (3):
                newType = "Холодні закуски";
                break;
            case (4):
                newType = "Гарячі закуски";
                break;
            case (5):
                newType = "Салати";
                break;
            case (6):
                newType = "Гарніри";
                break;
            case (7):
                newType = "Десерти";
                break;
            case (8):
                newType = "Коктелі";
                break;
            case (9):
                newType = "Перші страви";
                break;
        }
        return newType;
    }
}
