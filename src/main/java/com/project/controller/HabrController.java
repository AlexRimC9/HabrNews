package com.project.controller;

import com.project.annotation.CheckingTime;
import com.project.domain.Habr;
import com.project.exp.LoginFailExp;
import com.project.service.HabrService;
import com.project.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
public class HabrController {
    private final HabrService habrService;
    private final TokenService tokenService;


    public HabrController(HabrService habrService,TokenService tokenService) {
        this.habrService = habrService;
        this.tokenService = tokenService;
    }


    @PostMapping("/test/news/add")
    public void addNews() throws IOException, LoginFailExp {
            habrService.SingAdd();
        }

    @DeleteMapping("news/{theme}/delete")
    public void deleteNews(@RequestParam String theme) throws LoginFailExp{
            habrService.SingDelete(theme);
        }
    @DeleteMapping("news/deleteAll")
    public void deleteAllNews() throws  LoginFailExp{
            habrService.SingDeleteAdd();
            throw new LoginFailExp();
        }
    @CheckingTime
    @GetMapping("/test/news/all")
    public List<Habr> getAllNews() throws LoginFailExp{
            return habrService.getAllNews();
    }
}


