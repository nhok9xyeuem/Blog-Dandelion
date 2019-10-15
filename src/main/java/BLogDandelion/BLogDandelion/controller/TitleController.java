package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Theme;
import BLogDandelion.BLogDandelion.model.Title;
import BLogDandelion.BLogDandelion.service.ThemeService;
import BLogDandelion.BLogDandelion.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TitleController {

    @Autowired
    TitleService titleService;
    @Autowired
    ThemeService themeService;
    @ModelAttribute("theme")
    public Page<Theme> themes(Pageable pageable){
        return themeService.findAll(pageable);
    }

    @GetMapping("/title")
    public ModelAndView titleDisPlay(Pageable pageable){
        Page<Title> titles = titleService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("title/disPlay");
        modelAndView.addObject("titles",titles);
        return modelAndView;
    }
    @GetMapping("/create-title")
    public ModelAndView titleFormCreate(){
        ModelAndView modelAndView = new ModelAndView("title/create");
        modelAndView.addObject("titles",new Title());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView titleCreate(@ModelAttribute ("titles") Title title , RedirectAttributes redirectAttributes){
            titleService.save(title);
            ModelAndView modelAndView = new ModelAndView("redirect:/title");
            redirectAttributes.addFlashAttribute("message","CREATE NEW BLOG");
            return modelAndView;
    }


}
