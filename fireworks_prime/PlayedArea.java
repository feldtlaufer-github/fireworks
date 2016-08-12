package huecomundo.muhich.fireworks_prime;

public class PlayedArea {
    private Card[] playedAreaArray;
    public PlayedArea(){
        playedAreaArray = new Card[5];
    }
    public void addToPlayedArea(Card card){
        switch(card.getColor()){
            case "WHITE":
                playedAreaArray[0] = card;
                break;
            case "BLUE":
                playedAreaArray[1] = card;
                break;
            case "YELLOW":
                playedAreaArray[2] = card;
                break;
            case "RED":
                playedAreaArray[3] = card;
                break;
            case "GREEN":
                playedAreaArray[4] = card;
                break;
        }
    }
    public boolean isLegalPlay(Card card){
        switch(card.getColor()){
            case "WHITE":
                if(playedAreaArray[0] == null){
                    if(card.getValue() == 1) return true;
                } else{
                    if(card.getValue() == playedAreaArray[0].getValue() + 1) return true;
                }
                break;
            case "BLUE":
                if(playedAreaArray[1] == null){
                    if(card.getValue() == 1) return true;
                } else{
                    if(card.getValue() == playedAreaArray[1].getValue() + 1) return true;
                }
                break;
            case "YELLOW":
                if(playedAreaArray[2] == null){
                    if(card.getValue() == 1) return true;
                } else{
                    if(card.getValue() == playedAreaArray[2].getValue() + 1) return true;
                }
                break;
            case "RED":
                if(playedAreaArray[3] == null){
                    if(card.getValue() == 1) return true;
                } else{
                    if(card.getValue() == playedAreaArray[3].getValue() + 1) return true;
                }
                break;
            case "GREEN":
                if(playedAreaArray[4] == null){
                    if(card.getValue() == 1) return true;
                } else{
                    if(card.getValue() == playedAreaArray[4].getValue() + 1) return true;
                }
                break;
        }
        return false;
    }
    public Card[] getPlayedArea(){ return playedAreaArray; }
    public boolean isAllFives(){
        for(int i = 0; i < 5; i++){
            if(playedAreaArray[i] == null) return false;
            else if(playedAreaArray[i].getValue() != 5) return false;
        }
        return true;
    }
}
