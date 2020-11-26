package com.mainfile;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import beans.ButtonsValues;
import beans.PlayerDetails;

public class CheckWinner {

	private int size;
	ResetGame reset;
	PlayerDetails playerDetails;

	CheckWinner(int size, PlayerDetails playerDetails) {
		reset = new ResetGame();
		this.playerDetails = playerDetails;
		this.size = size;
	}

	public void checkWin(String currentPlayer) {

		ButtonsValues btnvalues = new ButtonsValues();
		setButtonvalues(btnvalues);
		checkIsGameOver(btnvalues);

		// Set gameOver to true, if any of the below conditions is true
		// If row 1 matched

		// If game is over
		if (playerDetails.isGameOver()) {
			int result = -1;
			UIManager.put("OptionPane.background", Color.white);
			UIManager.put("Panel.background", Color.white);

			// If draw, display message "GAME DRAW"
			// Ask user if they want to play again
			if (playerDetails.isGameDraw()) {
				result = JOptionPane.showConfirmDialog(null, "Vovooo game is Draw \\nDo you want to play Again ?", "Game Over",
						JOptionPane.YES_NO_OPTION);
			}
			// Else, display who won
			// Ask user if they want to play again
			else {

				result = JOptionPane.showConfirmDialog(null, currentPlayer + " wins!!\nDo you want to play Again ?",
						"Game Over", JOptionPane.YES_NO_OPTION);
//				 JOptionPane.showConfirmDialog(null, currentPlayer + " wins!!\nDo you want to play Again ?",
//						"Game Over", JOptionPane.YES_NO_OPTION);
			}

			// If result == 0, means user clicked YES on dialog box
			// Reset game, else exit game
			if (result == 0) {
				reset.resetGame(size, playerDetails);
			} else {
				System.exit(0);
			}
		}
	}

	public void setButtonvalues(ButtonsValues btnValues) {

		btnValues.setValueAt00(playerDetails.getButtonArray()[0][0].getText());
		btnValues.setValueAt01(playerDetails.getButtonArray()[0][1].getText());
		btnValues.setValueAt02(playerDetails.getButtonArray()[0][2].getText());
		btnValues.setValueAt10(playerDetails.getButtonArray()[1][0].getText());
		btnValues.setValueAt11(playerDetails.getButtonArray()[1][1].getText());
		btnValues.setValueAt12(playerDetails.getButtonArray()[1][2].getText());
		btnValues.setValueAt20(playerDetails.getButtonArray()[2][0].getText());
		btnValues.setValueAt21(playerDetails.getButtonArray()[2][1].getText());
		btnValues.setValueAt22(playerDetails.getButtonArray()[2][2].getText());

	}

	public void checkIsGameOver(ButtonsValues btnvalues) {
		if (btnvalues.getValueAt00() == btnvalues.getValueAt01() && btnvalues.getValueAt01() == btnvalues.getValueAt02()
				&& btnvalues.getValueAt00() != "") {
			playerDetails.setGameOver(true);
		}
		// If row 2 matched
		else if (btnvalues.getValueAt10() == btnvalues.getValueAt11()
				&& btnvalues.getValueAt11() == btnvalues.getValueAt12() && btnvalues.getValueAt10() != "") {
			playerDetails.setGameOver(true);
		}
		// If row 3 matched
		else if (btnvalues.getValueAt20() == btnvalues.getValueAt21()
				&& btnvalues.getValueAt21() == btnvalues.getValueAt22() && btnvalues.getValueAt20() != "") {
			playerDetails.setGameOver(true);
		}
		// If column 1 matched
		else if (btnvalues.getValueAt00() == btnvalues.getValueAt10()
				&& btnvalues.getValueAt10() == btnvalues.getValueAt20() && btnvalues.getValueAt00() != "") {
			playerDetails.setGameOver(true);
		}
		// If column 2 matched
		else if (btnvalues.getValueAt01() == btnvalues.getValueAt11()
				&& btnvalues.getValueAt11() == btnvalues.getValueAt21() && btnvalues.getValueAt01() != "") {
			playerDetails.setGameOver(true);
		}
		// If column 3 matched
		else if (btnvalues.getValueAt02() == btnvalues.getValueAt12()
				&& btnvalues.getValueAt12() == btnvalues.getValueAt22() && btnvalues.getValueAt02() != "") {
			playerDetails.setGameOver(true);
		}
		// If diagonal elements matched
		else if (btnvalues.getValueAt00() == btnvalues.getValueAt11()
				&& btnvalues.getValueAt11() == btnvalues.getValueAt22() && btnvalues.getValueAt00() != "") {
			playerDetails.setGameOver(true);

		}
		// If diagonal elements matched
		else if (btnvalues.getValueAt02() == btnvalues.getValueAt11()
				&& btnvalues.getValueAt11() == btnvalues.getValueAt20() && btnvalues.getValueAt02() != "") {
			playerDetails.setGameOver(true);

		}
		// When all buttons are clicked but no one won - draw condition
		// Set gameDraw to true as well
		else if (btnvalues.getValueAt00() != "" && btnvalues.getValueAt01() != "" && btnvalues.getValueAt02() != ""
				&& btnvalues.getValueAt10() != "" && btnvalues.getValueAt11() != "" && btnvalues.getValueAt12() != ""
				&& btnvalues.getValueAt20() != "" && btnvalues.getValueAt21() != "" && btnvalues.getValueAt22() != "") {
			playerDetails.setGameOver(true);
			playerDetails.setGameDraw(true);
		}
	}

}
