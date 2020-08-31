package me.foodev.springbootmvc.posts;

import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Controller
@RequestMapping(value = "/api/posts",produces = MediaTypes.HAL_JSON_VALUE)
public class PostController {

    @PostMapping
    public ResponseEntity createPost(@RequestBody Post post){

        URI createUri = linkTo(PostController.class).slash("test").toUri();
        post.setPostID(10);
        return ResponseEntity.created(createUri).body(post);
    }
}
