package com.bogdan.kurs.controller;

import com.bogdan.kurs.repository.AuthorRepository;
import com.bogdan.kurs.repository.BookRepository;
import com.bogdan.kurs.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/lib")
    public String index(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "lib";
    }
}
