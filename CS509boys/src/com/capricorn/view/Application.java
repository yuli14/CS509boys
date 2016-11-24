package com.capricorn.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.capricorn.RequestController.CreateGameRequest;
import com.capricorn.RequestController.JoinGameRequest;
import com.capricorn.RequestController.StartPractice;
import com.capricorn.model.Model;
import com.capricorn.entity.*;

import client.ServerAccess;

public class Application extends JFrame {
	private JTextField create_id_text;
	private JTextField name_id_text;
	private JTextField create_pass_text;
	public Model model;
	String playerName;
	String password;
	String gameNumber;
	MultiGame mg;
	static Application app;
	JLabel lbl_GameId;
	JLabel lbl_Player;
	
	
	
	
	ServerAccess serverAccess ;
	
	public static Application getInstance(Model model) {
		if (app == null) {
			app = new Application(model);
		}
		
		return app;
	}
	
	

	public ServerAccess getServerAccess() {
		return serverAccess;
	}

	public void setServerAccess(ServerAccess serverAccess) {
		this.serverAccess = serverAccess;
	}
	public String getPlayName(){
		return name_id_text.getText();
	}
	public boolean notHasPlayerName(){
		playerName = name_id_text.getText();
		if(playerName.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "playerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			name_id_text.requestFocus();
			return true;
		}
		return false;
	}
	public boolean notHasPlayerNameAndGameId(){			
		gameNumber = create_id_text.getText();
		playerName = name_id_text.getText();
		if(gameNumber.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "gameID can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			create_id_text.requestFocus();
			return true;
		}else if(playerName.length() == 0){
			JOptionPane.showMessageDialog(Application.this, "playerName can not be empty", "Warning", JOptionPane.WARNING_MESSAGE);
			name_id_text.requestFocus();
			return true;
		}
		return false;
	}			
//	public List<Player> getPlayerInformation():
		

	public String getPlayerName() {
		return playerName;
	}



	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public void setGameNumber(String gameNumber) {
		this.gameNumber = gameNumber;
	}



	public JTextField getCreate_id_text() {
		return create_id_text;
	}



	public void setCreate_id_text(JTextField create_id_text) {
		this.create_id_text = create_id_text;
	}



	public JTextField getName_id_text() {
		return name_id_text;
	}



	public void setName_id_text(JTextField name_id_text) {
		this.name_id_text = name_id_text;
	}



	public JLabel getLbl_GameId() {
		return lbl_GameId;
	}



	public void setLbl_GameId(JLabel lbl_GameId) {
		this.lbl_GameId = lbl_GameId;
	}



	public JLabel getLbl_Player() {
		return lbl_Player;
	}



	public void setLbl_Player(JLabel lbl_Player) {
		this.lbl_Player = lbl_Player;
	}



	public String getPassword() {
		return create_pass_text.getText();
	}

	

	public String getGameNumber() {
		return gameNumber;
	}

	

	public MultiGame getManagerg() {
		return mg;
	}

	

	

	

	public Application(Model m) {
        this.model=m;
		setSize(600, 300);
		setTitle("WordSweeper");
		getContentPane().setLayout(null);

		JButton btnStart = new JButton("Create a game");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!notHasPlayerName()){
					
				
				
				
				new CreateGameRequest(Application.this, model).process();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				mg = new MultiGame(model,app);
				mg.setSize(1000, 700); 
				mg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				mg.setVisible(true);
				dispose();
				
			}
			}
		});
		btnStart.setBounds(65, 37, 149, 23);
		getContentPane().add(btnStart);

		JButton btnStop = new JButton("Join a game");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!notHasPlayerNameAndGameId()){
					new JoinGameRequest(model, Application.this);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					MultiGame guestg = new MultiGame(model,app);
					guestg.setSize(900, 600); 
					guestg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					guestg.setVisible(true);
				
				}
			}
		});
		btnStop.setBounds(65, 72, 149, 23);
		getContentPane().add(btnStop);
		
		JButton btnNewButton_1 = new JButton("Practice mode");
//		m=new Model();
		StartPractice StartPracticeControl= new StartPractice(this,model);
		
		btnNewButton_1.addActionListener(StartPracticeControl);
		btnNewButton_1.setBounds(65, 215, 117, 29);
		getContentPane().add(btnNewButton_1);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // exit game
			}
		});
		btnExit.setBounds(370, 215, 117, 29);
		getContentPane().add(btnExit);

		create_id_text = new JTextField();
		create_id_text.setBounds(226, 33, 134, 28);
		getContentPane().add(create_id_text);
		create_id_text.setColumns(10);

		lbl_GameId = new JLabel("Game ID");
		lbl_GameId.setBounds(389, 39, 61, 16);
		getContentPane().add(lbl_GameId);

		name_id_text = new JTextField();
		name_id_text.setBounds(226, 96, 134, 28);
		getContentPane().add(name_id_text);
		name_id_text.setColumns(10);

		lbl_Player = new JLabel("Player Name");
		lbl_Player.setBounds(389, 102, 98, 16);
		getContentPane().add(lbl_Player);

		create_pass_text = new JTextField();
		create_pass_text.setBounds(226, 63, 134, 28);
		getContentPane().add(create_pass_text);
		create_pass_text.setColumns(10);

		JLabel lblPasswordOptional = new JLabel("Password ( Optional )");
		lblPasswordOptional.setBounds(389, 69, 137, 16);
		getContentPane().add(lblPasswordOptional);
	}
}
