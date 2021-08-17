package com.ring.connectfour.repository.cache;

import com.ring.connectfour.crosscutting.error.ConnectFourError;
import com.ring.connectfour.repository.cache.container.ConstValidate;
import com.ring.connectfour.repository.cache.container.GenericValidate;
import com.ring.connectfour.repository.cache.container.ValidateBuilder;

public class SingletonGame {

    private static SingletonGame instance;

    private String[][] game;
    private final static int FILE = 6, COLUMN = 7;

    private SingletonGame() {
        startGame();
    }

    public static SingletonGame getInstance() {
        if(instance == null) {
            instance = new SingletonGame();
        }
        return instance;
    }

    public String[][] getGame() {
        return game.clone();
    }

    public void startGame(){
        game = new String[COLUMN][FILE];
    }

    public String pushChecker(String player, int c, int f){
        c--; f--;

        if(c < COLUMN && f < FILE && game[c][f] == null) {
            game[c][f] = player;
            return validateWin(player, c, f);
        } else {
            return "Invalid move ... ";
        }
    }

    public String validateWin(String player, int column, int file){

        System.out.println("");
        for(int f = 0; f < FILE ; f++) {
            for (int c = 0; c < COLUMN; c++) {
                System.out.print((game[c][f]==null?" ":game[c][f]) + "-");
            }
            System.out.println("");
        }

        ValidateBuilder builder = new ValidateBuilder();
        builder.setCOLUMN(COLUMN)
                .setFILE(FILE)
                .setGame(game.clone());

        GenericValidate validate;
        String result;
        try {
            result = builder.build(ConstValidate.HORIZONTAL).validateWinner(player, column, file);
            if(!result.equals(""))
                return result;
        } catch (ConnectFourError ignoredException) { }

        try {
            result = builder.build(ConstValidate.VERTICAL).validateWinner(player, column, file);
            if(!result.equals(""))
                return result;
        } catch (ConnectFourError ignoredException) { }

        try {
            result = builder.build(ConstValidate.DIAGONAL).validateWinner(player, column, file);
            if(!result.equals(""))
                return result;
        } catch (ConnectFourError ignoredException) { }

        return "";
    }
}
