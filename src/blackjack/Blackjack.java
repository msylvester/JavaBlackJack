package blackjack;

public class Blackjack {

    public Person mPerson;
    public Computer mComputer;
    private Deck mDeck;

    public Blackjack(Person person, Computer computer) {
        
        this.mPerson = person;
        this.mComputer = computer;
        mDeck = new Deck();
    }

    public void dealInitialCards() {

        mPerson.addCard(this.mDeck.getCard());
        mComputer.addCard(this.mDeck.getCard());
        mPerson.addCard(this.mDeck.getCard());
        mComputer.addCard(this.mDeck.getCard());

    }


    public void aceCheck(Object o) {

        for (Card c: mComputer.getHand()) {
            if(c.getType() == "Ace") {

                c.setValue(1);
                mComputer.setRoundScore(-10);
            }

        }


    }

    public void hit(Object o) {

        Card c = mDeck.getCard();



        if(o instanceof  Computer ) {
            mComputer.addCard(c);


            if(mComputer.getRoundScore() <=16) {

                hit(o);
            }
            else if(mComputer.getRoundScore() == 17) {

                computeComputerScore(o,c);
            }

            else if(mComputer.getRoundScore() > 21) {

                aceCheck(0);
            }

         //   computeComputerScore(o, c);
           // mComputer.addCard(c);

        }

        else if(o instanceof Person) {

            mPerson.addCard(c);
        }



    }


    public boolean blackjack(Object o) {

        if (o instanceof Person) {

            if (mPerson.getRoundScore() == 21)
                return true;
        }

        else if (o instanceof Computer) {

            if (mPerson.getRoundScore() == 21)
                return true;
        }

        return false;
    }

    public boolean isBust(Object o) {

        if (o instanceof  Computer) {

           if(mComputer.getRoundScore() > 21)
               return true;

        }

        else if (o instanceof  Person) {

            if(mPerson.getRoundScore() > 21)
                return true;
        }

        return false;
    }



    public Participant getWinner() {

        if(!isBust(mPerson) && isBust(mComputer)) {
            return mPerson;
        }

        if(isBust(mPerson) && !isBust(mComputer)) {

            return mComputer;
        }
        if(mPerson.getRoundScore() > mComputer.getRoundScore() &&
                !isBust(mPerson) && !isBust(mComputer)) {

            return mPerson;
        }

        else if (mComputer.getRoundScore() > mPerson.getRoundScore() &&
                !isBust(mComputer) && !isBust(mPerson)) {

            return mComputer;
        }

        else
            return new Participant();


    }

    public void computeComputerScore(Object o, Card c) {

        if(mComputer.getRoundScore() + c.getValue() <= 16) {
            this.hit(o);
        }

        else if(mComputer.getRoundScore() + c.getValue() ==17) {

            for (Card d :mComputer.getHand()) {

                if (d.getType().equals("Ace")) {
                    this.hit(o);
                }

            }

        }

    }



}

