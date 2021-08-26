package com.example.app.controller.admin;

import com.example.app.entity.base.BrandBase;
import com.example.app.model.ResponseDataModel;
import com.example.app.service.IBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ProductsBrandController {

    @Autowired
    IBrand brand;

    @GetMapping("/api/find")
    @ResponseBody
    public ResponseDataModel findBrandByIdApi(@RequestParam("id") Long brandId) {
        return brand.findBrandByIdApi(brandId);
    }

    @PostMapping(value = {"/api/add"})
    @ResponseBody
    public ResponseDataModel addApi(@ModelAttribute BrandBase brandBase) {
        return brand.addApi(brandBase);
    }

}
