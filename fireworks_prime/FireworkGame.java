package huecomundo.muhich.fireworks_prime;

import java.util.ArrayList;

public class FireworkGame {
    private ArrayList<Player> playerList;
    public ArrayList<String> turnLog;
    private Deck deck;
    private Discard discard;
    private PlayedArea playedArea;
    private int turnCounter, clueCounter, bombCounter, finalTurns;
    public boolean firstStart, gameOver;

    public FireworkGame(){
        playerList = new ArrayList<>();
        turnLog = new ArrayList<>();
        deck = new Deck();
        discard = new Discard();
        playedArea = new PlayedArea();
        turnCounter = 0;
        clueCounter = 8;
        bombCounter = 3;
        deck.shuffle();
        finalTurns = 0;
        firstStart = true;
        gameOver = false;
    }
    public void startGame(){ drawOpeningHands(); }

    private void drawOpeningHands(){
        for(Player p: playerList){
            if(playerList.size() >= 4) p.drawCard(4);
            if(playerList.size() <= 3) p.drawCard(5);
        }
    }

    public ArrayList<Player> getPlayerList(){ return playerList; }
    public int getNumPlayers(){ return playerList.size(); }
    public void addPlayer(String playerName){ playerList.add(new Player(playerName)); }

    public ArrayList<String> getTurnLog(){ return turnLog; }
    public Player getActivePlayer(){ return playerList.get(turnCounter % getNumPlayers()); }
    public int getTurnCounter(){ return turnCounter; }
    public void incrTurns(){ turnCounter++; }

    public int getClueCounter(){ return clueCounter; }
    public void incrClues(){ clueCounter++; }
    public void decrClues(){ clueCounter--; }

    public int getBombCounter(){ return bombCounter; }
    public void decrBombs(){
        if(bombCounter > 0) bombCounter--;
        if(bombCounter == 0) endGame();
    }
    public boolean isGameOver(){ return gameOver; }
    private void endGame(){
        gameOver = true;
        turnLog.add(0, "Game Over!");
    }
    public Discard getDiscard(){ return discard; }
    public Deck getDeck(){ return deck; }
    public PlayedArea getPlayedArea(){ return playedArea; }

    public void drawCard(Hand hand, int num){
        for(int i = 0; i < num; i++) {
            if (!getDeck().isEmpty()) {
                hand.addCard(getDeck().removeCard(0));
            } else finalTurns++;
        }
        if(finalTurns == getNumPlayers()) endGame();
    }

    public void playCard(String playerName, Hand hand, int cardIndex){
        Card playedCard = null;
        switch(cardIndex){
            case 0:
                playedCard = hand.removeCard(0);
                break;
            case 1:
                playedCard = hand.removeCard(1);
                break;
            case 2:
                playedCard = hand.removeCard(2);
                break;
            case 3:
                playedCard = hand.removeCard(3);
                break;
            case 4:
                playedCard = hand.removeCard(4);
                break;
        }
        if(playedArea.isLegalPlay(playedCard)){
            turnLog.add(0, "Turn " + (turnCounter + 1)
                    + ": " + playerName + " played "
                    + playedCard.toString());
            playedArea.addToPlayedArea(playedCard);
            if(playedArea.isAllFives()) endGame();
            if(playedCard.getValue() == 5) incrClues();
        }
        else{
            turnLog.add(0, "Turn " + (turnCounter + 1)
                    + ": " + playerName + " bombed "
                    + playedCard.toString());
            discard.addToDiscard(playedCard);
            decrBombs();
        }
        drawCard(hand, 1);
        if(!gameOver) incrTurns();
    }
    public void discardCard(String playerName, Hand hand, int cardIndex){
        Card discardedCard = null;
        switch(cardIndex){
            case 0:
                discardedCard = hand.removeCard(0);
                break;
            case 1:
                discardedCard = hand.removeCard(1);
                break;
            case 2:
                discardedCard = hand.removeCard(2);
                break;
            case 3:
                discardedCard = hand.removeCard(3);
                break;
            case 4:
                discardedCard = hand.removeCard(4);
                break;
        }
        turnLog.add(0, "Turn " + (turnCounter + 1)
                + ": " + playerName + " discarded "
                + discardedCard.toString());
        discard.addToDiscard(discardedCard);
        drawCard(hand, 1);
        if(clueCounter < 8) incrClues();
        incrTurns();
    }
    public void giveClue(String clueType, String clue, Player cluedPlayer){
        Hand hand = cluedPlayer.getHand();
        if(clueType.equals("color")){
            for(Card card: hand.getHand()){
                if(card.getColor().equals(clue)){
                    card.setKnowColor(true);
                }
            }
        } else if(clueType.equals("value")){
            int clueValue = Integer.parseInt(clue);
            for(Card card: hand.getHand()){
                if(card.getValue() == clueValue){
                    card.setKnowValue(true);
                }
            }
        }
        turnLog.add(0, "Turn " + (turnCounter + 1)
                    + ": " + getActivePlayer().getPlayerName() + " clued "
                    + cluedPlayer.getPlayerName()
                    + " about the " + clueType + " " + clue);
        decrClues();
        incrTurns();
    }
}
