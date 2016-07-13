package blackjack;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends JPanel {

    JLabel playerCard1;
    JLabel playerCard2;
    JLabel computerCard0;
    JLabel computerCard2;
    JLabel computerCard1;
    JLabel computerCardHit;

    JLabel computerLabel = new JLabel();
    JLabel playerLabel = new JLabel();

    JPanel topPanel = new JPanel();
    JPanel computerPanel = new JPanel();
    JPanel playerPanel = new JPanel();
    JPanel cardPanel = new JPanel();
    JPanel computerCardPanel = new JPanel();
    JButton hitButton = new JButton();
    JButton dealButton = new JButton();
    JButton stayButton = new JButton();
    JButton playAgainButton = new JButton();
    JButton bet25Button = new JButton();


    JTextPane outcomeBox = new JTextPane();
    JTextPane moneyBox = new JTextPane();

    Person mPerson = new Person("Thomas Kelly" , 1000);
    Computer mComputer = new Computer();
    Blackjack game = new Blackjack(mPerson, mComputer);

    public GUI() {

        topPanel.setBackground(Color.WHITE);
        computerPanel.setBackground(Color.WHITE);
        playerPanel.setBackground(Color.WHITE);

        topPanel.setLayout(new FlowLayout());

        outcomeBox.setText("");
        outcomeBox.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        outcomeBox.setBackground(Color.WHITE);

        moneyBox.setText("$" + Integer.toString(game.mPerson.getMoney()));
        moneyBox.setFont(new java.awt.Font("Arial", Font.BOLD, 16));
        moneyBox.setBackground(Color.WHITE);

        dealButton.setText("  Deal");
        dealButton.addActionListener(new DealButton());
        dealButton.setEnabled(false);

        hitButton.setText("  Hit");
        hitButton.addActionListener(new HitButton());
        hitButton.setEnabled(false);

        stayButton.setText(" Stay");
        stayButton.addActionListener(new StayButton());
        stayButton.setEnabled(false);

        playAgainButton.setText(" Play Again");
        playAgainButton.addActionListener(new PlayAgainButton());
        playAgainButton.setEnabled(false);

        bet25Button.setText("$25");
        bet25Button.addActionListener(new BetButton());

        computerLabel.setText(" Computer:  ");
        playerLabel.setText(" You:  ");

        topPanel.add(outcomeBox);
        topPanel.add(dealButton);
        topPanel.add(hitButton);
        topPanel.add(stayButton);
        topPanel.add(playAgainButton);

        computerPanel.add(computerLabel);

        playerPanel.add(bet25Button);
        playerPanel.add(moneyBox);
        playerPanel.add(playerLabel);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(computerPanel, BorderLayout.CENTER);
        add(computerCardPanel, BorderLayout.EAST);
        add(playerPanel, BorderLayout.SOUTH);
        add(cardPanel, BorderLayout.WEST);
    }

    public void display() {

        JFrame frame = new JFrame("BlackJack");

        frame.setContentPane(this);
        frame.setPreferredSize(new Dimension(1000, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }

    class BetButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            dealButton.setEnabled(true);

        }
    }

    class DealButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            computerCard0 = new JLabel(new ImageIcon("src/blackjack/images/back.jpg"));
            game.mPerson.reset();
            game.mComputer.reset();
            game.dealInitialCards();

            Card computerCard = null;
            Iterator<Card> computerScan = game.mComputer.getHand().iterator();
            int count = 0;

            while (computerScan.hasNext()) {

                computerCard = computerScan.next();
                if(count==0)
                    computerCard1 = new JLabel(computerCard.getImage());
                else
                    computerCard2 = new JLabel(computerCard.getImage());

                count++;
            }

            Iterator<Card> playerScan = game.mPerson.getHand().iterator();
            count = 0;
            while (playerScan.hasNext()) {

                Card playerCard = playerScan.next();

                if(count==0)
                    playerCard1 = new JLabel(playerCard.getImage());
                else
                    playerCard2 = new JLabel(playerCard.getImage());

                count++;
            }
            computerCardPanel.add(computerCard0);
            computerCardPanel.add(computerCard2);

            cardPanel.add(playerCard1);
            cardPanel.add(playerCard2);

            computerLabel.setText("  Computer:  " + computerCard.getValue());
            playerLabel.setText("  You:  " + game.mPerson.getRoundScore());

            hitButton.setEnabled(true);
            stayButton.setEnabled(true);
            dealButton.setEnabled(false);

            if(game.blackjack(mComputer) || game.blackjack(mPerson)) {

                hitButton.setEnabled(false);
                stayButton.setEnabled(false);
                dealButton.setEnabled(false);
                playAgainButton.setEnabled(true);
                outcomeBox.setText("BlackJack");
            }
            add(computerPanel, BorderLayout.CENTER);
            add(playerPanel, BorderLayout.SOUTH);
        }
    }

    class HitButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            game.hit(mPerson);

            Card personCard;
            Iterator<Card> scan = (game.mPerson.getHand()).iterator();

            cardPanel.removeAll();


            while (scan.hasNext()) {
                personCard = scan.next();
                playerCard1 = new JLabel(personCard.getImage());
                cardPanel.add(playerCard1);
            }
            if(game.isBust(mPerson)) {
                game.mPerson.loseMoney();
                outcomeBox.setText("Bust");
                hitButton.setEnabled(false);
                dealButton.setEnabled(false);
                stayButton.setEnabled(false);
                playAgainButton.setEnabled(true);
            }


            playerLabel.setText("  You:   " + game.mPerson.getHand());
            playerLabel.setText("  You:  " + game.mPerson.getRoundScore());
        }
    }

    class StayButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            computerPanel.remove(computerCard0);
            computerPanel.add(computerCard1);
            computerCardPanel.removeAll();

            if(game.mComputer.getRoundScore() <= 16){
                game.hit(mComputer);
            }
            computerPanel.removeAll();
            computerPanel.add(computerLabel);


            Card computerHitCard;
            Iterator<Card> scan = (mComputer.getHand()).iterator();
            computerLabel.setText("  Computer:  " + game.mComputer.getRoundScore());


            while (scan.hasNext()) {

                computerHitCard = scan.next();
                computerCardHit = new JLabel(computerHitCard.getImage());
                computerCardPanel.add(computerCardHit);
            }


            playerLabel.setText("You: " + game.mPerson.getRoundScore());

            if(game.getWinner() instanceof  Person) {

                game.mPerson.winMoney();
                moneyBox.setText(Integer.toString(game.mPerson.getMoney()));
            }

            else if(game.getWinner() instanceof  Computer) {

                game.mPerson.loseMoney();
                moneyBox.setText(Integer.toString(game.mPerson.getMoney()));
            }
            outcomeBox.setText(game.getWinner().toString() + " wins!");
            game.mPerson.reset();
            game.mComputer.reset();
            hitButton.setEnabled(false);
            stayButton.setEnabled(false);

            playAgainButton.setEnabled(true);


            if(game.mPerson.getMoney() <= 0) {

                cardPanel.removeAll();
                computerCardPanel.removeAll();
                computerPanel.removeAll();
                playerPanel.removeAll();
                hitButton.setEnabled(false);
                stayButton.setEnabled(false);
                playAgainButton.setEnabled(false);
                bet25Button.setEnabled(false);
                outcomeBox.setText("Game Over");

            }
        }
    }

    class PlayAgainButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            computerLabel.setText("Computer: ");
            playerLabel.setText("You: ");
            outcomeBox.setText("");
            moneyBox.setText(Integer.toString(game.mPerson.getMoney()));
            computerPanel.removeAll();
            playerPanel.removeAll();
            cardPanel.removeAll();
            computerCardPanel.removeAll();


            computerPanel.add(computerLabel);

            playerPanel.add(bet25Button);
            playerPanel.add(moneyBox);
            playerPanel.add(playerLabel);

            playAgainButton.setEnabled(false);
            bet25Button.setEnabled(true);

        }
    }
}
