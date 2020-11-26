package com.mainfile;

import javax.swing.JFrame;

public class AssigmnetAOPTicTocToe {
	public static void main(String[] args) {

		 // Create a TicTacToe Instance
		TicTacToe frame= new TicTacToe();
		 // Create a frame of type TicTacToe
		JFrame mainFrame=frame.createFrame();
        // Set the title of frame and it's size
		SetFrame.setFrameDetails(mainFrame);
        
}

}
