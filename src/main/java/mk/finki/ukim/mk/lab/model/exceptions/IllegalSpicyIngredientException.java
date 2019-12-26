package mk.finki.ukim.mk.lab.model.exceptions;

public class IllegalSpicyIngredientException extends RuntimeException{
    public IllegalSpicyIngredientException() {
        super("Can't have more than 3 spicy ingredients in the menu !");
    }

}
