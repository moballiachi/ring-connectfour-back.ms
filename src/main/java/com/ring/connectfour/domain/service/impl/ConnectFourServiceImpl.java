package com.ring.connectfour.domain.service.impl;

import com.ring.connectfour.crosscutting.error.ConnectFourError;
import com.ring.connectfour.domain.service.ConnectFourService;
import com.ring.connectfour.repository.cache.SingletonGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConnectFourServiceImpl implements ConnectFourService {


    @Override
    public String validateWin() throws ConnectFourError {
        return SingletonGame.getInstance().validateWin(null, 0, 0);
    }

    @Override
    public void startGame() {
        SingletonGame.getInstance().startGame();
    }

    @Override
    public String pushChecker(String player, int c, int f) {
        return SingletonGame.getInstance().pushChecker(player, c, f);
    }
}
