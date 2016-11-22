package com.capricorn.RequestController;

import xml.Message;

import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class RepositionBoardRequest {
	Model model;
	Application app;
	int change;
	public RepositionBoardRequest(Model model,Application app,int change){
		this.model = model;
		this.app = app;
		this.change = change;
		
	}
	
	public void process(){
		
	String xmlString = Message.requestHeader() + String.format("<repositionBoardRequest name='%s' gameId='%s'", 
			model.getPlayer().getName(), model.getGame().getGameId())  
			+" rowChange='"+ change
			+"' colChange='" + change + "'/></request>";

Message m = new Message (xmlString);

app.getServerAccess().sendRequest(m);	
}
}