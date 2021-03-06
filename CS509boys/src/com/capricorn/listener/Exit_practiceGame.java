package com.capricorn.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.capricorn.entity.Board;
import com.capricorn.entity.Model;
import com.capricorn.view.PracticeGame;
import com.capricorn.view.Application;
/**Exit controller implement actionlistener.
 * @author Chen Li, Dongsheng Wang, Yu Li, Tianyu Wu, Bowen Sun
 */
public class Exit_practiceGame implements ActionListener{
	JFrame j;
	Model m;

/**
 * Here is a constructor for Exit in order to make a fault value.
 * Construct Exit object to use default port number.
 *
 * @param j the j
 * @param m the m
 */
	public Exit_practiceGame(JFrame j,Model m){
		this.j=j;
		this.m=m;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		j.dispose();
		
		Application page = Application.getInstance(m);
		page.setSize(600, 300); 
		page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		page.setVisible(true);
	}
}
