package com.example.book_library.controller;

import com.example.book_library.model.Book;
import com.example.book_library.model.BorrowCode;
import com.example.book_library.service.core.IBookService;
import com.example.book_library.service.core.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
@RequestMapping("/borrow")
public class BorrowController {
    private final IBorrowCodeService borrowCodeService;
    private final IBookService bookService;

    @Autowired
    public BorrowController(IBorrowCodeService borrowCodeService, IBookService bookService) {
        this.borrowCodeService = borrowCodeService;
        this.bookService = bookService;
    }

    @GetMapping
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("borrow/index");
        modelAndView.addObject("borrows", borrowCodeService.findAll());
        return modelAndView;
    }

    @PostMapping("/borrow")
    public String borrow(@RequestParam(value = "id", required = false) Long id, RedirectAttributes redirect) {
        LocalDateTime dateBorrow = LocalDateTime.now();
        String code = BorrowCode.generateCode();
        Optional<Book> bookOptional = bookService.findById(id);
        if (!bookOptional.isPresent()) {
            return "404";
        } else {
            BorrowCode borrowCode = new BorrowCode(code, dateBorrow, null, bookOptional.get());
            try {
                borrowCodeService.save(borrowCode);
                Book book = bookOptional.get();
                book.setQuantity(book.getQuantity() - 1);
                bookService.save(book);
                redirect.addFlashAttribute("message", "Borrow successfully");
                redirect.addFlashAttribute("code", code);
            } catch (Exception e) {
                return "404";
            }
            return "redirect:/book/view/" + id;
        }
    }

    @GetMapping("/form")
    public ModelAndView form() {
        return new ModelAndView("borrow/form");
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam(value = "code", required = false) String code, RedirectAttributes redirect) {
        Optional<BorrowCode> borrowCode = borrowCodeService.findBorrowCodeByCode(code);
        if (!borrowCode.isPresent()) {
            return "404";
        }
        Book book = borrowCode.get().getBook();
        LocalDateTime dateReturn = LocalDateTime.now();
        borrowCode.get().setDateReturn(dateReturn);
        book.setQuantity(book.getQuantity() + 1);
        try {
            bookService.save(book);
            borrowCodeService.save(borrowCode.get());
        } catch (Exception exception) {
            return "404";
        }
        redirect.addFlashAttribute("message", "Return successfully");
        return "redirect:/book";
    }
}
