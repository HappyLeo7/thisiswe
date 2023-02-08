package com.thisiswe.home.chat.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Room {

    int roomNumber;
    String roomName;

    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomName=" + roomName + "]";
    }

}
