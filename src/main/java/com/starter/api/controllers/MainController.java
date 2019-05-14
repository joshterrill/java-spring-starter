package com.starter.api.controllers;

import com.starter.api.models.VersionInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/api")
    public VersionInfo main() {
        return new VersionInfo("1.0.0", "StarterProject");
    }
}