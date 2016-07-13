package Yoda;
import java.util.Scanner;
import java.util.ArrayList;
public class YodaSpeakRecursive {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a sentence padowan");
        String sentence = in.nextLine();
        ArrayList<String> ends = new ArrayList<String>();
        for(String s: sentence.split(" ")) {

            ends.add(s);

        }
        String end = yodaSpeakRecursive(ends);
        System.out.println(end);


    }

    public static String yodaSpeakRecursive(ArrayList<String> sentence) {

        if(sentence.size() ==1) {

            return sentence.get(0);
        }

        else  {
            String word = sentence.get(sentence.size() - 1);
            sentence.remove(sentence.size() -1);
            return (word + " " + yodaSpeakRecursive(sentence));



        }


    }
}
