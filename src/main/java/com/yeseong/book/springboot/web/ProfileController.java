package com.yeseong.book.springboot.web;

// 이후 배푸 시 8081을 쓸지, 8082를 쓸지를 판단하는 기준을 함

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {

    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());     // (1)
        List<String> realProfiles = Arrays.asList("real", "real1", "real2");
        String defaultProfile = profiles.isEmpty()? "default": profiles.get(0);

        return profiles.stream().filter(realProfiles::contains)
                .findAny().orElse(defaultProfile);
    }

}
