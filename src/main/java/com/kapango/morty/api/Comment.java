package com.kapango.morty.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    private String id;
    private String userId;
    private String createdAt;
    private String text;

}
