package com.ring.connectfour.repository.cache.container;

public class DiagonalValidate implements GenericValidate{

    private  int FILE , COLUMN;
    private String[][] game;

    public DiagonalValidate(int column, int file, String[][] game) {
        FILE = file;
        COLUMN = column;
        this.game = game;
    }

    @Override
    public String validateWinner(String player, int column, int file) {

        //Validate diagonal-right-x winner
        int numMove = 0;
        for(int f = 3; f < FILE && f > -1 ; f++){
            int colAux = 0;
            for(int filAux = f; filAux < FILE && filAux > -1 ; filAux--) {
                if (game[colAux][filAux] != null && game[colAux][filAux].equals(player)) {
                    if (++numMove == 4)
                        return player;
                } else {
                    numMove = 0;
                }
                colAux++;
            }
        }
        //Validate diagonal-right-y winner
        numMove = 0;
        for(int c = 1; c < COLUMN && c > -1 ; c++){
            int colAux = c;
            for(int filAux = 5; filAux < FILE && filAux > -1 ; filAux--) {
                //System.out.print("[" + colAux + "][" + filAux + "] ");
                if (colAux < COLUMN && game[colAux][filAux] != null && game[colAux][filAux].equals(player)) {
                    if (++numMove == 4)
                        return player;
                } else {
                    numMove = 0;
                }
                colAux++;
            }
        }

        //Validate diagonal-left-x winner
        numMove = 0;
        for(int f = 2; f < FILE && f > -1 ; f--){
            int colAux = 0;
            for(int filAux = f; filAux < FILE && filAux > -1 ; filAux++) {
                if (game[colAux][filAux] != null && game[colAux][filAux].equals(player)) {
                    if (++numMove == 4)
                        return player;
                } else {
                    numMove = 0;
                }
                colAux++;
            }
        }
        //Validate diagonal-left-y winner
        numMove = 0;
        for(int c = 1; c < COLUMN && c > -1 ; c++){
            int colAux = c;
            for(int filAux = 0; filAux < FILE && filAux > -1 ; filAux++) {
                //System.out.print("[" + colAux + "][" + filAux + "] ");
                if (colAux < COLUMN && game[colAux][filAux] != null && game[colAux][filAux].equals(player)) {
                    if (++numMove == 4)
                        return player;
                } else {
                    numMove = 0;
                }
                colAux++;
            }
        }

        return "";
    }
}
