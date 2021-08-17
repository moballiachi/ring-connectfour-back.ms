package com.ring.connectfour.domain.service;

import com.ring.connectfour.crosscutting.error.ConnectFourError;

public interface ConnectFourService {

    String validateWin() throws ConnectFourError;

    void startGame();

    String pushChecker(String player, int c, int f);
}
