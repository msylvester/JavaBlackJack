package Yoda;
import java.util.*;

public class YodaSpeak {

    public static void main (String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a sentence: ");
        String sentence = in.nextLine();

        String[] words = sentence.split(" ");

        String[] backWords = new String[words.length];

        for (int i =0; i<words.length; i++) {

            backWords[i] = words[words.length - 1- i];
        }

        for (int i = 0; i<backWords.length; i++) {

            System.out.print(backWords[i] + " ");
        }


    }



}
