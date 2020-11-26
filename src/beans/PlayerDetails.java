package beans;

import javax.swing.JButton;
import javax.swing.JLabel;

public class PlayerDetails {

	// Button array which contains 9 buttons for 3X3 grid of tic-tac-toe
	private JButton buttonArray[][];

	public JButton[][] getButtonArray() {
		return buttonArray;
	}

	public void setButtonArray(JButton[][] buttonArray) {
		this.buttonArray = buttonArray;
	}

	// // This is a label to denote player's turn
	private JLabel playerLabel;

	public JLabel getPlayerLabel() {
		return playerLabel;
	}

	public void setPlayerLabel(JLabel playerLabel) {
		this.playerLabel = playerLabel;
	}

	private boolean player1 = true;
	private boolean player2 = false;

	public boolean isPlayer1() {
		return player1;
	}

	public void setPlayer1(boolean player1) {
		this.player1 = player1;
	}

	public boolean isPlayer2() {
		return player2;
	}

	public void setPlayer2(boolean player2) {
		this.player2 = player2;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public boolean isGameDraw() {
		return gameDraw;
	}

	public void setGameDraw(boolean gameDraw) {
		this.gameDraw = gameDraw;
	}

	public String getPlayer1Symbol() {
		return player1Symbol;
	}

	public void setPlayer1Symbol(String player1Symbol) {
		this.player1Symbol = player1Symbol;
	}

	public String getPlayer2Symbol() {
		return player2Symbol;
	}

	public void setPlayer2Symbol(String player2Symbol) {
		this.player2Symbol = player2Symbol;
	}

	private boolean gameOver ;
	private boolean gameDraw ;
	private String player1Symbol ;
	private String player2Symbol ;
	private int horizontalBound ;
	private int verticalBound ;
	 public int getHorizontalBound() {
		return horizontalBound;
	}

	public void setHorizontalBound(int horizontalBound) {
		this.horizontalBound = horizontalBound;
	}

	public int getVerticalBound() {
		return verticalBound;
	}

	public void setVerticalBound(int verticalBound) {
		this.verticalBound = verticalBound;
	}

	

}
