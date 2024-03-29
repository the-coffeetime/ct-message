package com.coffeetime.ctmessage.domain.service;

import com.coffeetime.ctmessage.infrastructure.entity.Messages;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    Messages sendMessage(Messages message);
    Messages findByReceiverId(int receiverId);
    int deleteMessage(int messageId);
    int deleteMessagesByMessageRoomId(int messageRoomId);
    int reportMessage(int messageId);
    int reportSenderId(int senderId, int messageRoomId);
    int disableAnonymityByMessageRoomId(int messageRoomId);
}
