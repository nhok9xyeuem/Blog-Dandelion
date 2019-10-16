package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Author;
import BLogDandelion.BLogDandelion.model.Title;
import BLogDandelion.BLogDandelion.service.AuthorService;
import BLogDandelion.BLogDandelion.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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
    public  ModelAndView authorDisPlay(@RequestParam(value = "search",defaultValue = "") String search, Pageable pageable){
        if (search.isEmpty()){
        Page<Author> author = authorService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("author/disPlay");
        modelAndView.addObject("authors", author);
        return modelAndView;
    }else {
            Page<Author> author = authorService.findAllByAuthorContaining(search,pageable);
            ModelAndView modelAndView = new ModelAndView("author/disPlay");
            modelAndView.addObject("authors", author);
            modelAndView.addObject("search", search);
            return modelAndView;
        }
    }
    @GetMapping("/create-author")
    public ModelAndView authorCreateForm(){
        ModelAndView modelAndView = new ModelAndView("author/create");
        modelAndView.addObject("authors", new Author());
        return modelAndView;
    }
    @PostMapping("/create-author")
    public ModelAndView authorCreate(@ModelAttribute("authors") Author author , RedirectAttributes redirectAttributes){
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("redirect:/author");
        redirectAttributes.addFlashAttribute("message", "CREATE NEW AUTHOR ");
        return modelAndView;
    }

    @GetMapping("/delete-author/{id}")
    public ModelAndView authorDeleteForm(@PathVariable Long id ){
        Optional<Author> author = authorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("author/delete");
        modelAndView.addObject("authors",author.get());
        return modelAndView;
    }

    @PostMapping("/delete-author/{id}")
    public  ModelAndView authorDelete(@RequestParam Long id ,RedirectAttributes redirectAttributes){
        authorService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/author");
        redirectAttributes.addFlashAttribute("message", "DELETE AUTHOR FINISH");
        return modelAndView;
    }
    @GetMapping("/edit-author/{id}")
    public ModelAndView authorEditForm(@PathVariable Long id ){
        Optional<Author> author = authorService.findById(id);
        ModelAndView modelAndView = new ModelAndView("author/edit");
        modelAndView.addObject("authors",author.get());
        return modelAndView;
    }
    @PostMapping("/edit-author")
    public ModelAndView themeChange(@ModelAttribute ("authors") Author author , RedirectAttributes redirectAttributes){
        authorService.save(author);
        ModelAndView modelAndView = new ModelAndView("redirect:/author");
        redirectAttributes.addFlashAttribute("message", "CHANGE NEW AUTHOR ");
        return modelAndView;
    }

    @GetMapping("author-title/{id}")
    public ModelAndView listTitleByTheme(@PathVariable Long id ){
        Optional<Author> author = authorService.findById(id);
        List<Title> listTitleByAuthor = author.get().getTitleAuthor();
        ModelAndView modelAndView = new ModelAndView("author/listTitle");
        modelAndView.addObject("listTitleByAuthor",listTitleByAuthor);
        modelAndView.addObject("authors",author);
        return modelAndView;
    }
}
