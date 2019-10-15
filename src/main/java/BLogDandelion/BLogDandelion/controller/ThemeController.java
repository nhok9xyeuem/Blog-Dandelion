package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Theme;
import BLogDandelion.BLogDandelion.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping("/theme")
    public ModelAndView themeDisPlay(Pageable pageable){
        Page<Theme> theme = themeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("theme/disPlay");
        modelAndView.addObject("themes", theme);
        return modelAndView;
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

}
