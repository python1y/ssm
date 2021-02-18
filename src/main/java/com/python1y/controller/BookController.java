package com.python1y.controller;

import com.python1y.pojo.Books;
import com.python1y.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }


    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(int id,Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("qbook",book);
        System.out.println(book);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books book){
        bookService.updateBook(book);
        System.out.println("update"+book);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/book/allBook";
    }

}
