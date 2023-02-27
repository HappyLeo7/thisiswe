package com.thisiswe.home.chat.repository;

import com.thisiswe.home.chat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<Room, Integer> {

    void deleteByRoomName(String roomName);
    Optional<Room> findByRoomName(String roomName);

}
