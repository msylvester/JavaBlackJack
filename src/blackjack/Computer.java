package blackjack;

import java.util.ArrayList;

public class Computer extends Participant{

    private int roundTotal = 0;
    private ArrayList<Card> Cards = new ArrayList<Card>(2);

    public Computer() {

        this.roundTotal =0;
    }

    public void addCard(Card c) {
        if(c.getType().equals("Ace")) {

            c.setValue(aceValue(c));
        }

        Cards.add(c);
        setRoundScore(c);
    }

    public void setRoundScore(Card c) {
        this.roundTotal += c.value;
        System.out.println(this.roundTotal);
    }

    public void setRoundScore(int n) {

        this.roundTotal += n;
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


        this.roundTotal =0;
        this.Cards.clear();
    }

    public String toString() {

        return "Computer ";
    }

}
