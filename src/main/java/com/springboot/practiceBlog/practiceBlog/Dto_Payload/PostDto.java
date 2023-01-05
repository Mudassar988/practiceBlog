package com.springboot.practiceBlog.practiceBlog.Dto_Payload;

import lombok.Data;

@Data
public class PostDto {
    private  long id;
    private  String title;
    private  String content;
}
