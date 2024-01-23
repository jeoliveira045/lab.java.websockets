package org.lab.websocket.entities;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ChatMessage {
    private String content;
    private String sender;
    private LocalDateTime timestamp;
}
