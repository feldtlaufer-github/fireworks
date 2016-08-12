package huecomundo.muhich.fireworks_prime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Discard {
    private static ArrayList<Card> discard;
    private String stringifiedDiscard;
    public Discard(){
        discard = new ArrayList<>();
    }
    public void addToDiscard(Card card){ discard.add(card); }
    private void sortDiscard(){
        Collections.sort(discard, new Comparator<Card>(){
            public int compare(Card c1, Card c2) {
                return c1.compareTo(c2);
            }
        });
    }
    //TODO: make this look not like shit
    @Override
    public String toString(){
        stringifiedDiscard = "DISCARD\n";
        sortDiscard();
        for(Card c: discard){
            stringifiedDiscard += c.toString() + " ";
        }
        return stringifiedDiscard;
    }
}
