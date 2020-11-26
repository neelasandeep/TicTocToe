package com.mainfile;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import beans.PlayerDetails;

public class TicTacToe extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public final static int SIZE = 3;

	PlayerDetails playerDetails = new PlayerDetails();
	CheckWinner winner;

	// Initial Conditions

	// X,Y to set controls on proper location
	TicTacToe() {
		playerDetails.setHorizontalBound(50);
		playerDetails.setVerticalBound(50);
		playerDetails.setPlayer1Symbol("X");
		playerDetails.setPlayer2Symbol("O");
		playerDetails.setGameDraw(false);
		playerDetails.setGameOver(false);
	}

	public JFrame createFrame() {

		winner = new CheckWinner(SIZE, playerDetails);

		JFrame frame = new JFrame();
		// Creating Panel
		JPanel panel = new JPanel();
		// setting bounds for panel
		panel.setBounds(50, 40, 200, 400);
		// setting Layout
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		playerDetails.setButtonArray(new JButton[SIZE][SIZE]);

		// Set playerLabel with text Player 1 and set it's location
		playerDetails.setPlayerLabel(new JLabel("Player 1"));

		playerDetails.getPlayerLabel().setBounds(120, 10, 100, 30);

		// Adding buttons to panel
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				playerDetails.getButtonArray()[i][j] = new JButton();
				playerDetails.getButtonArray()[i][j].addActionListener(this);
				playerDetails.getButtonArray()[i][j].setBackground(Color.BLACK);
				playerDetails.getButtonArray()[i][j].setForeground(Color.GRAY);
				playerDetails.getButtonArray()[i][j].setFocusPainted(false);
				playerDetails.getButtonArray()[i][j].setBorderPainted(false);
				playerDetails.getButtonArray()[i][j].setBounds(playerDetails.getHorizontalBound(),
						playerDetails.getVerticalBound(), 50, 50);
				playerDetails.setHorizontalBound(playerDetails.getHorizontalBound() + 60);
				// If 3 buttons are added
				// Arranging bounds for next row in panel
				if (j == SIZE - 1) {
					// adding 60 units to make buttons visible at center
					playerDetails.setVerticalBound(playerDetails.getVerticalBound() + 60);
					playerDetails.setHorizontalBound(50);
				}
				panel.add(playerDetails.getButtonArray()[i][j]);
			}
		}
		// Add layout and panel to frame
		setLayout(null);
		frame.add(playerDetails.getPlayerLabel());
		frame.add(panel);
		return frame;
	}

	// This method handles click events of buttons
	@Override
	public void actionPerformed(ActionEvent e) {

		// If game is not over yet
		if (playerDetails.isGameOver() == false) {

			// If it was player1 chance
			// Set player1 to false, player2 to true (For next chance)
			// Call checkWin function to see if player 1 won
			if (playerDetails.isPlayer1()) {
				playerDetails.setPlayer1(false);
				playerDetails.setPlayer2(true);
				setSymbol((JButton) e.getSource(), playerDetails.getPlayer1Symbol(), "Player 2");
				winner.checkWin("Player 1");
			}
			// Else it was player2 chance
			// Set player2 to false, player1 to true (For next chance)
			// Call checkWin function to see if player 2 won
			else {
				playerDetails.setPlayer2(false);
				playerDetails.setPlayer1(true);
				setSymbol((JButton) e.getSource(), playerDetails.getPlayer2Symbol(), "Player 1");
				winner.checkWin("Player 2");
			}
		}
	}

	public void setSymbol(JButton button, String symbol, String labelText) {
		// setting button text
		button.setText(symbol);
		button.setEnabled(false);
		playerDetails.getPlayerLabel().setText(labelText);
	}

}
