package com.example.bluesyroom.controller;

import com.example.bluesyroom.customAnnotation.AdminAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AdminAuthorize
@RestController
@RequestMapping("/admin")
public class AdminController {
}
