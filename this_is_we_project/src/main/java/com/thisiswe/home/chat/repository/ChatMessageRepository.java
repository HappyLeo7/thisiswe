package com.thisiswe.home.chat.repository;

import com.thisiswe.home.chat.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ChatMessageRepository extends MongoRepository<Message, Long> {

    List<Message> findAllByClubName(String clubName);

//    void deleteAllByRoomName(String roomName);
}
