package com.example.swagger.post.request;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String title;
    private String content;
}
