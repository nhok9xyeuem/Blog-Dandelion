package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Theme;
import BLogDandelion.BLogDandelion.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
