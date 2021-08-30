package com.bogdan.kurs.controller.admin;

import com.bogdan.kurs.entity.Book;
import com.bogdan.kurs.repository.AuthorRepository;
import com.bogdan.kurs.repository.BookRepository;
import com.bogdan.kurs.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

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
            @RequestParam(value = "genre_ids", required = false) long[] genre_ids,
            @RequestParam(value = "author_ids", required = false) long[] author_ids
    ){
        Book newBook = new Book();
        newBook.setName(name);

        if (author_ids != null)
            newBook.setAuthors(authorRepository.findAllById(author_ids));
        if (genre_ids != null)
            newBook.setGenres(genreRepository.findAllById(genre_ids));


        bookRepository.save(newBook);


        // Проверяю, что пришло
        /*
        System.out.println("Incoming Data:");

        System.out.println("Incoming genres:");
        for (int i = 0; i < genre_ids.length; i++)
            System.out.println(genre_ids[i]);

        System.out.println("Incoming data:");
        for (int i = 0; i < author_ids.length; i++)
            System.out.println(author_ids[i]);
         */

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

        model.addAttribute("bookG",bookRepository.findById(id).get().getGenres() );
        model.addAttribute("bookA",bookRepository.findById(id).get().getAuthors() );

        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());

        return "admin/book/update";
    }

    @PostMapping("/admin/book/update")
    public RedirectView update(
            @RequestParam(value = "id") long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "genre_ids", required = false) long[] genre_ids,
            @RequestParam(value = "author_ids", required = false) long[] author_ids
    ){

        System.out.println("name" + name);
        System.out.println("id" + id);
        Book b = bookRepository.findById(id).get();
        b.setName(name);



        System.out.println("New name" + b.getName());
        System.out.println("Old id" + b.getId());

        if (author_ids != null)
            b.setAuthors(authorRepository.findAllById(author_ids));
        if (genre_ids != null)
            b.setGenres(genreRepository.findAllById(genre_ids));


        bookRepository.save(b);


        // Проверяю, что пришло
        /*
        System.out.println("Incoming Data:");

        System.out.println("Incoming genres:");
        for (int i = 0; i < genre_ids.length; i++)
            System.out.println(genre_ids[i]);

        System.out.println("Incoming data:");
        for (int i = 0; i < author_ids.length; i++)
            System.out.println(author_ids[i]);
         */


        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/book");
        return redirect;
    }


    //* Delete
    @GetMapping("/admin/book/delete/{id}")
    public RedirectView delete(
            @PathVariable(value = "id") long id){
        bookRepository.deleteById(id);
        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/book");
        return redirect;
    }



}
