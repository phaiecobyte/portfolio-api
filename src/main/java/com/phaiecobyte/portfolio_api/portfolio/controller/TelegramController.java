package com.phaiecobyte.portfolio_api.portfolio.controller;


import com.phaiecobyte.portfolio_api.portfolio.model.Message;
import com.phaiecobyte.portfolio_api.portfolio.repository.MessageRepository;
import com.phaiecobyte.portfolio_api.portfolio.service.TelegramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/contact")
@RestController
@RequiredArgsConstructor
public class TelegramController {
    private final MessageRepository repo;
    private final TelegramService telegramService;

    @PostMapping
    public Message saveMessage(@RequestBody Message msg){
        Message saved = repo.save(msg);

        // Send to Telegram
        String text = "📬 *New\tContact\tMessage*\n\n"
                + "👤 *Name:* " + msg.getName() + "\n"
                + "📧 *Email:* " + msg.getEmail() + "\n"
                + "📝 *Message\n" + msg.getContent();
        telegramService.sendMessage(text);
        return saved;
    }
}
