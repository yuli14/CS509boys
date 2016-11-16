package com.capricorn.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.capricorn.controller.Clear;
import com.capricorn.controller.ClickLetter;
import com.capricorn.controller.Exit;
import com.capricorn.controller.Reset;
import com.capricorn.entity.Board;
import com.capricorn.model.Model;
/**
 *View part including here is designed by Jframe. PracticeGame is an interface
 *connect to the player who want to play a single game without request and response. 
 *Which means practice game can be run under the condition without connecting to server.
 *<p>
 *Jframe owns the advantage that different parts are individually and will not affect each other.
 */
public class PracticeGame extends JFrame {
	public List<String> list=new ArrayList<String>();//new word list
	public JTextField txtOwn;//the word on the button
	public JTextField textField;//define the place to store word
	public Model m;//define a new modle of game 
	public int sum;//the sum of combination of score with different word 
	public JButton btnArray[][] = new JButton[4][4];
	//define the variables in order to implement the game funtion
	/**Here is a constructor for PracticeGame in order to make a fault value.
	 * Construct PracticeGame object to use default port number.*/
    public PracticeGame(Model m) {
    	this.m=m;
		setTitle("PracticeGame");//set the title
		getContentPane().setLayout(null);
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int x = 30 + i * 100;
				int y = 80 + j * 40;
				btnArray[i][j] = new JButton(m.board.letterArray[i][j].letter);
				btnArray[i][j].setToolTipText(m.board.letterArray[i][j].points);
				btnArray[i][j].setBounds(x, y, 89, 23);
				ClickLetter clickControl = new ClickLetter(this);
				btnArray[i][j].addActionListener(clickControl);
				getContentPane().add(btnArray[i][j]);
			}
		}
		JLabel lblLettersYouPick = new JLabel("Your Word :");
		lblLettersYouPick.setBounds(35, 22, 89, 20);
		getContentPane().add(lblLettersYouPick);

		txtOwn = new JTextField();
		txtOwn.setColumns(10);
		txtOwn.setBounds(130, 22, 180, 20);
		txtOwn.setEditable(false);
		getContentPane().add(txtOwn);

		JButton btnNewButton_4 = new JButton("Submit");
		btnNewButton_4.setBounds(322, 13, 134, 40);
		getContentPane().add(btnNewButton_4);


		JLabel lblScore = new JLabel("Score :");
		lblScore.setBounds(64, 54, 61, 16);
		getContentPane().add(lblScore);

		textField = new JTextField();
		textField.setBounds(130, 48, 134, 28);
		getContentPane().add(textField);
		textField.setText("0");
		textField.setEditable(false);
		textField.setColumns(10);

		JButton btnResetBoard = new JButton("Reset Board");
		Reset resetControl = new Reset(this,m);
		btnResetBoard.addActionListener(resetControl);
		btnResetBoard.setBounds(462, 89, 111, 23);
		getContentPane().add(btnResetBoard);

		//Clear text when click clear button
		JButton btnUndo = new JButton("Clear");
		Clear clearControl = new Clear(this);
		btnUndo.addActionListener(clearControl);
		btnUndo.setBounds(333, 49, 117, 29);
		getContentPane().add(btnUndo);
		
		JButton btnNewButton_2 = new JButton("Exit Practice");
		Exit exitControl = new Exit(this);
		btnNewButton_2.addActionListener(exitControl);
		btnNewButton_2.setBounds(462, 14, 111, 38);
		getContentPane().add(btnNewButton_2);
	}

}
