package com.mainfile;

import beans.PlayerDetails;

public class ResetGame {
	 public  void resetGame(int size,PlayerDetails playerDetails) {
         // Re-set gameOver and gameDraw to false
       
         playerDetails.setGameDraw(false);
         playerDetails.setGameOver(false);
         // Enable all buttons and set text =  ""
         for (int i = 0; i < size; i++) {
                 for (int j = 0; j < size; j++) {
                         playerDetails.getButtonArray()[i][j].setText("");
                         playerDetails.getButtonArray()[i][j].setEnabled(true);
                 }
         }
         
         // Re-set playerLabel to Player 1
         playerDetails.getPlayerLabel().setText("Player 1");
         
         // Re-set player1 to true and player2 to false
         playerDetails.setPlayer1(true); 
         playerDetails.setPlayer2(false); 
 }

}
