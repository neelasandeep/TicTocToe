package com.mainfile;

import javax.swing.JFrame;

public class SetFrame {
	public static void setFrameDetails(JFrame mainFrame) {
		mainFrame.setTitle("Tic Tac Toe");
        mainFrame.setSize(300, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
	}

}
