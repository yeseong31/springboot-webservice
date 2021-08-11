package com.yeseong.book.springboot.web.dto;

import com.yeseong.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter     // 선언된 모든 필드의 get 메서드를 생성함
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title, content, author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
