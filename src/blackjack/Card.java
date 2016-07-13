package blackjack;


import javax.swing.*;

public class Card {

    protected ImageIcon cardImage;
    protected String type;
    protected int value;
    protected String suit;

    public Card(ImageIcon x, int value, String suit, String type) {

        cardImage = x;
        this.type =type;
        this.value = value;
        this.suit = suit;
    }



    public ImageIcon getImage() {

        return cardImage;
    }

    public int getValue() {

        return value;
    }

    public void setValue(int n) {

        value = n;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {

        return "Face: " + type + "\nSuit: " + suit + "\nValue: " + value;
    }
}