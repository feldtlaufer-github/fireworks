package huecomundo.muhich.fireworks_prime;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    public Hand(){
        hand = new ArrayList<>();
    }
    public ArrayList<Card> getHand(){ return hand; }

    public void addCard(Card card){ hand.add(0, card); }
    public Card removeCard(int index){ return hand.remove(index); }
    public Card peekCard(int index){ return hand.get(index); }
    public int size(){ return hand.size(); }
}