package com.youngun.webservice.web;

import com.youngun.webservice.domain.posts.PostsRepository;
import com.youngun.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController //responseBody를 모든 메소드에서 적용해줌. controller의 역할을 화면 리턴, restcontroller는 데이터 리턴.
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping(value = "/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}