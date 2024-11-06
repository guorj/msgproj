package com.vstu.msgproj.process.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EChartsController {

    @GetMapping("/echarts")
    public String showECharts() {
        return "index"; // 指定 Thymeleaf 模板文件名
    }
}