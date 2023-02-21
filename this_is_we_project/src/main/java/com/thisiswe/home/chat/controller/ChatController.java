package com.thisiswe.home.chat.controller;

import com.thisiswe.home.chat.dto.MessageResponseDto;
import com.thisiswe.home.chat.model.Room;
import com.thisiswe.home.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {
    static List<Room> roomList2 = new ArrayList<Room>();    //roomlist를 메모리에 저장?
    static int roomNumber = 0;                   //

    private final ChatService chatService;

    @RequestMapping("/chat")
    public ModelAndView chat() {
        //ModelAndView클래스
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatroom/chatroomtest");
        return mv;
    }


    //방 페이지
    @RequestMapping("/room")
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatroom/room");//어디 페이지로 보낼것인지 set
//        List<Room> rooms = chatService.getAllChatRooms();
//        mv.addObject("roomList", rooms);
        return mv;
    }

    //방 생성하기
    @RequestMapping("/createRoom")
    public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){ //@ResponseBody가 붙어 있음 스트링값을 그대로 반환합니다.
        String roomName = (String) params.get("roomName");
        System.out.println("채팅방 이름 : " + roomName);

        chatService.createChattingRoom(roomName);
        List<Room> roomList = chatService.getAllChatRooms();
        System.out.println(roomList);
        return roomList;
    }

    //방 정보 조회
    @RequestMapping("/getRoom")
    public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){
        System.out.println(chatService.getAllChatRooms());
        return chatService.getAllChatRooms();
    }


    //채팅 정보 조회
    @RequestMapping("/getChat")
    public @ResponseBody List<MessageResponseDto> getChat(@RequestParam HashMap<Object, Object> params){
        System.out.println("getChat 실행");
        String roomName = (String) params.get("roomName");
        return chatService.getMessages(roomName);
    }

    //채팅방으로 이동
    @RequestMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object ,Object> params) {
        ModelAndView mv = new ModelAndView();
        String roomName = (String) params.get("roomName");
        String roomNumber = (String) params.get("roomNumber");
        System.out.println(roomName);


        mv.setViewName("chatroom/chatroomtest");
        mv.addObject("roomName", roomName);
        mv.addObject("roomNumber", roomNumber);
        mv.addObject("chatList", chatService.getMessages(roomName));
        System.out.println("roomList1 : " + chatService.getMessages(roomName));

        return mv;
    }


    //고객센터 채팅방으로 이동
    @RequestMapping("/moveCustomersvc")
    public ModelAndView customerService( @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
//        Room room =  chatService.checkCustomerRoom(username).get();
//
//        ModelAndView mv = new ModelAndView();
//        String roomName = room.getRoomName();
//        String roomNumber = Integer.toString(room.getRoomNumber());
//        System.out.println(roomName);

//        if(roomName != null && !roomName.trim().equals("")) {
//            Room room = new Room();
//            room.setRoomNumber(++roomNumber);
//            room.setRoomName(roomName);
//            roomList.add(room);
//        }

//        mv.setViewName("chatroom/customersvc");
//        mv.addObject("roomName", roomName);
//        mv.addObject("roomNumber", roomNumber);
//        mv.addObject("userName",username);
//        mv.addObject("chatList", chatService.getMessages(roomName));
//
//        System.out.println("roomList1 : " + chatService.getMessages(roomName));
//
//        return mv;
        return null;
    }
}
