package com.example.app.controller.admin;

import com.example.app.dao.AccountDAO;
import com.example.app.entity.Account;
import com.example.app.entity.base.BrandBase;
import com.example.app.entity.customer.Address;
import com.example.app.service.IAddress;
import com.example.app.service.IBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AccountController {

    @Autowired
    AccountDAO accountDAO;
    @Autowired
    IBrand brand;
    @Autowired
    IAddress address;

    @GetMapping
    public String home(){
        return "admin/home";
    }

    @GetMapping("/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/account-info")
    public String accountInfo(@ModelAttribute("accounts") Account account, Model model){
        UserDetails list =(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("account", list);
        return "admin/profile/account-info";
    }

    @GetMapping("/api/products-brand")
    public String getAllBrand(Model model){
        List<BrandBase> brands = brand.getAll();

        model.addAttribute("brand", brands);

        return "/admin/info/products-brand";
    }

    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
    public String del(@PathVariable("id") Long id){
        brand.del(id);
        return "redirect:/admin/info/products-brand";
    }

    @GetMapping("/api/customer-address")
    public String getAllAddress( Model model){
        List<Address> addresses = address.getAll();
        model.addAttribute("address", addresses);
        return "/admin/info/customer-address";
    }

}
