package com.example.BookApp.Service;

import com.example.BookApp.Domin.Book;
import com.example.BookApp.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> getFirst(){
       return repository.findAll();
    }
    public void saveBook(Book book){
      repository.save(book);

    }

}
