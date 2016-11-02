package com.capricorn.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.capricorn.model.Model;
import com.capricorn.view.PracticeGame;
import com.capricorn.view.StartPage;

import xml.Message;


public class JoinGameController implements ActionListener{
	StartPage st;
	Model m;
	
	/**
	 * the action 
	 */
	
	public JoinGameController(StartPage p,Model m) {
		this.st=p;
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}


	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);

		// deal with the m (message) to get parameters
		
		
	}
}
