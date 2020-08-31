package me.foodev.springbootmvc.posts;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(of="postID")
public class Post {

    private Integer postID;
    private String title;
    private String contents;
    private String createUser;
    private String[] imgSource;
    private LocalDateTime createPostTime;
    private Integer click;




}
