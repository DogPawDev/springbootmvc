package me.foodev.springbootmvc.posts;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Pos;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;


    @Test
    public void createPost() throws Exception{


        Post post = Post.builder()
                .postID(1)
                .title("제목 테스트")
                .contents("띠로ㄸㄹㄹ><<ㄹㄸ<ㄹㄸ")
                .imgSource("test")
                .build();

        mockMvc.perform(post("/api/posts/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(post))
        )
                .andDo(print())
        .andExpect(status().isCreated())



        ;
    }
}