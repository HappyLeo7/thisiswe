package com.thisiswe.home.chat.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Document(collection = "message")
@ToString
@RequiredArgsConstructor
public class Message {
    static int countNum;

    @Id
    private Long id;

    private String clubName;

    private String userNickname;

    private String message;

    private String imageUrl;

    @CreatedDate
    private LocalDateTime createdAt;

    private String _class;


    public Message(String clubName, String userNickname, String message, String imageUrl) {
        this.id = Long.valueOf(countNum++);
        this.clubName = clubName;
        this.userNickname = userNickname;
        this.message = message;
        this.imageUrl = imageUrl;
        this.createdAt = LocalDateTime.now();
        this._class  = "아무거나";
    }
}
