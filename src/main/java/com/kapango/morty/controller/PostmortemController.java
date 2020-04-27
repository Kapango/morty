package com.kapango.morty.controller;

import com.kapango.morty.api.Postmortem;
import com.kapango.morty.api.PostmortemApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postmortem")
public class PostmortemController implements PostmortemApi {


    @GetMapping("/{id}")
    @Override
    public Postmortem getPostmortem(@PathVariable String id) {
        return null;
    }

    @PostMapping
    @Override
    public Postmortem createPostmortem(@RequestBody Postmortem request) {
        return null;
    }
}
