package inspiration.inspi_web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inspiration.inspi_web.model.Message;
import inspiration.inspi_web.service.MessageService;

@RestController
@RequestMapping("/")

public class MessageController {
	private final MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	@GetMapping
    public String message(Model model) {
        model.addAttribute("users", messageService.getAllUser());

        return "conversation";
    }
	
	@PostMapping("send")
    public String sendMessage(@RequestParam String name, @RequestParam String content, Model model) {

        Message message = messageService.saveMessage(name, content);
        model.addAttribute("dernierMessage", message);
        model.addAttribute("users", messageService.getAllUser());

        return "conversation";
    }

}
