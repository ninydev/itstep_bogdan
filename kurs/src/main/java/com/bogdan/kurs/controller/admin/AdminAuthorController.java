package com.bogdan.kurs.controller.admin;

import com.bogdan.kurs.entity.Author;
import com.bogdan.kurs.entity.Genre;
import com.bogdan.kurs.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminAuthorController {


    private final AuthorRepository authorRepository;

    public AdminAuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //* Create
    @GetMapping("/admin/author/create")
    public String create(Model model){
        return "admin/author/create";
    }

    @PostMapping("/admin/author/create")
    public RedirectView create(
            @RequestParam(value = "name") String name
    ){
        Author a = new Author();
        a.setName(name);
        authorRepository.save(a);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/author/");
        return redirect;
    }


    //* Read
    @GetMapping("/admin/author")
    public String index(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "admin/author/index";
    }

    //* Update
    @GetMapping("/admin/author/update/{id}")
    public String update(
            @PathVariable(value = "id") Long id,
            Model model){
        model.addAttribute("author", authorRepository.findById(id));
        return "admin/author/update";
    }

    @PostMapping("/admin/author/update")
    public RedirectView update(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name
    ){

        //  System.out.println("name" + name);
        Author a = authorRepository.findById(id).get();
        a.setName(name);
        authorRepository.save(a);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/author");
        return redirect;
    }


    //* Delete
    @GetMapping("/admin/author/delete/{id}")
    public RedirectView delete(
            @PathVariable(value = "id") Long id){
        authorRepository.deleteById(id);
        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/author");
        return redirect;
    }



}
