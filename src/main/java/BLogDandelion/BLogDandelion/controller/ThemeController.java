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

import java.util.List;
import java.util.Optional;

@Controller
public class ThemeController {
    @Autowired
    TitleService titleService;
    @Autowired
    private ThemeService themeService;
    @ModelAttribute("title")
    public Page<Title> titles (Pageable pageable) {
        return titleService.findAll(pageable);
    }

    @GetMapping("/theme")
    public ModelAndView themeDisPlay(@RequestParam (value = "search",defaultValue = "") String search, Pageable pageable){
        if (!search.isEmpty()){
            Page<Theme> theme=themeService.findAllByThemeContaining(search,pageable);
            ModelAndView modelAndView = new ModelAndView("theme/disPlay");
            modelAndView.addObject("themes", theme);
            modelAndView.addObject("search", search);
            return modelAndView;
        }else {
            Page<Theme> theme = themeService.findAll(pageable);
            ModelAndView modelAndView = new ModelAndView("theme/disPlay");
            modelAndView.addObject("themes", theme);
            return modelAndView;
        }
    }
    @GetMapping("/delete-theme/{id}")
    public ModelAndView themeDeleteForm(@PathVariable Long id ){
        Optional<Theme> theme = themeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("theme/delete");
        modelAndView.addObject("themes",theme.get());
        return modelAndView;
    }
    //waive - từ bỏ ::::
    @PostMapping("/waive/{id}")
    public  ModelAndView themeDelete(@RequestParam Long id ,RedirectAttributes redirectAttributes){
        themeService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/theme");
        redirectAttributes.addFlashAttribute("message", "DELETE THEME FINISH");
        return modelAndView;
    }
    @GetMapping("/create-theme")
    public ModelAndView themeCreateForm(){
    ModelAndView modelAndView = new ModelAndView("theme/create");
    modelAndView.addObject("themes", new Theme());
    return modelAndView;
    }
    @PostMapping("/create-newTheme")
    public ModelAndView themeCreate(@ModelAttribute("themes") Theme theme,RedirectAttributes redirectAttributes){
        themeService.save(theme);
        ModelAndView modelAndView = new ModelAndView("redirect:/theme");
        redirectAttributes.addFlashAttribute("message", "CREATE NEW THEME BLOG");
        return modelAndView;
    }
    @GetMapping("/edit-theme/{id}")
    public ModelAndView themeEditForm(@PathVariable Long id ){
        Optional<Theme> theme = themeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("theme/edit");
        modelAndView.addObject("themes",theme.get());
        return modelAndView;
    }
    @PostMapping("/change")
    public ModelAndView themeChange(@ModelAttribute ("themes") Theme theme , RedirectAttributes redirectAttributes){
        themeService.save(theme);
        ModelAndView modelAndView = new ModelAndView("redirect:/theme");
        redirectAttributes.addFlashAttribute("message", "CHANGE NEW THEME BLOG");
        return modelAndView;
    }
    @GetMapping("theme-title/{id}")
    public ModelAndView listTitleByTheme(@PathVariable Long id ){
        Optional<Theme> theme = themeService.findById(id);
        List<Title> listTitle = theme.get().getTitles();
        ModelAndView modelAndView = new ModelAndView("theme/listTitle");
        modelAndView.addObject("listTitle",listTitle);
        modelAndView.addObject("themes",theme);
        return modelAndView;
    }

}
