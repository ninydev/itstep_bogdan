package com.bogdan.kurs.controller.admin;

import com.bogdan.kurs.entity.Author;
import com.bogdan.kurs.entity.Book;
import com.bogdan.kurs.entity.Genre;
import com.bogdan.kurs.repository.AuthorRepository;
import com.bogdan.kurs.repository.BookRepository;
import com.bogdan.kurs.repository.GenreRepository;
import com.sun.xml.bind.v2.runtime.reflect.Lister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class AdminBookController {
    @Autowired
    private  AuthorRepository authorRepository;
    @Autowired
    private  GenreRepository genreRepository;
    @Autowired
    private  BookRepository bookRepository;

    /*
    public AdminBookController(
            AuthorRepository authorRepository,
            GenreRepository genreRepository,
            BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.bookRepository = bookRepository;
    }
*/
    //* Create
    @GetMapping("/admin/book/create")
    public String create(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "admin/book/create";
    }

    @PostMapping("/admin/book/create")
    public RedirectView create(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "genre_ids") int[] genre_ids,
            @RequestParam(value = "author_ids") int[] author_ids
    ){
        Book newBook = new Book();
        newBook.setName(name);

        bookRepository.save(newBook);

        for (int i = 0; i < genre_ids.length; i++)
            System.out.write(genre_ids[i]);

        for (int i = 0; i < author_ids.length; i++)
            System.out.write(author_ids[i]);


        // newBook.setAuthors(authorRepository.findAllById(author_ids));
        // newBook.setGenres(genreRepository.findAllById(genre_ids));


        // Author a = new Author();
        // a.setName(name);
        // authorRepository.save(a);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/book/");
        return redirect;
    }


    //* Read
    @GetMapping("/admin/book")
    public String index(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "admin/book/index";
    }

    //* Update
    @GetMapping("/admin/book/update/{id}")
    public String update(
            @PathVariable(value = "id") Long id,
            Model model){
        model.addAttribute("book", bookRepository.findById(id));
        return "admin/book/update";
    }

    @PostMapping("/admin/book/update")
    public RedirectView update(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name
    ){

        //  System.out.println("name" + name);
        Author a = authorRepository.findById(id).get();
        a.setName(name);
        authorRepository.save(a);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/book");
        return redirect;
    }


    //* Delete
    @GetMapping("/admin/book/delete/{id}")
    public RedirectView delete(
            @PathVariable(value = "id") Long id){
        bookRepository.deleteById(id);
        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/book");
        return redirect;
    }



}
