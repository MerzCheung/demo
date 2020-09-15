package com.example.demo.landray.kmReviewWebserviceServiceSource_prod;

import lombok.Data;

@Data
public class MessageDoc {
    private String id;
    private String subject;
    private Long type;
    private String key;
    private String appName;
    private String modelName;
    private Long level;
    private String moduleName;
    private String modelId;
    private String createTime;
    private String creator;
    private String creatorName;
    private String link;
}
