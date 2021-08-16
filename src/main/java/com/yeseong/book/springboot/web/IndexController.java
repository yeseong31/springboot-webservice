package com.yeseong.book.springboot.web;

import com.yeseong.book.springboot.config.auth.LoginUser;
import com.yeseong.book.springboot.config.auth.dto.SessionUser;
import com.yeseong.book.springboot.domain.board.Board;
import com.yeseong.book.springboot.service.board.BoardService;
import com.yeseong.book.springboot.service.posts.PostsService;
import com.yeseong.book.springboot.web.dto.BoardListResponseDto;
import com.yeseong.book.springboot.web.dto.BoardResponseDto;
import com.yeseong.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

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



    @GetMapping("/")
    public String list(Model model, @LoginUser SessionUser user,
                       @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("board", boardService.getBoardList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("checkNext", boardService.getListCheckNext(pageable));
        model.addAttribute("checkPrev", boardService.getListCheckPrev(pageable));

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "list";
    }
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        BoardListResponseDto boardList = boardService.searchBoard(keyword);
        model.addAttribute("boardList", boardList);
        return "list";
    }

}
