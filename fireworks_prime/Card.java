package huecomundo.muhich.fireworks_prime;

public class Card {
    private int value, resId, resIdColor, resIdValue, resIdColorPlus, resIdValuePlus, resIdPlus,
            sortNum, cardBackId;
    private String color;
    private boolean knowColor, knowValue;
    public Card(int value, String color, int num, int resId, int resIdColor, int resIdValue,
                int resIdColorPlus, int resIdValuePlus, int resIdPlus){
        this.value = value;
        this.color = color;
        this.sortNum = num;
        this.resId = resId;
        this.resIdColor = resIdColor;
        this.resIdValue = resIdValue;
        this.resIdColorPlus = resIdColorPlus;
        this.resIdValuePlus = resIdValuePlus;
        this.resIdPlus = resIdPlus;
        cardBackId = R.drawable.card_back;
        knowColor = false;
        knowValue = false;

    }
    public String getColor(){ return color; }
    public int getValue(){ return value; }
    public int getsortNum(){ return sortNum; }
    public int getResId(){ return resId; }

    public int displayCard(boolean activePlayer){
        if(activePlayer){
            if(!knowColor && !knowValue){
                return cardBackId;
            }
            else if(!knowColor && knowValue){
                return resIdValue;
            }
            else if(knowColor && !knowValue){
                return resIdColor;
            }
            else{
                return resId;
            }
        }
        //non-active player
        else{
            if(!knowColor && !knowValue){
                return resId;
            }
            else if(!knowColor && knowValue){
                return resIdValuePlus;
            }
            else if(knowColor && !knowValue){
                return resIdColorPlus;
            }
            else{
                return resIdPlus;
            }
        }
    }

    public void setKnowColor(boolean bool){ knowColor = bool; }
    public void setKnowValue(boolean bool){ knowValue = bool; }

    public int compareTo(Card card){
        if(card.getsortNum() > sortNum){
            return -1;
        } else if(card.getsortNum() < sortNum){
            return 1;
        }
        return 0;
    }
    public String toString(){
        return color + String.valueOf(value) + " " + knowColor + " " + knowValue;
    }
}
