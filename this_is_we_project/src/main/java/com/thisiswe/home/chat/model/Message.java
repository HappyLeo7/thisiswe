package com.thisiswe.home.chat.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Document("message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    private String clubName;

    private String userNickname;

    private String message;

    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdAt;

    public Message (String clubName, String userNickname, String message, String imageUrl){
        System.out.println("메시지 작성 시간 : " + createdAt);
        this.clubName = clubName;
        this.userNickname = userNickname;
        this.message = message;
        this.imageUrl = imageUrl;
    }
}
