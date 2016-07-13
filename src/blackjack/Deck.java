package blackjack;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Deck {

    ArrayList<Card> deck = new ArrayList<>();

    public Deck() {

        ImageIcon card1 = new ImageIcon("src/blackjack/images/2s.jpg");
        Card twoS = new Card(card1, 2,"spade", "Two");
        ImageIcon card2 = new ImageIcon("src/blackjack/images/3s.jpg");
        Card threeS = new Card(card2, 3,"spade", "Three");
        ImageIcon card3 = new ImageIcon("src/blackjack/images/4s.jpg");
        Card fourS = new Card(card3, 4, "spade","Four");
        ImageIcon card4 = new ImageIcon("src/blackjack/images/5s.jpg");
        Card fiveS = new Card(card4, 5, "spade", "Five");
        ImageIcon card5 = new ImageIcon("src/blackjack/images/6s.jpg");
        Card sixS = new Card(card5, 6, "spade", "Six");
        ImageIcon card6 = new ImageIcon("src/blackjack/images/7s.jpg");
        Card sevenS = new Card(card6, 7, "spade" , "Seven");
        ImageIcon card7 = new ImageIcon("src/blackjack/images/8s.jpg");
        Card eightS = new Card(card7, 8, "spade", "Eight");
        ImageIcon card8 = new ImageIcon("src/blackjack/images/9s.jpg");
        Card nineS = new Card(card8, 9,"spade", "Nine");
        ImageIcon card9 = new ImageIcon("src/blackjack/images/10s.jpg");
        Card tenS = new Card(card9, 10,"spade", "Ten");
        ImageIcon card10 = new ImageIcon("src/blackjack/images/jacks.jpg");
        Card jackS = new Card(card10, 10, "spade", "Jack");
        ImageIcon card11 = new ImageIcon("src/blackjack/images/queens.jpg");
        Card queenS = new Card(card11, 10,"spade", "Queen");
        ImageIcon card12 = new ImageIcon("src/blackjack/images/kings.jpg");
        Card kingS = new Card(card12, 10, "spade", "King");
        ImageIcon card13 = new ImageIcon("src/blackjack/images/aces.jpg");
        Card aceS = new Card(card13, 11, "spade", "Ace");

        ImageIcon card14 = new ImageIcon("src/blackjack/images/2h.jpg");
        Card twoH = new Card(card14, 2,"heart", "Two");
        ImageIcon card15 = new ImageIcon("src/blackjack/images/3h.jpg");
        Card threeH = new Card(card15, 3, "heart","Three");
        ImageIcon card16 = new ImageIcon("src/blackjack/images/4h.jpg");
        Card fourH = new Card(card16, 4, "heart", "Four");
        ImageIcon card17 = new ImageIcon("src/blackjack/images/5h.jpg");
        Card fiveH = new Card(card17, 5,"heart", "Five");
        ImageIcon card18 = new ImageIcon("src/blackjack/images/6h.jpg");
        Card sixH = new Card(card18, 6,"heart", "Six");
        ImageIcon card19 = new ImageIcon("src/blackjack/images/7h.jpg");
        Card sevenH = new Card(card19, 7,"heart", "Seven");
        ImageIcon card20 = new ImageIcon("src/blackjack/images/8h.jpg");
        Card eightH = new Card(card20, 8,"heart", "Eight");
        ImageIcon card21 = new ImageIcon("src/blackjack/images/9h.jpg");
        Card nineH = new Card(card21, 9, "heart","Nine");
        ImageIcon card22 = new ImageIcon("src/blackjack/images/10h.jpg");
        Card tenH = new Card(card22, 10,"heart", "Ten");
        ImageIcon card23 = new ImageIcon("src/blackjack/images/jackh.jpg");
        Card jackH = new Card(card23, 10, "heart","Jack");
        ImageIcon card24 = new ImageIcon("src/blackjack/images/queenh.jpg");
        Card queenH = new Card(card24, 10,"heart", "Queen");
        ImageIcon card25 = new ImageIcon("src/blackjack/images/kingh.jpg");
        Card kingH = new Card(card25, 10,"heart", "King");
        ImageIcon card26 = new ImageIcon("src/blackjack/images/aceh.jpg");
        Card aceH = new Card(card26, 11, "heart", "Ace");

        ImageIcon card27 = new ImageIcon("src/blackjack/images/2d.jpg");
        Card twoD = new Card(card27, 2,"diamond", "Two");
        ImageIcon card28 = new ImageIcon("src/blackjack/images/3d.jpg");
        Card threeD = new Card(card28, 3,"diamond", "Three");
        ImageIcon card29 = new ImageIcon("src/blackjack/images/4d.jpg");
        Card fourD = new Card(card29, 4,"diamond", "Four");
        ImageIcon card30 = new ImageIcon("src/blackjack/images/5d.jpg");
        Card fiveD = new Card(card30, 5,"diamond", "Five");
        ImageIcon card31 = new ImageIcon("src/blackjack/images/6d.jpg");
        Card sixD = new Card(card31, 6, "diamond", "Six");
        ImageIcon card32 = new ImageIcon("src/blackjack/images/7d.jpg");
        Card sevenD = new Card(card32, 7,"diamond", "Seven ");
        ImageIcon card33 = new ImageIcon("src/blackjack/images/8d.jpg");
        Card eightD = new Card(card33, 8, "diamond", "Eight");
        ImageIcon card34 = new ImageIcon("src/blackjack/images/9d.jpg");
        Card nineD = new Card(card34, 9, "diamond", "Nine");
        ImageIcon card35 = new ImageIcon("src/blackjack/images/10d.jpg");
        Card tenD = new Card(card35, 10, "diamond", "Ten");
        ImageIcon card36 = new ImageIcon("src/blackjack/images/jackd.jpg");
        Card jackD = new Card(card36, 10, "diamond", "Jack");
        ImageIcon card37 = new ImageIcon("src/blackjack/images/queend.jpg");
        Card queenD = new Card(card37, 10, "diamond", "Queen");
        ImageIcon card38 = new ImageIcon("src/blackjack/images/kingd.jpg");
        Card kingD = new Card(card38, 10,"diamond", "King");
        ImageIcon card39 = new ImageIcon("src/blackjack/images/aced.jpg");
        Card aceD = new Card(card39, 11,"diamond", "Ace");

        ImageIcon card40 = new ImageIcon("src/blackjack/images/2c.jpg");
        Card twoC = new Card(card40, 2,"club", "Two");
        ImageIcon card41 = new ImageIcon("src/blackjack/images/3c.jpg");
        Card threeC = new Card(card41, 3,"club", "Three");
        ImageIcon card42 = new ImageIcon("src/blackjack/images/4c.jpg");
        Card fourC = new Card(card42, 4,"club", "Four");
        ImageIcon card43 = new ImageIcon("src/blackjack/images/5c.jpg");
        Card fiveC = new Card(card43, 5,"club", "Five");
        ImageIcon card44 = new ImageIcon("src/blackjack/images/6c.jpg");
        Card sixC = new Card(card44, 6,"club", "Six");
        ImageIcon card45 = new ImageIcon("src/blackjack/images/7c.jpg");
        Card sevenC = new Card(card45, 7,"club", "Seven");
        ImageIcon card46 = new ImageIcon("src/blackjack/images/8c.jpg");
        Card eightC = new Card(card46, 8,"club", "Eight");
        ImageIcon card47 = new ImageIcon("src/blackjack/images/9c.jpg");
        Card nineC = new Card(card47, 9,"club", "Nine");
        ImageIcon card48 = new ImageIcon("src/blackjack/images/10c.jpg");
        Card tenC = new Card(card48, 10,"club", "Ten");
        ImageIcon card49 = new ImageIcon("src/blackjack/images/jackc.jpg");
        Card jackC = new Card(card49, 10,"club", "Jack");
        ImageIcon card50 = new ImageIcon("src/blackjack/images/queenc.jpg");
        Card queenC = new Card(card50, 10,"club", "Queen");
        ImageIcon card51 = new ImageIcon("src/blackjack/images/kingc.jpg");
        Card kingC = new Card(card51, 10,"club", "King");
        ImageIcon card52 = new ImageIcon("src/blackjack/images/acec.jpg");
        Card aceC = new Card(card52, 11,"club", "Ace");

        for (int i =0; i<6; i++) {

            deck.add(twoS);
            deck.add(threeS);
            deck.add(fourS);
            deck.add(fiveS);
            deck.add(sixS);
            deck.add(sevenS);
            deck.add(eightS);
            deck.add(nineS);
            deck.add(tenS);
            deck.add(jackS);
            deck.add(queenS);
            deck.add(kingS);
            deck.add(aceS);

            deck.add(twoH);
            deck.add(threeH);
            deck.add(fourH);
            deck.add(fiveH);
            deck.add(sixH);
            deck.add(sevenH);
            deck.add(eightH);
            deck.add(nineH);
            deck.add(tenH);
            deck.add(jackH);
            deck.add(queenH);
            deck.add(kingH);
            deck.add(aceH);

            deck.add(twoD);
            deck.add(threeD);
            deck.add(fourD);
            deck.add(fiveD);
            deck.add(sixD);
            deck.add(sevenD);
            deck.add(eightD);
            deck.add(nineD);
            deck.add(tenD);
            deck.add(jackD);
            deck.add(queenD);
            deck.add(kingD);
            deck.add(aceD);

            deck.add(twoC);
            deck.add(threeC);
            deck.add(fourC);
            deck.add(fiveC);
            deck.add(sixC);
            deck.add(sevenC);
            deck.add(eightC);
            deck.add(nineC);
            deck.add(tenC);
            deck.add(jackC);
            deck.add(queenC);
            deck.add(kingC);
            deck.add(aceC);
        }

    }




    public Card getCard() {

        Random rand = new Random();
        int chosenCard = rand.nextInt(deck.size());
        Card temp = deck.get(chosenCard);
        deck.remove(temp);
        return temp;
    }



}