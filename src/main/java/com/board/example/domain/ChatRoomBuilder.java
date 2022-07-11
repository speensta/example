package com.board.example.domain;

import lombok.Getter;
import lombok.NonNull;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
public class ChatRoomBuilder {
    private String id;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();

    // 채팅방 생성
    public static ChatRoomBuilder create(@NonNull String name) {
        ChatRoomBuilder created = new ChatRoomBuilder();
        created.id = UUID.randomUUID().toString();
        created.name = name;
        return created;
    }
}
