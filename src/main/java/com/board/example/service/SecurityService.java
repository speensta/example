package com.board.example.service;

import com.board.example.dto.Token;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface SecurityService {
    String createToken(String subject, long ttlMillis, HashMap map);

    String getSubject(String token);

    public void rabbitmq(Token token);
}
