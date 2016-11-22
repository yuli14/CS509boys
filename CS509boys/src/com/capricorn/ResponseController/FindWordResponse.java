package com.capricorn.ResponseController;



import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import xml.Message;

import com.capricorn.RequestController.ControllerChain;
import com.capricorn.model.Model;
import com.capricorn.view.Application;

public class FindWordResponse extends ControllerChain{
	public Application app;
	public Model model;
	
	public FindWordResponse(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}
		
		
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String score = map.getNamedItem("score").getNodeValue();
		String pname = map.getNamedItem("name").getNodeValue();
		
		
		model.getPlayer().setScore(Integer.valueOf(score));

		app.getManagerg().refreshBoard();

		return true;
	}
}