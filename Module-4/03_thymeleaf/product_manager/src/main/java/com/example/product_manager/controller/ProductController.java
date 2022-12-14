package com.example.product_manager.controller;

import com.example.product_manager.model.Product;
import com.example.product_manager.service.impl.ManufacturerService;
import com.example.product_manager.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;
    private ManufacturerService manufacturerService = ManufacturerService.getInstance();


    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/form")
    public ModelAndView productForm() {
        ModelAndView modelAndView = new ModelAndView("product_form");
        modelAndView.addObject("product", new Product());
        modelAndView.addObject("manufactures", manufacturerService.findAll());
        return modelAndView;
    }

    @GetMapping("/form/{id}")
    public ModelAndView productForm(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product_form");
        modelAndView.addObject("product", productService.findById(id));
        modelAndView.addObject("manufactures", manufacturerService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product, @RequestParam("manufacturer_id") Long mId, RedirectAttributes attributes) {
        product.setId(productService.getLastIndex() + 1);
        product.setManufacturer(manufacturerService.findById(mId));
        productService.insert(product);
        attributes.addFlashAttribute("message", "Product create successfully");
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product, @RequestParam("manufacturer_id") Long mId, RedirectAttributes attributes) {
        product.setManufacturer(manufacturerService.findById(mId));
        productService.update(product.getId(), product);
        attributes.addFlashAttribute("message", "Product update successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        productService.delete(id);
        attributes.addFlashAttribute("message", "Product delete successfully");
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product_details");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping(value = "/search")
    public ModelAndView search(@RequestParam String search) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("products", productService.findByName(search));
        return modelAndView;
    }
}
