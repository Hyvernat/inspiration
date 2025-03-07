package inspiration.inspi_web.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import inspiration.inspi_web.model.Message;
import inspiration.inspi_web.model.User;
import inspiration.inspi_web.repository.MessageRepository;
import inspiration.inspi_web.repository.UserRepository;

@Service
public class MessageService {
	private UserRepository userRepository;
	private MessageRepository messageRepository;
	private final RestTemplate restTemplate;
	
	public MessageService(MessageRepository messageRepository, UserRepository userRepository, RestTemplate restTemplate) {
		this.messageRepository = messageRepository; 
		this.userRepository = userRepository;
		this.restTemplate = restTemplate;
	}
	
	
	public List<Message> getAllMessages(Integer id){
		return messageRepository.findByUserId(id);
	}
	public Message saveMessage(String name, String content) {
		User user= userRepository.findByName(name);
		Map<String, String> response = restTemplate.getForObject("http://localhost:8081/getQuote", Map.class);
		String quote = "" ;
		if (response != null) {
            quote = response.get("message");
        }
		Message message = new Message(user, content, quote, new Timestamp(System.currentTimeMillis()));
		
		return messageRepository.save(message);
	}
	
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	

}
