package com.ring.connectfour.repository.cache.container;

public class HorizontalValidate implements GenericValidate{

    private  int FILE , COLUMN;
    private String[][] game;

    public HorizontalValidate(int column, int file, String[][] game) {
        FILE = file;
        COLUMN = column;
        this.game = game;
    }

    @Override
    public String validateWinner(String player, int column, int file) {


        //Validate horizontal winner
        int numMove = 0;
        for(int c = 0; c < COLUMN ; c++){
            if(game[c][file]!=null && game[c][file].equals(player)){
                if(++numMove == 4)
                    return player;
            } else {
                numMove = 0;
            }
        }
        return "";
    }
}
