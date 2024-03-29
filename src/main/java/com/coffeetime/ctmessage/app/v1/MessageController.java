package com.coffeetime.ctmessage.app.v1;

import com.coffeetime.ctmessage.domain.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
public class MessageController implements IMessageController {

    private final MessageService messageService;

    public MessageController(@Autowired MessageService messageService) {
        this.messageService = messageService;
    }
}
