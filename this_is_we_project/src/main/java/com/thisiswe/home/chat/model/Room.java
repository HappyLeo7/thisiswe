package com.thisiswe.home.chat.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@RequiredArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomNumber;

    @Column
    private String roomName;

    public Room(String roomName){
        this.roomName = roomName;
    }



}
