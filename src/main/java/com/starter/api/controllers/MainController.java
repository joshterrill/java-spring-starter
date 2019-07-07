package com.starter.api.controllers;

import com.starter.api.models.VersionInfo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@Api(tags="Main", description = "Sample controller endpoint")
public class MainController {

    @GetMapping("/version")
    public VersionInfo main() {
        return new VersionInfo("1.0.0", "StarterProject");
    }
}