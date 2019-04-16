package edu.ccut.cn.po;


import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class MessBoard {

	private  UUID uuid;
	private String name;
	private  String title;
	private  String  textArea;
	private  String date;

	private static HashMap<UUID,MessBoard >   allMessage;
	
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTextArea() {
		return textArea;
	}
	public void setTextArea(String textArea) {
		this.textArea = textArea;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public static HashMap<UUID, MessBoard> getAllMessage() {
		return allMessage;
	}
	public static void setAllMessage(HashMap<UUID, MessBoard> allMessage) {
		MessBoard.allMessage = allMessage;
	}

	
}