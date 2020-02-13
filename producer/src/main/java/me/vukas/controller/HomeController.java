package me.vukas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/list/{name}")
    public SampleDto calculateString(@PathVariable String name){
        return new SampleDto(1, name);
    }
}
