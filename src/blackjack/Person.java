package blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public class Person extends Participant {

    private int money = 0;
    private int roundTotal = 0;
    private String name;
    private ArrayList<Card> Cards = new ArrayList<Card>();

    public Person(String s, int money) {
        this.name = s;
        this.money = money;

    }

    public void addCard(Card c) {
        if(c.getType().equals("Ace")) {

            c.setValue(aceValue(c));
        }
        Cards.add(c);
        roundScore(c);
    }

    public void roundScore(Card c) {

        this.roundTotal += c.value;
    }


    public int aceValue(Card c) {

        if ((this.roundTotal + 11) > 21) {

            return 1;
        }

        else return 11;
    }

    public ArrayList<Card> getHand() {

        return this.Cards;

    }


    public int getRoundScore() {

        return this.roundTotal;
    }

    public void reset() {
    this.roundTotal = 0;
    this.Cards.clear();

    }

    public int getMoney() {

        return this.money;
    }

    public void loseMoney() {

        this.money = this.money -25;
    }


    public void winMoney() {

        this.money = this.money +25;
    }

    public String toString() {

        return this.name;

    }

}

