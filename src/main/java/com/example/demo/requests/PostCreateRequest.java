package com.example.demo.requests;


import lombok.Data;

@Data
public class PostCreateRequest {
    Long Id;
    String text;
    String title;
    Long UserId;
     

}
