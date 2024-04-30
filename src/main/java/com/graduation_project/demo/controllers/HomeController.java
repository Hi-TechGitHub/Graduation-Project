package com.graduation_project.demo.controllers;

import com.graduation_project.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.graduation_project.demo.services.AdminService;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AdminService service;


    @Autowired
    private final AdminService adminService;

    public HomeController( AdminService adminService) {

        this.adminService = adminService;
    }

    @GetMapping("/")
    public String home() {

        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "redirect:/";
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/admin")
    public String admin() {

        return "admin";
    }


    @PostMapping("/admin")
    public List<Product> getProducts() {
        return adminService.getProducts();
    }

    //	@PostMapping("/abc")
//	public List<Product> getProducts() {
//		return adminService.getProducts();
//	}
    @GetMapping("/getDB")
    public String getAllProducts(Model model) {
        List<Product> products = adminService.productRepository.findAll();
        model.addAttribute("products", products);
        return "showDB";
    }


    @PostMapping("/create")
    public String addProduct(@RequestParam("name") String name, @RequestParam("description") String description) {
        adminService.addProduct(new Product(name, description));
        return "redirect:/admin";
    }

    @GetMapping("/delete-form")
    public String showDeleteForm(Model model) {
        model.addAttribute("product", new Product());
        return "delete-product";

    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") Long id) {
        adminService.deleteProduct(id);
        return "redirect:/admin";
    }
}
