//package BLogDandelion.BLogDandelion.controller;
//
//import BLogDandelion.BLogDandelion.model.Blog;
//import BLogDandelion.BLogDandelion.model.ThemeBlog;
//import BLogDandelion.BLogDandelion.service.BlogService;
//import BLogDandelion.BLogDandelion.service.ThemeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.Optional;
//
//@Controller
//public class ThemeController {
//    @Autowired
//    private BlogService blogService;
//    @Autowired
//    private ThemeService themeService;
//
//
//    @ModelAttribute("listTittle")
//    public Page<Blog> blogs(Pageable pageable) {
//        return blogService.findAll(pageable);
//    }
//
//    @GetMapping("/theme")
//    public ModelAndView disPlay(Pageable pageable){
//        Page<ThemeBlog> themeBlogs = themeService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("theme/disPlay");
//        modelAndView.addObject("themeBlogs",themeBlogs);
//        return modelAndView;
//    }
//    @GetMapping("/create-theme")
//    public ModelAndView createForm(){
//        ModelAndView modelAndView = new ModelAndView("theme/create");
//        modelAndView.addObject("themeBlog",new ThemeBlog());
//        return modelAndView;
//    }
//    @PostMapping("/create")
//    public  ModelAndView createTheme(ThemeBlog themeBlog ,RedirectAttributes redirectAttributes){
//        themeService.save(themeBlog);
//        ModelAndView modelAndView = new ModelAndView("redirect:/theme");
//        redirectAttributes.addFlashAttribute("message","Finish Create New Theme Blog");
//        return modelAndView;
//    }
//    @GetMapping("/delete-theme/{id}")
//    public ModelAndView deleteForm(@PathVariable Long id){
//        Optional<ThemeBlog> themeBlog = themeService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("theme/delete");
//        modelAndView.addObject("theme", themeBlog.get());
//        return modelAndView;
//    }
//    @PostMapping("/delete/{id}")
//    public ModelAndView deleteThemeBlog(@PathVariable Long id,RedirectAttributes redirectAttributes){
//        themeService.remove(id);
//        ModelAndView modelAndView= new ModelAndView("redirect:/theme");
//        redirectAttributes.addFlashAttribute("message", " FINISH DELETE THEME");
//        return modelAndView;
//    }
//    @GetMapping("/edit-theme/{id}")
//    public ModelAndView editForm(@PathVariable Long id){
//        Optional<ThemeBlog> themeBlog = themeService.findById(id);
//        ModelAndView modelAndView = new ModelAndView("theme/edit");
//        modelAndView.addObject("themes",themeBlog.get());
//        return modelAndView;
//    }
//    @PostMapping("/edit/{id}")
//    public  ModelAndView editBlog(@ModelAttribute("themeBlog") ThemeBlog themeBlog,RedirectAttributes redirectAttributes){
//        themeService.save(themeBlog);
//        ModelAndView modelAndView = new ModelAndView("redirect:/theme");
//        redirectAttributes.addFlashAttribute("message", "FINISH UPDATE THEME BLOG");
//        return modelAndView;
//    }
//}
