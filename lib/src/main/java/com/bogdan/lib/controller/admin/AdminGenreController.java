package com.bogdan.lib.controller.admin;

import com.bogdan.lib.entity.Genre;
import com.bogdan.lib.repository.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminGenreController {


    private final GenreRepository genreRepository;

    public AdminGenreController(GenreRepository tagRepository) {
        this.genreRepository = tagRepository;
    }

    //* Create
    @GetMapping("/admin/genre/create")
    public String create(Model model){
        return "admin/genre/create";
    }

    @PostMapping("/admin/genre/create")
    public RedirectView create(
            @RequestParam(value = "name") String name
    ){

        //  System.out.println("name" + name);
        Genre g = new Genre();
        g.setName(name);
        genreRepository.save(g);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/genre/");
        return redirect;
    }


    //* Read
    @GetMapping("/admin/genre")
    public String index(Model model){
        model.addAttribute("genres", genreRepository.findAll());
        return "admin/genre/index";
    }

    //* Update
    @GetMapping("/admin/genre/update/{id}")
    public String update(
            @PathVariable(value = "id") Long id,
            Model model){
        model.addAttribute("genre", genreRepository.findById(id));
        return "admin/genre/update";
    }

    @PostMapping("/admin/genre/update")
    public RedirectView update(
            @RequestParam(value = "id") Long id,
            @RequestParam(value = "name") String name
    ){

        //  System.out.println("name" + name);
        Genre g = genreRepository.findById(id).get();
        g.setName(name);
        genreRepository.save(g);

        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/genre");
        return redirect;
    }


    //* Delete
    @GetMapping("/admin/genre/delete/{id}")
    public RedirectView delete(
            @PathVariable(value = "id") Long id){
        genreRepository.deleteById(id);
        RedirectView redirect= new RedirectView();
        redirect.setUrl("/admin/genre");
        return redirect;
    }



}
