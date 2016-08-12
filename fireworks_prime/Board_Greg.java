package huecomundo.muhich.fireworks_prime;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Board_Greg extends AppCompatActivity{
    private FireworkGame game;
    private boolean played = false, discarded = false;
    private String valueOrColor, clueWhereClicked;
    private CustomAdapter customAdapter;
    private View activeBtnPlayDiscardHelper, clueBtnHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        game = GameMaker.fireworkGame;
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_board__greg);

        setupFragments();
        displayTurnLog();
    }
    @Override
    protected void onStart(){
        super.onStart();
        if(GameMaker.fireworkGame.firstStart) displayOpeningHands();
        GameMaker.fireworkGame.firstStart = false;
    }
    private void displayOpeningHands() {
        ImageView ivAHA = (ImageView) findViewById(R.id.ivActiveHandA);
        ImageView ivAHB = (ImageView) findViewById(R.id.ivActiveHandB);
        ImageView ivAHC = (ImageView) findViewById(R.id.ivActiveHandC);
        ImageView ivAHD = (ImageView) findViewById(R.id.ivActiveHandD);
        ImageView[] ivArray = {ivAHA, ivAHB, ivAHC, ivAHD};
        for (ImageView iv : ivArray) {
            iv.setImageResource(R.drawable.card_back);
        }
        if(game.getPlayerList().size() <= 3) {
            ImageView ivAHE = (ImageView) findViewById(R.id.ivActiveHandE);
            ivAHE.setImageResource(R.drawable.card_back);
        }
        switch (game.getPlayerList().size()) {
            case 2:
                //second player
                ImageView ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ImageView ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ImageView ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ImageView ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                ImageView ivUHE = (ImageView) findViewById(R.id.ivUpHandE);
                ImageView[] ivArray2 = {ivUHA, ivUHB, ivUHC, ivUHD, ivUHE};
                for(int i = 0; i < 5; i++){
                    Card card = game.getPlayerList().get(1).getHand().peekCard(i);
                    ivArray2[i].setImageResource(card.getResId());
                }
                break;
            case 3:
                //second player
                ImageView ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ImageView ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ImageView ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ImageView ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                ImageView ivULHE = (ImageView) findViewById(R.id.ivUpLeftHandE);
                //third player
                ImageView ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ImageView ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ImageView ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ImageView ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                ImageView ivURHE = (ImageView) findViewById(R.id.ivUpRightHandE);

                ImageView[] ivArray3 = {ivULHA, ivULHB, ivULHC, ivULHD, ivULHE,
                                        ivURHA, ivURHB, ivURHC, ivURHD, ivURHE};
                for(int i = 0; i < 5; i++){
                    Card card = game.getPlayerList().get(1).getHand().peekCard(i);
                    ivArray3[i].setImageResource(card.getResId());
                }
                for(int i = 5; i < 10; i++){
                    Card card = game.getPlayerList().get(2).getHand().peekCard(i-5);
                    ivArray3[i].setImageResource(card.getResId());
                }
                break;
            case 4:
                //second player
                ImageView ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ImageView ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ImageView ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ImageView ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                //fourth player
                ImageView ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ImageView ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ImageView ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ImageView ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray4 = {ivLHA, ivLHB, ivLHC, ivLHD,
                                        ivUHA, ivUHB, ivUHC, ivUHD,
                                        ivRHA, ivRHB, ivRHC, ivRHD};

                for(int i = 0; i < 4; i++){
                    Card card = game.getPlayerList().get(1).getHand().peekCard(i);
                    ivArray4[i].setImageResource(card.getResId());
                }
                for(int i = 4; i < 8; i++){
                    Card card = game.getPlayerList().get(2).getHand().peekCard(i-4);
                    ivArray4[i].setImageResource(card.getResId());
                }
                for(int i = 8; i < 12; i++){
                    Card card = game.getPlayerList().get(3).getHand().peekCard(i-8);
                    ivArray4[i].setImageResource(card.getResId());
                }
                break;
            case 5:
                //second player
                ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                //fourth player
                ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                //fifth player
                ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray5 = {ivLHA, ivLHB, ivLHC, ivLHD,
                                        ivULHA, ivULHB, ivULHC, ivULHD,
                                        ivURHA, ivURHB, ivURHC, ivURHD,
                                        ivRHA, ivRHB, ivRHC, ivRHD};
                for(int i = 0; i < 4; i++){
                    Card card = game.getPlayerList().get(1).getHand().peekCard(i);
                    ivArray5[i].setImageResource(card.getResId());
                }
                for(int i = 4; i < 8; i++){
                    Card card = game.getPlayerList().get(2).getHand().peekCard(i-4);
                    ivArray5[i].setImageResource(card.getResId());
                }
                for(int i = 8; i < 12; i++){
                    Card card = game.getPlayerList().get(3).getHand().peekCard(i-8);
                    ivArray5[i].setImageResource(card.getResId());
                }
                for(int i = 12; i < 16; i++){
                    Card card = game.getPlayerList().get(4).getHand().peekCard(i-12);
                    ivArray5[i].setImageResource(card.getResId());
                }
                break;
        }
    }
    private void displayTurnLog(){
        customAdapter = new CustomAdapter(this, GameMaker.fireworkGame.getTurnLog());
        ListView lvTurnLog = (ListView) findViewById(R.id.lvTurnLog);
        lvTurnLog.setAdapter(customAdapter);
    }
    public void gotoSettings(View v){ startActivity(new Intent(Board_Greg.this, Settings.class)); }
    public void popupDiscard(View v){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage(GameMaker.fireworkGame.getDiscard().toString());
        builder1.setCancelable(true);

        builder1.setNegativeButton(
                "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    private void setupFragments(){
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransactionHand = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionLeft = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionRight = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionUpLeft = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionUpRight = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransactionUp = fragmentManager.beginTransaction();


        if(GameMaker.fireworkGame.getPlayerList().size() >= 4){
            active_hand_4_fragment four_card_hand_fragment = new active_hand_4_fragment();
            fragmentTransactionHand.replace(R.id.active_hand_container, four_card_hand_fragment);
        }
        else{
            active_hand_5_fragment five_card_hand_fragment = new active_hand_5_fragment();
            fragmentTransactionHand.replace(R.id.active_hand_container, five_card_hand_fragment);
        }
        switch(GameMaker.fireworkGame.getPlayerList().size()){
            case 2:
                up_hand_5_fragment upHand5Fragment = new up_hand_5_fragment();
                fragmentTransactionUp.replace(R.id.up_container, upHand5Fragment);
                break;
            case 3:
                up_left_5_fragment upLeft5Fragment = new up_left_5_fragment();
                fragmentTransactionUpLeft.replace(R.id.up_left_container, upLeft5Fragment);
                up_right_5_fragment upRight5Fragment = new up_right_5_fragment();
                fragmentTransactionUpRight.replace(R.id.up_right_container, upRight5Fragment);
                break;
            case 4:
                up_hand_4_fragment upHand4Fragment = new up_hand_4_fragment();
                fragmentTransactionUp.replace(R.id.up_container, upHand4Fragment);
                left_hand_4_fragment leftHand4Fragment = new left_hand_4_fragment();
                fragmentTransactionLeft.replace(R.id.left_container, leftHand4Fragment);
                right_hand_4_fragment rightHand4Fragment = new right_hand_4_fragment();
                fragmentTransactionRight.replace(R.id.right_container, rightHand4Fragment);
                break;
            case 5:
                up_left_4_fragment upLeft4Fragment = new up_left_4_fragment();
                fragmentTransactionUpLeft.replace(R.id.up_left_container, upLeft4Fragment);
                up_right_4_fragment upRight4Fragment = new up_right_4_fragment();
                fragmentTransactionUpRight.replace(R.id.up_right_container, upRight4Fragment);
                leftHand4Fragment = new left_hand_4_fragment();
                fragmentTransactionLeft.replace(R.id.left_container, leftHand4Fragment);
                rightHand4Fragment = new right_hand_4_fragment();
                fragmentTransactionRight.replace(R.id.right_container, rightHand4Fragment);
                break;
        }
        fragmentTransactionHand.commit();
        fragmentTransactionLeft.commit();
        fragmentTransactionRight.commit();
        fragmentTransactionUpLeft.commit();
        fragmentTransactionUpRight.commit();
        fragmentTransactionUp.commit();
    }
    public void onBackPressed(){}
    private void popUpClue(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Give CLUE on COLOR or VALUE?");
        builder1.setCancelable(true);
        builder1.setNegativeButton(
                "COLOR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        valueOrColor = "COLOR";
                        clueActionHelper(clueBtnHelper);
                        dialog.cancel();
                    }
                }
        );
        builder1.setPositiveButton(
                "VALUE",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id) {
                        valueOrColor = "VALUE";
                        clueActionHelper(clueBtnHelper);
                        dialog.cancel();
                    }
                }
        );
        builder1.setNeutralButton(
                "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    private void popUpPlayOrDiscard(){
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Would you like to PLAY or DISCARD this card?");
        builder1.setCancelable(true);
        builder1.setNegativeButton(
                "PLAY",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        played = true;
                        activeCardActionHelper(activeBtnPlayDiscardHelper);
                        dialog.cancel();
                    }
                }
        );
        builder1.setPositiveButton(
                "DISCARD",
                new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        discarded = true;
                        activeCardActionHelper(activeBtnPlayDiscardHelper);
                        dialog.cancel();
                    }
                }
        );
        builder1.setNeutralButton(
                "Return",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }
        );
        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    /**
     * 2nd Player (of 2) or 3rd Player (of 4) clue giving method
     * used in 2 and 4 Player games
     */
    public void giveClueActionB(View v){
        clueBtnHelper = v;
        clueWhereClicked = "B";
        popUpClue();
    }
    /**
     * 2nd Player (of 3) or 3rd Player (of 5) clue giving method
     * used in 3 and 5 Player games
     */
    public void giveClueActionC(View v){
        clueBtnHelper = v;
        clueWhereClicked = "C";
        popUpClue();
    }
    /**
     * 3rd Player (of 3) or 4rd Player (of 5) clue giving method
     * used in 3 and 5 Player games
     */
    public void giveClueActionD(View v) {
        clueBtnHelper = v;
        clueWhereClicked = "D";
        popUpClue();
    }
    /**
     * 2nd Player (of 4 and 5) clue giving method
     * used in 4 and 5 Player games
     */
    public void giveClueActionE(View v){
        clueBtnHelper = v;
        clueWhereClicked = "E";
        popUpClue();
    }
    /**
     * 4th or 5th Player (of 4 and 5)clue giving method
     * used in 4 and 5 Player games
     */
    public void giveClueActionF(View v){
        clueBtnHelper = v;
        clueWhereClicked = "F";
        popUpClue();
    }
    private void clueActionHelper(View v){
        Player cluedPlayer = null;
        String clue = null;
        Player secondPlayer = game.getPlayerList()
                .get((game.getTurnCounter()+1) % game.getNumPlayers());
        Player thirdPlayer = game.getPlayerList()
                .get((game.getTurnCounter()+2) % game.getNumPlayers());
        Player fourthPlayer = game.getPlayerList()
                .get((game.getTurnCounter()+3) % game.getNumPlayers());
        Player fifthPlayer = game.getPlayerList()
                .get((game.getTurnCounter()+4) % game.getNumPlayers());

        switch(clueWhereClicked){
            case "B":
                cluedPlayer = (game.getPlayerList().size() == 2) ? secondPlayer : thirdPlayer;
                switch(v.getId()){
                    case R.id.ivUpHandA:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(0).getValue()) :
                                cluedPlayer.getHand().peekCard(0).getColor();
                        break;
                    case R.id.ivUpHandB:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(1).getValue()) :
                                cluedPlayer.getHand().peekCard(1).getColor();
                        break;
                    case R.id.ivUpHandC:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(2).getValue()) :
                                cluedPlayer.getHand().peekCard(2).getColor();
                        break;
                    case R.id.ivUpHandD:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(3).getValue()) :
                                cluedPlayer.getHand().peekCard(3).getColor();
                        break;
                    case R.id.ivUpHandE:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(4).getValue()) :
                                cluedPlayer.getHand().peekCard(4).getColor();
                        break;
                }
                break;
            case "C":
                cluedPlayer = (game.getPlayerList().size() == 3) ? secondPlayer : thirdPlayer;
                switch(v.getId()){
                    case R.id.ivUpLeftHandA:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(0).getValue()) :
                                cluedPlayer.getHand().peekCard(0).getColor();
                        break;
                    case R.id.ivUpLeftHandB:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(1).getValue()) :
                                cluedPlayer.getHand().peekCard(1).getColor();
                        break;
                    case R.id.ivUpLeftHandC:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(2).getValue()) :
                                cluedPlayer.getHand().peekCard(2).getColor();
                        break;
                    case R.id.ivUpLeftHandD:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(3).getValue()) :
                                cluedPlayer.getHand().peekCard(3).getColor();
                        break;
                    case R.id.ivUpLeftHandE:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(4).getValue()) :
                                cluedPlayer.getHand().peekCard(4).getColor();
                        break;
                }
                break;
            case "D":
                cluedPlayer = (game.getPlayerList().size() == 3) ? thirdPlayer : fourthPlayer;
                switch(v.getId()){
                    case R.id.ivUpRightHandA:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(0).getValue()) :
                                cluedPlayer.getHand().peekCard(0).getColor();
                        break;
                    case R.id.ivUpRightHandB:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(1).getValue()) :
                                cluedPlayer.getHand().peekCard(1).getColor();
                        break;
                    case R.id.ivUpRightHandC:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(2).getValue()) :
                                cluedPlayer.getHand().peekCard(2).getColor();
                        break;
                    case R.id.ivUpRightHandD:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(3).getValue()) :
                                cluedPlayer.getHand().peekCard(3).getColor();
                        break;
                    case R.id.ivUpRightHandE:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(4).getValue()) :
                                cluedPlayer.getHand().peekCard(4).getColor();
                        break;
                }
                break;
            case "E":
                cluedPlayer = secondPlayer;
                switch(v.getId()) {
                    case R.id.ivLeftHandA:
                    case R.id.ivUpHandA:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(0).getValue()) :
                                cluedPlayer.getHand().peekCard(0).getColor();
                        break;
                    case R.id.ivLeftHandB:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(1).getValue()) :
                                cluedPlayer.getHand().peekCard(1).getColor();
                        break;
                    case R.id.ivLeftHandC:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(2).getValue()) :
                                cluedPlayer.getHand().peekCard(2).getColor();
                        break;
                    case R.id.ivLeftHandD:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(3).getValue()) :
                                cluedPlayer.getHand().peekCard(3).getColor();
                        break;
                }
                break;
            case "F":
                cluedPlayer = (game.getNumPlayers() == 4) ? fourthPlayer : fifthPlayer;
                switch(v.getId()){
                    case R.id.ivRightHandA:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(0).getValue()) :
                                cluedPlayer.getHand().peekCard(0).getColor();
                        break;
                    case R.id.ivRightHandB:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(1).getValue()) :
                                cluedPlayer.getHand().peekCard(1).getColor();
                        break;
                    case R.id.ivRightHandC:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(2).getValue()) :
                                cluedPlayer.getHand().peekCard(2).getColor();
                        break;
                    case R.id.ivRightHandD:
                        clue = valueOrColor.equals("VALUE") ?
                                String.valueOf(cluedPlayer.getHand().peekCard(3).getValue()) :
                                cluedPlayer.getHand().peekCard(3).getColor();
                        break;
                }
                break;
        }
        game.getActivePlayer().giveClue(valueOrColor, clue, cluedPlayer);
        endActionActions();
    }
    private void activeCardActionHelper(View v){
        if(played) {
            switch(v.getId()) {
                case R.id.ivActiveHandA:
                    game.getActivePlayer().playCard(0);
                    break;
                case R.id.ivActiveHandB:
                    game.getActivePlayer().playCard(1);
                    break;
                case R.id.ivActiveHandC:
                    game.getActivePlayer().playCard(2);
                    break;
                case R.id.ivActiveHandD:
                    game.getActivePlayer().playCard(3);
                    break;
                case R.id.ivActiveHandE:
                    game.getActivePlayer().playCard(4);
                    break;
            }
        } else if(discarded){
            switch(v.getId()) {
                case R.id.ivActiveHandA:
                    game.getActivePlayer().discardCard(0);
                    break;
                case R.id.ivActiveHandB:
                    game.getActivePlayer().discardCard(1);
                    break;
                case R.id.ivActiveHandC:
                    game.getActivePlayer().discardCard(2);
                    break;
                case R.id.ivActiveHandD:
                    game.getActivePlayer().discardCard(3);
                    break;
                case R.id.ivActiveHandE:
                    game.getActivePlayer().discardCard(4);
                    break;
            }
        }
        endActionActions();
        played = false;
        discarded = false;
    }
    public void activeCardAction(View v){
        activeBtnPlayDiscardHelper = v;
        popUpPlayOrDiscard();
    }
    private void endActionActions(){
        customAdapter.notifyDataSetChanged();
        displayClueCounter();
        displayBombCounter();
        displayPlayedArea();
        //TODO: goto player screen, when player screen is clicked, then displayHands
        if(!game.isGameOver()) displayHands();
        else{
            revealActiveHand();
            disableButtons();
        }
    }
    private void revealActiveHand(){
        ImageView ivAHA = (ImageView) findViewById(R.id.ivActiveHandA);
        ImageView ivAHB = (ImageView) findViewById(R.id.ivActiveHandB);
        ImageView ivAHC = (ImageView) findViewById(R.id.ivActiveHandC);
        ImageView ivAHD = (ImageView) findViewById(R.id.ivActiveHandD);
        ImageView ivAHE = null;
        int fourOrfive = 5;
        if(game.getNumPlayers() < 4){
            ivAHE = (ImageView) findViewById(R.id.ivActiveHandE);
            fourOrfive = 4;
        }
        ImageView[] ivArray = {ivAHA, ivAHB, ivAHC, ivAHD, ivAHE};
        for(int i = 0; i < game.getActivePlayer().getHand().size(); i++){
            if(ivArray[i] != null) {
                ivArray[i].setImageResource(game.getActivePlayer()
                                                .getHand()
                                                .peekCard(i)
                                                .getResId());
            }
        }
        for(int i = game.getActivePlayer().getHand().size(); i < fourOrfive; i++){
            ivArray[i].setVisibility(View.INVISIBLE);
        }
    }
    private void displayPlayedArea(){
        ImageView ivPlayedWhite = (ImageView) findViewById(R.id.ivPlayedWhite);
        ImageView ivPlayedBlue = (ImageView) findViewById(R.id.ivPlayedBlue);
        ImageView ivPlayedYellow = (ImageView) findViewById(R.id.ivPlayedYellow);
        ImageView ivPlayedRed = (ImageView) findViewById(R.id.ivPlayedRed);
        ImageView ivPlayedGreen = (ImageView) findViewById(R.id.ivPlayedGreen);

        Card[] playedAreaArray = GameMaker.fireworkGame.getPlayedArea().getPlayedArea();
        if(playedAreaArray[0] != null) ivPlayedWhite
                                        .setImageResource(playedAreaArray[0].getResId());
        if(playedAreaArray[1] != null) ivPlayedBlue
                                        .setImageResource(playedAreaArray[1].getResId());
        if(playedAreaArray[2] != null) ivPlayedYellow
                                        .setImageResource(playedAreaArray[2].getResId());
        if(playedAreaArray[3] != null) ivPlayedRed
                                        .setImageResource(playedAreaArray[3].getResId());
        if(playedAreaArray[4] != null) ivPlayedGreen
                                        .setImageResource(playedAreaArray[4].getResId());
    }
    private void displayHands(){
        //TODO: allow game to function when fewer than max cards are in hand
        Card card;
        ArrayList<Player> pList = game.getPlayerList();
        ImageView ivAHA = (ImageView) findViewById(R.id.ivActiveHandA);
        ImageView ivAHB = (ImageView) findViewById(R.id.ivActiveHandB);
        ImageView ivAHC = (ImageView) findViewById(R.id.ivActiveHandC);
        ImageView ivAHD = (ImageView) findViewById(R.id.ivActiveHandD);
        ImageView ivAHE = null;
        if(pList.size() <= 3) {
            ivAHE = (ImageView) findViewById(R.id.ivActiveHandE);
        }
        ivAHA.setImageResource(game.getActivePlayer().getHand().peekCard(0).displayCard(true));
        ivAHB.setImageResource(game.getActivePlayer().getHand().peekCard(1).displayCard(true));
        ivAHC.setImageResource(game.getActivePlayer().getHand().peekCard(2).displayCard(true));
        ivAHD.setImageResource(game.getActivePlayer().getHand().peekCard(3).displayCard(true));
        if(pList.size() <= 3) {
            ivAHE.setImageResource(game.getActivePlayer().getHand().peekCard(4).displayCard(true));
        }

        switch (pList.size()) {
            case 2:
                //second player
                ImageView ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ImageView ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ImageView ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ImageView ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                ImageView ivUHE = (ImageView) findViewById(R.id.ivUpHandE);
                ImageView[] ivArray2 = {ivUHA, ivUHB, ivUHC, ivUHD, ivUHE};
                for(int i = 0;
                        i < pList.get((game.getTurnCounter() + 1) % 2).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 1) % 2)
                                .getHand()
                                .peekCard(i);
                    ivArray2[i].setImageResource(card.displayCard(false));

                }
                break;
            case 3:
                //second player
                ImageView ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ImageView ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ImageView ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ImageView ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                ImageView ivULHE = (ImageView) findViewById(R.id.ivUpLeftHandE);
                //third player
                ImageView ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ImageView ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ImageView ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ImageView ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                ImageView ivURHE = (ImageView) findViewById(R.id.ivUpRightHandE);

                ImageView[] ivArray3 = {ivULHA, ivULHB, ivULHC, ivULHD, ivULHE,
                                        ivURHA, ivURHB, ivURHC, ivURHD, ivURHE};
                int tempIndex = pList.get((game.getTurnCounter()+1) % 3).getHand().size();
                for(int i = 0; i < tempIndex; i++){
                    card = pList.get((game.getTurnCounter() + 1) % 3)
                                .getHand()
                                .peekCard(i);
                    ivArray3[i].setImageResource(card.displayCard(false));
                }
                for(int i = tempIndex;
                        i < pList.get((game.getTurnCounter() + 2) % 3).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 2) % 3)
                                .getHand()
                                .peekCard(i-5);
                    ivArray3[i].setImageResource(card.displayCard(false));
                }
                break;
            case 4:
                //second player
                ImageView ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ImageView ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ImageView ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ImageView ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                //fourth player
                ImageView ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ImageView ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ImageView ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ImageView ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray4 = {ivLHA, ivLHB, ivLHC, ivLHD,
                        ivUHA, ivUHB, ivUHC, ivUHD,
                        ivRHA, ivRHB, ivRHC, ivRHD};
                tempIndex = pList.get((game.getTurnCounter() + 1) % 4).getHand().size();
                for(int i = 0;
                        i < tempIndex; i++){
                    card = pList.get((game.getTurnCounter() + 1) % 4)
                                .getHand()
                                .peekCard(i);
                    ivArray4[i].setImageResource(card.displayCard(false));
                }
                for(int i = tempIndex;
                        i < pList.get((game.getTurnCounter() + 2) % 4).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 2) % 4)
                                .getHand()
                                .peekCard(i-4);
                    ivArray4[i].setImageResource(card.displayCard(false));
                }
                tempIndex = pList.get((game.getTurnCounter() + 2) % 4).getHand().size();
                for(int i = tempIndex;
                        i < pList.get((game.getTurnCounter() + 3) % 4).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 3) % 4)
                                .getHand()
                                .peekCard(i-8);
                    ivArray4[i].setImageResource(card.displayCard(false));
                }
                break;
            case 5:
                //second player
                ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                //fourth player
                ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                //fifth player
                ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray5 = {ivLHA, ivLHB, ivLHC, ivLHD,
                        ivULHA, ivULHB, ivULHC, ivULHD,
                        ivURHA, ivURHB, ivURHC, ivURHD,
                        ivRHA, ivRHB, ivRHC, ivRHD};
                tempIndex = pList.get((game.getTurnCounter() + 1) % 5).getHand().size();
                for(int i = 0; i < tempIndex; i++){
                    card = pList.get((game.getTurnCounter() + 1) % 5)
                                .getHand()
                                .peekCard(i);
                    ivArray5[i].setImageResource(card.displayCard(false));
                }
                for(int i = tempIndex;
                        i < pList.get((game.getTurnCounter() + 2) % 5).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 2) % 5)
                                .getHand()
                                .peekCard(i-4);
                    ivArray5[i].setImageResource(card.displayCard(false));
                }
                tempIndex = pList.get((game.getTurnCounter() + 2) % 5).getHand().size();
                for(int i = tempIndex;
                        i < pList.get((game.getTurnCounter() + 3) % 5).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 3) % 5)
                                .getHand()
                                .peekCard(i-8);
                    ivArray5[i].setImageResource(card.displayCard(false));
                }
                tempIndex = pList.get((game.getTurnCounter() + 3) % 5).getHand().size();
                for(int i = tempIndex;
                        i <  pList.get((game.getTurnCounter() + 4) % 5).getHand().size(); i++){
                    card = pList.get((game.getTurnCounter() + 4) % 5)
                                .getHand()
                                .peekCard(i-12);
                    ivArray5[i].setImageResource(card.displayCard(false));
                }
                break;
        }
    }
    private void displayClueCounter(){
        ImageView ivClues = (ImageView)findViewById(R.id.ivClueCounter);
        switch(game.getClueCounter()){
            case 0:
                ivClues.setImageResource(R.drawable.clues_0);
                break;
            case 1:
                ivClues.setImageResource(R.drawable.clues_1);
                break;
            case 2:
                ivClues.setImageResource(R.drawable.clues_2);
                break;
            case 3:
                ivClues.setImageResource(R.drawable.clues_3);
                break;
            case 4:
                ivClues.setImageResource(R.drawable.clues_4);
                break;
            case 5:
                ivClues.setImageResource(R.drawable.clues_5);
                break;
            case 6:
                ivClues.setImageResource(R.drawable.clues_6);
                break;
            case 7:
                ivClues.setImageResource(R.drawable.clues_7);
                break;
            case 8:
                ivClues.setImageResource(R.drawable.clues_8);
                break;
        }
    }
    private void displayBombCounter(){
        ImageView ivBombs = (ImageView)findViewById(R.id.ivBombCounter);
        switch(game.getBombCounter()){
            case 0:
                ivBombs.setImageResource(R.drawable.bomb_0);
                break;
            case 1:
                ivBombs.setImageResource(R.drawable.bomb_1);
                break;
            case 2:
                ivBombs.setImageResource(R.drawable.bomb_2);
                break;
            case 3:
                ivBombs.setImageResource(R.drawable.bomb_3);
                break;
        }
    }
    public void displayDeckCount(View v){
        Toast.makeText(getApplicationContext(),
                "Cards Left: " + game.getDeck().size(),
                Toast.LENGTH_SHORT).show();
    }
    public void disableButtons(){
        ImageView ivAHA = (ImageView) findViewById(R.id.ivActiveHandA);
        ImageView ivAHB = (ImageView) findViewById(R.id.ivActiveHandB);
        ImageView ivAHC = (ImageView) findViewById(R.id.ivActiveHandC);
        ImageView ivAHD = (ImageView) findViewById(R.id.ivActiveHandD);
        ImageView ivAHE = null;
        if(game.getNumPlayers() < 4) ivAHE = (ImageView) findViewById(R.id.ivActiveHandE);
        ImageView[] ivArray = {ivAHA, ivAHB, ivAHC, ivAHD, ivAHE};
        for(ImageView iv: ivArray){
            if(iv != null) iv.setEnabled(false);
        }
        switch (game.getNumPlayers()) {
            case 2:
                //second player
                ImageView ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ImageView ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ImageView ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ImageView ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                ImageView ivUHE = (ImageView) findViewById(R.id.ivUpHandE);
                ImageView[] ivArray2 = {ivUHA, ivUHB, ivUHC, ivUHD, ivUHE};
                for(ImageView iv: ivArray2){
                    iv.setEnabled(false);
                }
                break;
            case 3:
                //second player
                ImageView ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ImageView ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ImageView ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ImageView ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                ImageView ivULHE = (ImageView) findViewById(R.id.ivUpLeftHandE);
                //third player
                ImageView ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ImageView ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ImageView ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ImageView ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                ImageView ivURHE = (ImageView) findViewById(R.id.ivUpRightHandE);

                ImageView[] ivArray3 = {ivULHA, ivULHB, ivULHC, ivULHD, ivULHE,
                        ivURHA, ivURHB, ivURHC, ivURHD, ivURHE};
                for(ImageView iv: ivArray3){
                    iv.setEnabled(false);
                }
                break;
            case 4:
                //second player
                ImageView ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ImageView ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ImageView ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ImageView ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivUHA = (ImageView) findViewById(R.id.ivUpHandA);
                ivUHB = (ImageView) findViewById(R.id.ivUpHandB);
                ivUHC = (ImageView) findViewById(R.id.ivUpHandC);
                ivUHD = (ImageView) findViewById(R.id.ivUpHandD);
                //fourth player
                ImageView ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ImageView ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ImageView ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ImageView ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray4 = {ivLHA, ivLHB, ivLHC, ivLHD,
                        ivUHA, ivUHB, ivUHC, ivUHD,
                        ivRHA, ivRHB, ivRHC, ivRHD};
                for(ImageView iv: ivArray4){
                    iv.setEnabled(false);
                }
                break;
            case 5:
                //second player
                ivLHA = (ImageView) findViewById(R.id.ivLeftHandA);
                ivLHB = (ImageView) findViewById(R.id.ivLeftHandB);
                ivLHC = (ImageView) findViewById(R.id.ivLeftHandC);
                ivLHD = (ImageView) findViewById(R.id.ivLeftHandD);
                //third player
                ivULHA = (ImageView) findViewById(R.id.ivUpLeftHandA);
                ivULHB = (ImageView) findViewById(R.id.ivUpLeftHandB);
                ivULHC = (ImageView) findViewById(R.id.ivUpLeftHandC);
                ivULHD = (ImageView) findViewById(R.id.ivUpLeftHandD);
                //fourth player
                ivURHA = (ImageView) findViewById(R.id.ivUpRightHandA);
                ivURHB = (ImageView) findViewById(R.id.ivUpRightHandB);
                ivURHC = (ImageView) findViewById(R.id.ivUpRightHandC);
                ivURHD = (ImageView) findViewById(R.id.ivUpRightHandD);
                //fifth player
                ivRHA = (ImageView) findViewById(R.id.ivRightHandA);
                ivRHB = (ImageView) findViewById(R.id.ivRightHandB);
                ivRHC = (ImageView) findViewById(R.id.ivRightHandC);
                ivRHD = (ImageView) findViewById(R.id.ivRightHandD);

                ImageView[] ivArray5 = {ivLHA, ivLHB, ivLHC, ivLHD,
                        ivULHA, ivULHB, ivULHC, ivULHD,
                        ivURHA, ivURHB, ivURHC, ivURHD,
                        ivRHA, ivRHB, ivRHC, ivRHD};
                for(ImageView iv: ivArray5){
                    iv.setEnabled(false);
                }
                break;
        }
    }

    public void gotoSettingsFromBoard(View v){
        startActivity(new Intent(Board_Greg.this, Settings.class));
    }
}