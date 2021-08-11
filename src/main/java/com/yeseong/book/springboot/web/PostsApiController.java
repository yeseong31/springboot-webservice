package com.yeseong.book.springboot.web;

import com.yeseong.book.springboot.service.posts.PostsService;
import com.yeseong.book.springboot.web.dto.PostsResponseDto;
import com.yeseong.book.springboot.web.dto.PostsSaveRequestDto;
import com.yeseong.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor    // 선언된 모든 final 필드가 포함된 생성자를 생성
@RestController             // 컨트롤러를 JSON으로 반환하는 컨트롤러로 만듦
public class PostsApiController {

    private final PostsService postsService;

    // 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    // 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    // 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    // 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
