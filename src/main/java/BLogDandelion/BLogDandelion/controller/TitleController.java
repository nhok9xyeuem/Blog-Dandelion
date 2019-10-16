package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Theme;
import BLogDandelion.BLogDandelion.model.Title;
import BLogDandelion.BLogDandelion.service.ThemeService;
import BLogDandelion.BLogDandelion.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class TitleController {

    @Autowired
    TitleService titleService;
    @Autowired
    ThemeService themeService;

    @ModelAttribute("theme")
    public Page<Theme> themes(Pageable pageable) {
        return themeService.findAll(pageable);
    }

    @GetMapping("/")
    public ModelAndView titleDisPlay(@RequestParam(value = "search", defaultValue = "") String search, Pageable pageable) {
        Page<Title> titles;
        if (!search.isEmpty()) {
            titles = titleService.findAllByTitleContaining(search, pageable);
            ModelAndView modelAndView = new ModelAndView("title/disPlay");
            modelAndView.addObject("titles", titles);
            modelAndView.addObject("search", search);
            return modelAndView;
        } else {
            titles = titleService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("title/disPlay");
            modelAndView.addObject("titles", titles);
            return modelAndView;
        }
    }



    @GetMapping("/content/{id}")
    public ModelAndView contentDisPlay(@PathVariable Long id) {
        Optional<Title> title = titleService.findById(id);
        ModelAndView modelAndView = new ModelAndView("content/disPlay");
        modelAndView.addObject("title", title);
        return modelAndView;
    }


    @GetMapping("/create-title")
    public ModelAndView titleFormCreate() {
        ModelAndView modelAndView = new ModelAndView("title/create");
        modelAndView.addObject("titles", new Title());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView titleCreate(@ModelAttribute("titles") Title title, RedirectAttributes redirectAttributes) {
        titleService.save(title);
        ModelAndView modelAndView = new ModelAndView("redirect:/title");
        redirectAttributes.addFlashAttribute("message", "CREATE NEW BLOG");
        return modelAndView;
    }

    @GetMapping("/delete-title/{id}")
    public ModelAndView titleDeleteForm(@PathVariable Long id) {
        Optional<Title> title = titleService.findById(id);
        ModelAndView modelAndView = new ModelAndView("title/delete");
        modelAndView.addObject("title", title.get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView titleDelete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        titleService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/title");
        redirectAttributes.addFlashAttribute("message", "FINISH DELETE BLOG");
        return modelAndView;
    }

    @GetMapping("/edit-title/{id}")
    public ModelAndView titleFormEdit(@PathVariable Long id) {
        Optional<Title> titles = titleService.findById(id);
        ModelAndView modelAndView = new ModelAndView("title/edit");
        modelAndView.addObject("titles", titles.get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView titleUpdate(@ModelAttribute("titles") Title title, RedirectAttributes redirectAttributes) {
        titleService.save(title);
        ModelAndView modelAndView = new ModelAndView("redirect:/title");
        redirectAttributes.addFlashAttribute("message", "FINISH UPDATE  BLOG");
        return modelAndView;
    }


}
