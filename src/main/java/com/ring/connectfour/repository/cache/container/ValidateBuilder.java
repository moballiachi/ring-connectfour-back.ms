package com.ring.connectfour.repository.cache.container;

import com.ring.connectfour.crosscutting.error.ConnectFourError;

public class ValidateBuilder {

    private  int FILE, COLUMN;
    private String[][] game;

    public ValidateBuilder setFILE(int FILE) {
        this.FILE = FILE;
        return this;
    }

    public ValidateBuilder setCOLUMN(int COLUMN) {
        this.COLUMN = COLUMN;
        return this;
    }

    public ValidateBuilder setGame(String[][] game) {
        this.game = game;
        return this;
    }

    public GenericValidate build(ConstValidate factory) throws ConnectFourError {

        if(FILE==0 || COLUMN==0 || game==null)
            throw new ConnectFourError("[ERROR] Parameters requered");

        switch (factory) {
            case HORIZONTAL:
                return new HorizontalValidate(COLUMN, FILE, game);
            case VERTICAL:
                return new VerticalValidate(COLUMN, FILE, game);
            default:
                return new DiagonalValidate(COLUMN, FILE, game);
        }
    }
}
