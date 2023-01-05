package com.example.cart_complete.controller;

import com.example.cart_complete.model.Product;
import com.example.cart_complete.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService;

    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ModelAndView product() {
        ModelAndView modelAndView = new ModelAndView("/product/index");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView toForm() {
        ModelAndView modelAndView = new ModelAndView("product/form");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product, RedirectAttributes redirect) {
        String image = productService.copyImage(product);
        String code = productService.generateCode();
        if (image.equals("404")) {
            return "404";
        }
        product.setCode(code);
        productService.save(product);
        redirect.addFlashAttribute("message", "Product add successfully");
        return "redirect:/product";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        ModelAndView modelAndView;
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            modelAndView = new ModelAndView("product/view");
            modelAndView.addObject("product", product.get());
        } else {
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }
}
