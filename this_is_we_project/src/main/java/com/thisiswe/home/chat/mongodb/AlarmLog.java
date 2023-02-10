package com.thisiswe.home.chat.mongodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@AllArgsConstructor
@Getter
@Document("alarm_log")
public class AlarmLog {
    @Id
    private Long id;
    private String title;
    private String message;
}