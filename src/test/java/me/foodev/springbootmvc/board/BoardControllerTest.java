package me.foodev.springbootmvc.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class BoardControllerTest {

    @Autowired
    MockMvc mockMvc; //실제로 서블릿 컨테이너를 띄우는 것이 아님 = 가짜 서블릿 컨테이너

    @Test
    public void boardViewTest() throws Exception {

        mockMvc.perform(get("/board"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("board"))
                .andExpect(model().attribute("name","foodev"))
                .andExpect(content().string(containsString("foodev"))) //뷰에서 모델에 담긴 내용을 추출하지 않았기 때문에 에러가 나타남
        ;
    }
}