package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Author;
import BLogDandelion.BLogDandelion.model.Title;
import BLogDandelion.BLogDandelion.service.AuthorService;
import BLogDandelion.BLogDandelion.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {
    @Autowired
    TitleService titleService;
    @Autowired
    private AuthorService authorService;
    @ModelAttribute("title")
    public Page<Title> titles (Pageable pageable) {
        return titleService.findAll(pageable);
    }

    @GetMapping("/author")
    public  ModelAndView authorDisPlay(Pageable pageable){
        Page<Author> author = authorService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("author/disPlay");
        modelAndView.addObject("authors", author);
        return modelAndView;
    }
}
