package com.example.demo.landray.sysNotifyTodoWebServiceSource;

import lombok.Data;

import java.util.List;

@Data
public class Message {
    private Integer pageCount;
    private Integer pageno;
    private Integer count;
    private List<MessageDoc> docs;
}
