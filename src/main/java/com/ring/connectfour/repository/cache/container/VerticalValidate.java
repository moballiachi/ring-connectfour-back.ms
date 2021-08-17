package com.ring.connectfour.repository.cache.container;

public class VerticalValidate implements GenericValidate{

    private  int FILE , COLUMN;
    private String[][] game;

    public VerticalValidate(int column, int file, String[][] game) {
        FILE = file;
        COLUMN = column;
        this.game = game;
    }
    @Override
    public String validateWinner(String player, int column, int file) {

        //Validate vertical winner
        int numMove = 0;
        for(int f = 0; f < FILE ; f++){
            if(game[column][f]!=null && game[column][f].equals(player)){
                if(++numMove == 4)
                    return player;
            } else {
                numMove = 0;
            }
        }
        return "";
    }
}
