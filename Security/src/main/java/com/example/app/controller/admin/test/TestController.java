package com.example.app.controller.admin.test;

import com.example.app.entity.base.BrandBase;
import com.example.app.service.IBrand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestController {

    private final Logger LOG = LoggerFactory.getLogger(TestController.class);

    @Autowired
    IBrand brand;

    @GetMapping("/api/find-brand")
    public String getAll( Model model){
        List<BrandBase> brands = brand.getAll();
        model.addAttribute("test", brands);
        return "test";
    }

}
