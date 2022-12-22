package com.example.book_library.controller;

import com.example.book_library.model.Book;
import com.example.book_library.service.exception.BookException;
import com.example.book_library.service.impl.BookService;
import org.codehaus.groovy.control.messages.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("book/index");
        modelAndView.addObject("books", bookService.findAll());
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("book/form");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("book") Book book, RedirectAttributes redirect) throws Exception {
        String message = (book.getId() == null) ? "Add successfully" : "Edit successfully";
        String path;
        try {
            bookService.save(book);
            redirect.addFlashAttribute("message", message);
            path = "redirect:/book";
        } catch (Exception exception) {
            path = "404";
        }
        return path;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView form(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        ModelAndView modelAndView;
        if (bookOptional.isPresent()) {
            modelAndView = new ModelAndView("book/form");
            modelAndView.addObject("book", bookOptional.get());
        } else {
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        ModelAndView modelAndView;
        if (bookOptional.isPresent()) {
            modelAndView = new ModelAndView("book/delete");
            modelAndView.addObject("book", bookOptional.get());
        } else {
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteB(@ModelAttribute("book") Book book, RedirectAttributes redirect) {
        bookService.remove(book.getId());
        redirect.addFlashAttribute("message", "Delete successfully");
        return "redirect:/book";
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Long id) {
        Optional<Book> bookOptional = bookService.findById(id);
        ModelAndView modelAndView;
        if (bookOptional.isPresent()) {
            modelAndView = new ModelAndView("book/view");
            modelAndView.addObject("book", bookOptional.get());
        } else {
            modelAndView = new ModelAndView("404");
        }
        return modelAndView;
    }
}
