package com.thisiswe.home.chat.mongodb;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final MongoTemplate mongoTemplate;

    public void mongoInsert() {
        System.out.println("됐으요잉~ㄴ");
        AlarmLog alarmLog = new AlarmLog(1L, "제목", "메세지");
        mongoTemplate.insert(alarmLog);
    }
}