package huecomundo.muhich.fireworks_prime;

public class Player {
    private String playerName;
    private Hand hand;
    public Player(String playerName){
        hand = new Hand();
        this.playerName = playerName;
    }
    public String getPlayerName(){ return playerName; }
    public Hand getHand(){ return hand; }

    public void drawCard(int num){ GameMaker.fireworkGame.drawCard(hand, num); }
    public void playCard(int cardIndex){ GameMaker.fireworkGame.playCard(playerName, hand, cardIndex); }
    public void discardCard(int cardIndex){
        GameMaker.fireworkGame.discardCard(getPlayerName(), getHand(), cardIndex);
    }
    public void giveClue(String clueType, String clue, Player cluedPlayer){
        GameMaker.fireworkGame.giveClue(clueType, clue, cluedPlayer);
    }
}