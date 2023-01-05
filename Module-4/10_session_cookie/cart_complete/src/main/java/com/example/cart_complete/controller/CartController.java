package com.example.cart_complete.controller;

import com.example.cart_complete.model.*;
import com.example.cart_complete.service.core.ICartDetailsService;
import com.example.cart_complete.service.core.ICartService;
import com.example.cart_complete.service.core.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final IProductService productService;
    private final ICartService cartService;
    private final ICartDetailsService cartDetailsService;

    @Autowired
    public CartController(IProductService productService, ICartService cartService, ICartDetailsService cartDetailsService) {
        this.productService = productService;
        this.cartService = cartService;
        this.cartDetailsService = cartDetailsService;
    }

    @GetMapping
    public ModelAndView toCart(HttpServletRequest request) {
        ModelAndView modelAndView;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Optional<Cart> cart = cartService.findByUser(user);
        if (cart.isPresent()) {
            modelAndView = new ModelAndView("cart/index");
            Iterable<CartDetails> cartDetails = cart.get().getCartDetails();
            modelAndView.addObject("cartDetails", cartDetails);
        } else {
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }

    @GetMapping("add/{id}")
    public String addToCart(@PathVariable("id") Long id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Optional<Product> product = productService.findById(id);
        Optional<Cart> cart = cartService.findByUser(user);
        if (cart.isPresent() && product.isPresent()) {
            Iterable<CartDetails> cartDetails = cart.get().getCartDetails();
            CartDetails c = cartDetailsService.checkProductInCart(product.get(), cartDetails);
            if (c != null) {
                c.setQuantity(c.getQuantity() + 1);
                cartDetailsService.save(c);
            } else {
                cartDetailsService.save(new CartDetails(cart.get(), product.get(), 1));
            }
            return "redirect:/cart/";
        } else {
            return "404";
        }
    }
}
