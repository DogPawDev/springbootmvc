package me.foodev.springbootmvc.posts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {

    @Test
    public void builderCheck(){
        Post post = Post.builder()
                .postID(1)
                .title("test title")
                .contents("<testeste>")
                .build();
        assertThat(post).isNotNull();

    }

    @Test
    public void javaBeanCheck(){
        Post post = new Post();
        String title = "test";
        String contents = "test";

        post.setTitle(title);
        post.setContents(contents);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContents()).isEqualTo(contents);
    }
}