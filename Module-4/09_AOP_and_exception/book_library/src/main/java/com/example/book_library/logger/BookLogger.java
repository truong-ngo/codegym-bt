package com.example.book_library.logger;

import com.example.book_library.model.BorrowCode;
import com.example.book_library.service.core.IBorrowCodeService;
import com.example.book_library.service.exception.BookException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class BookLogger {
    private final IBorrowCodeService borrowCodeService;

    @Autowired
    public BookLogger(IBorrowCodeService borrowCodeService) {
        this.borrowCodeService = borrowCodeService;
    }

    @AfterThrowing(pointcut = "execution(public * com.example.book_library.service.impl.BookService.save(..))", throwing = "ex")
    public void logSavingError(JoinPoint joinPoint, BookException ex) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Error occur: %s.%s%s", className, method, args));
        System.out.println(ex.getMessage());
    }

    @After("execution(public * com.example.book_library.controller.BookController.deleteB(..))")
    public void logDelete(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Delete item: %s.%s%s", className, method, args));
        System.out.println("Delete successfully");
    }

    @After("execution(public * com.example.book_library.service.impl.BookService.save(..))")
    public void logSavingSuccess(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("Save data: %s.%s%s", className, method, args));
        System.out.println("Save successfully");
        List<BorrowCode> borrowCodes = (List<BorrowCode>) borrowCodeService.findAll();
        System.out.println("Total visitor of library: " + borrowCodes.size());
    }
}
