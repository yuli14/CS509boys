package com.capricorn.ResponseController;


import com.capricorn.model.Model;
import com.capricorn.view.Application;

import xml.Message;
/** After ask for the server to be connected and the server reply with the response with the connction message.*/
public class ConnectResponseController extends ControllerChain{
	
	Application app;
	Model model;
	/** Construct ConnectResponseController object to use default port number.*/
	public ConnectResponseController(Application app, Model model) {
		super();
		this.app = app;
		this.model = model;
	}
	/** Process the response and establish the conection.*/
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}		
		app.getXmlb().getMessageInfo().append(response.toString()+"\n");
		return true;
	}

}
