package huecomundo.muhich.fireworks_prime;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    public Deck(){
        deck = new ArrayList<>();
        deck.add(new Card(1, "WHITE", 0, R.drawable.card0, R.drawable.white, R.drawable.one, R.drawable.card0c, R.drawable.card0v, R.drawable.card0cv));
        deck.add(new Card(1, "WHITE", 1, R.drawable.card0, R.drawable.white, R.drawable.one, R.drawable.card0c, R.drawable.card0v, R.drawable.card0cv));
        deck.add(new Card(1, "WHITE", 2, R.drawable.card0, R.drawable.white, R.drawable.one, R.drawable.card0c, R.drawable.card0v, R.drawable.card0cv));
        deck.add(new Card(2, "WHITE", 3, R.drawable.card1, R.drawable.white, R.drawable.two, R.drawable.card1c, R.drawable.card1v, R.drawable.card1cv));
        deck.add(new Card(2, "WHITE", 4, R.drawable.card1, R.drawable.white, R.drawable.two, R.drawable.card1c, R.drawable.card1v, R.drawable.card1cv));
        deck.add(new Card(3, "WHITE", 5, R.drawable.card2, R.drawable.white, R.drawable.three, R.drawable.card2c, R.drawable.card2v, R.drawable.card2cv));
        deck.add(new Card(3, "WHITE", 6, R.drawable.card2, R.drawable.white, R.drawable.three, R.drawable.card2c, R.drawable.card2v, R.drawable.card2cv));
        deck.add(new Card(4, "WHITE", 7, R.drawable.card3, R.drawable.white, R.drawable.four, R.drawable.card3c, R.drawable.card3v, R.drawable.card3cv));
        deck.add(new Card(4, "WHITE", 8, R.drawable.card3, R.drawable.white, R.drawable.four, R.drawable.card3c, R.drawable.card3v, R.drawable.card3cv));
        deck.add(new Card(5, "WHITE", 9, R.drawable.card4, R.drawable.white, R.drawable.five, R.drawable.card4c, R.drawable.card4v, R.drawable.card4cv));
        deck.add(new Card(1, "BLUE", 10, R.drawable.card5, R.drawable.blue, R.drawable.one, R.drawable.card5c, R.drawable.card5v, R.drawable.card5cv));
        deck.add(new Card(1, "BLUE", 11, R.drawable.card5, R.drawable.blue, R.drawable.one, R.drawable.card5c, R.drawable.card5v, R.drawable.card5cv));
        deck.add(new Card(1, "BLUE", 12, R.drawable.card5, R.drawable.blue, R.drawable.one, R.drawable.card5c, R.drawable.card5v, R.drawable.card5cv));
        deck.add(new Card(2, "BLUE", 13, R.drawable.card6, R.drawable.blue, R.drawable.two, R.drawable.card6c, R.drawable.card6v, R.drawable.card6cv));
        deck.add(new Card(2, "BLUE", 14, R.drawable.card6, R.drawable.blue, R.drawable.two, R.drawable.card6c, R.drawable.card6v, R.drawable.card6cv));
        deck.add(new Card(3, "BLUE", 15, R.drawable.card7, R.drawable.blue, R.drawable.three, R.drawable.card7c, R.drawable.card7v, R.drawable.card7cv));
        deck.add(new Card(3, "BLUE", 16, R.drawable.card7, R.drawable.blue, R.drawable.three, R.drawable.card7c, R.drawable.card7v, R.drawable.card7cv));
        deck.add(new Card(4, "BLUE", 17, R.drawable.card8, R.drawable.blue, R.drawable.four, R.drawable.card8c, R.drawable.card8v, R.drawable.card8cv));
        deck.add(new Card(4, "BLUE", 18, R.drawable.card8, R.drawable.blue, R.drawable.four, R.drawable.card8c, R.drawable.card8v, R.drawable.card8cv));
        deck.add(new Card(5, "BLUE", 19, R.drawable.card9, R.drawable.blue, R.drawable.five, R.drawable.card9c, R.drawable.card9v, R.drawable.card9cv));
        deck.add(new Card(1, "YELLOW", 20, R.drawable.card10, R.drawable.yellow, R.drawable.one, R.drawable.card10c, R.drawable.card10v, R.drawable.card10cv));
        deck.add(new Card(1, "YELLOW", 21, R.drawable.card10, R.drawable.yellow, R.drawable.one, R.drawable.card10c, R.drawable.card10v, R.drawable.card10cv));
        deck.add(new Card(1, "YELLOW", 22, R.drawable.card10, R.drawable.yellow, R.drawable.one, R.drawable.card10c, R.drawable.card10v, R.drawable.card10cv));
        deck.add(new Card(2, "YELLOW", 23, R.drawable.card11, R.drawable.yellow, R.drawable.two, R.drawable.card11c, R.drawable.card11v, R.drawable.card11cv));
        deck.add(new Card(2, "YELLOW", 24, R.drawable.card11, R.drawable.yellow, R.drawable.two, R.drawable.card11c, R.drawable.card11v, R.drawable.card11cv));
        deck.add(new Card(3, "YELLOW", 25, R.drawable.card12, R.drawable.yellow, R.drawable.three, R.drawable.card12c, R.drawable.card12v, R.drawable.card12cv));
        deck.add(new Card(3, "YELLOW", 26, R.drawable.card12, R.drawable.yellow, R.drawable.three, R.drawable.card12c, R.drawable.card12v, R.drawable.card12cv));
        deck.add(new Card(4, "YELLOW", 27, R.drawable.card13, R.drawable.yellow, R.drawable.four, R.drawable.card13c, R.drawable.card13v, R.drawable.card13cv));
        deck.add(new Card(4, "YELLOW", 28, R.drawable.card13, R.drawable.yellow, R.drawable.four, R.drawable.card13c, R.drawable.card13v, R.drawable.card13cv));
        deck.add(new Card(5, "YELLOW", 29, R.drawable.card14, R.drawable.yellow, R.drawable.five, R.drawable.card14c, R.drawable.card14v, R.drawable.card14cv));
        deck.add(new Card(1, "RED", 30, R.drawable.card15, R.drawable.red, R.drawable.one, R.drawable.card15c, R.drawable.card15v, R.drawable.card15cv));
        deck.add(new Card(1, "RED", 31, R.drawable.card15, R.drawable.red, R.drawable.one, R.drawable.card15c, R.drawable.card15v, R.drawable.card15cv));
        deck.add(new Card(1, "RED", 32, R.drawable.card15, R.drawable.red, R.drawable.one, R.drawable.card15c, R.drawable.card15v, R.drawable.card15cv));
        deck.add(new Card(2, "RED", 33, R.drawable.card16, R.drawable.red, R.drawable.two, R.drawable.card16c, R.drawable.card16v, R.drawable.card16cv));
        deck.add(new Card(2, "RED", 34, R.drawable.card16, R.drawable.red, R.drawable.two, R.drawable.card16c, R.drawable.card16v, R.drawable.card16cv));
        deck.add(new Card(3, "RED", 35, R.drawable.card17, R.drawable.red, R.drawable.three, R.drawable.card17c, R.drawable.card17v, R.drawable.card17cv));
        deck.add(new Card(3, "RED", 36, R.drawable.card17, R.drawable.red, R.drawable.three, R.drawable.card17c, R.drawable.card17v, R.drawable.card17cv));
        deck.add(new Card(4, "RED", 37, R.drawable.card18, R.drawable.red, R.drawable.four, R.drawable.card18c, R.drawable.card18v, R.drawable.card18cv));
        deck.add(new Card(4, "RED", 38, R.drawable.card18, R.drawable.red, R.drawable.four, R.drawable.card18c, R.drawable.card18v, R.drawable.card18cv));
        deck.add(new Card(5, "RED", 39, R.drawable.card19, R.drawable.red, R.drawable.five, R.drawable.card19c, R.drawable.card19v, R.drawable.card19cv));
        deck.add(new Card(1, "GREEN", 40, R.drawable.card20, R.drawable.green, R.drawable.one, R.drawable.card20c, R.drawable.card20v, R.drawable.card20cv));
        deck.add(new Card(1, "GREEN", 41, R.drawable.card20, R.drawable.green, R.drawable.one, R.drawable.card20c, R.drawable.card20v, R.drawable.card20cv));
        deck.add(new Card(1, "GREEN", 42, R.drawable.card20, R.drawable.green, R.drawable.one, R.drawable.card20c, R.drawable.card20v, R.drawable.card20cv));
        deck.add(new Card(2, "GREEN", 43, R.drawable.card21, R.drawable.green, R.drawable.two, R.drawable.card21c, R.drawable.card21v, R.drawable.card21cv));
        deck.add(new Card(2, "GREEN", 44, R.drawable.card21, R.drawable.green, R.drawable.two, R.drawable.card21c, R.drawable.card21v, R.drawable.card21cv));
        deck.add(new Card(3, "GREEN", 45, R.drawable.card22, R.drawable.green, R.drawable.three, R.drawable.card22c, R.drawable.card22v, R.drawable.card22cv));
        deck.add(new Card(3, "GREEN", 46, R.drawable.card22, R.drawable.green, R.drawable.three, R.drawable.card22c, R.drawable.card22v, R.drawable.card22cv));
        deck.add(new Card(4, "GREEN", 47, R.drawable.card23, R.drawable.green, R.drawable.four, R.drawable.card23c, R.drawable.card23v, R.drawable.card23cv));
        deck.add(new Card(4, "GREEN", 48, R.drawable.card23, R.drawable.green, R.drawable.four, R.drawable.card23c, R.drawable.card23v, R.drawable.card23cv));
        deck.add(new Card(5, "GREEN", 49, R.drawable.card24, R.drawable.green, R.drawable.five, R.drawable.card24c, R.drawable.card24v, R.drawable.card24cv));
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card removeCard(int index){
        return deck.remove(index);
    }
    public boolean isEmpty(){ return deck.isEmpty(); }
    public int size(){ return deck.size(); }
}
