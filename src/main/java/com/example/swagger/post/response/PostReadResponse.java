package com.example.swagger.post.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostReadResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private final LocalDateTime createdTime;
}
