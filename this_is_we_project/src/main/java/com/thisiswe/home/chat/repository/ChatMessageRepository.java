package com.thisiswe.home.chat.repository;

import com.thisiswe.home.chat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<Message, Long> {

}
