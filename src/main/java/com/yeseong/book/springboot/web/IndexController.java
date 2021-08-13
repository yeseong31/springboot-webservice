package com.yeseong.book.springboot.web;

import com.yeseong.book.springboot.config.auth.LoginUser;
import com.yeseong.book.springboot.config.auth.dto.SessionUser;
import com.yeseong.book.springboot.service.board.BoardService;
import com.yeseong.book.springboot.service.posts.PostsService;
import com.yeseong.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final BoardService boardService;

    // @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/")
    public String list(Model model, @LoginUser SessionUser user) {
        model.addAttribute("board", boardService.findAll());
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "list";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

}
