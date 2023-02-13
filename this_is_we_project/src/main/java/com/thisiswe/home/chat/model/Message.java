package com.thisiswe.home.chat.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Document("message")
@ToString
public class Message {
    static long countNum;

    @Id
    private Long messageId;

    private String clubName;

    private String userNickname;

    private String message;

    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdAt;


    public void setMessageId(Long id) {
        this.messageId = id;
    }

    public Message(String clubName, String userNickname, String message, String imageUrl) {
        System.out.println("메시지 작성 시간 : " + createdAt);
        this.messageId = countNum++;
        this.clubName = clubName;
        this.userNickname = userNickname;
        this.message = message;
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
    }
}
