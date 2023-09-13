package com.example.BookApp.HomeController;

import com.example.BookApp.Domin.Book;
import com.example.BookApp.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BookService service;
    List<Book> booklist=new ArrayList();


    @GetMapping("/")
    public String getFirst(Model model){
        booklist=service.getFirst();
        model.addAttribute("books",booklist);
       return "firstpage";

    }
    @GetMapping("/showBookForm")
    public String bookForm(Model model){
        model.addAttribute("book",new Book());
        return "addbook";

    }
    @GetMapping("/savebook")
    public String saveBook(Book book){
        booklist.add(book);
        return "redirect:/";
    }
    @GetMapping("/deleteBook/{id}")
    public String checkStock(@PathVariable(value = "id") int bookId) {
       for(int i=0;i<booklist.size();i++)
       {
           Book b1= booklist.get(i);
       if(b1.getBookId()==bookId){
           booklist.remove(b1);
       }
       }
        return "redirect:/";
    }
    @GetMapping("/updateBookForm/{id}")

    public String updateForm(@PathVariable int id, Model model){
        Book b1=booklist.get(id);
        if(b1!=null){
            model.addAttribute("book",b1);
        }

        return "updateBookForm";
    }

    @GetMapping("/updatebook")
    public String updateBook(Book book){
       for(int i=0;i<booklist.size();i++){
        Book b1=booklist.get(i);
        if(b1.getBookId()==book.getBookId()){
        b1.setBookName(book.getBookName());
        b1.setBookPrice(book.getBookPrice());
        b1.setBookCategory(book.getBookCategory());}}

        return "redirect:/";

    }

}
