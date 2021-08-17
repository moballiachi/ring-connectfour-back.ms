package com.ring.connectfour.controller.repository.cache;

import com.ring.connectfour.repository.cache.SingletonGame;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class SingletonGameTest {

    @Test
    public void testStartGame() {
        SingletonGame.getInstance().pushChecker("2", 6, 1);
        SingletonGame.getInstance().pushChecker("2", 6, 2);
        SingletonGame.getInstance().pushChecker("2", 6, 3);
        String result = SingletonGame.getInstance().pushChecker("2", 6, 4);
        assertTrue(result.equals("2"));
    }
}
