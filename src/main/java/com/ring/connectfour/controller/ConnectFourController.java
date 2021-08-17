package com.ring.connectfour.controller;

import com.ring.connectfour.crosscutting.error.ConnectFourError;
import com.ring.connectfour.domain.service.ConnectFourService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/connectfour")
@Api(value = "connectfour")
public class ConnectFourController {

    @Autowired
    ConnectFourService connectFourService;

    @ApiOperation(value = "Validate if a game is won by a player.", nickname = "validateWinGET", notes = "Find a winner.", tags={ "ConnectFour", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find a winner."),
            @ApiResponse(code = 400, message = "Bad Request: Message input invalid, the object has no valid format.")})
    @RequestMapping(value = "/validatewin", produces = { "application/json" }, method = RequestMethod.GET)
    public String validateWinGET() throws ConnectFourError {
        return connectFourService.validateWin();
    }

    @ApiOperation(value = "Star game.", nickname = "starGameGET", notes = "Star game.", tags={ "ConnectFour", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Star game."),
            @ApiResponse(code = 400, message = "Bad Request: Message input invalid, the object has no valid format.")})
    @RequestMapping(value = "/stargame", produces = { "application/json" }, method = RequestMethod.GET)
    public void starGameGET() throws ConnectFourError {
        connectFourService.startGame();
    }

    @ApiOperation(value = "Push a check in the table.", nickname = "pushCheckerPOST", notes = "Push a checker.", tags={ "ConnectFour", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Push check."),
            @ApiResponse(code = 400, message = "Bad Request: Message input invalid, the object has no valid format.")})
    @RequestMapping(value = "/pushChecker/{player}/{c}/{f}", produces = { "application/json" }, method = RequestMethod.POST)
    public String pushCheckerPOST(@ApiParam(value = "Id player.", required = true) @PathVariable("player") String player,
                            @ApiParam(value = "Column.", required = true) @PathVariable("c") int c,
                            @ApiParam(value = "File.", required = true) @PathVariable("f") int f)
            throws ConnectFourError {

        return connectFourService.pushChecker(player, c, f);
    }

}
