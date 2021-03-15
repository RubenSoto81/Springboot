package Ejercicio.service;

import Ejercicio.model.Headers;

public interface EmailSender {

	public void sendMessage(Headers headers);
	void sendWithAttachment(Headers headers, String pathToAttachment) throws Exception;
	
}
