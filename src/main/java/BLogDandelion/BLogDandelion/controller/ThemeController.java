package BLogDandelion.BLogDandelion.controller;

import BLogDandelion.BLogDandelion.model.Blog;
import BLogDandelion.BLogDandelion.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ThemeController {
    @Autowired
    private BlogService blogService;
    @GetMapping("/title")
    public ModelAndView disPlay(Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("listTitle/disPlay");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }
    @GetMapping("/content/{id}")
    public  ModelAndView disPlayContent( @PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("content/disPlay");
        modelAndView.addObject("blog",blog.get());
        return modelAndView;
    }
    @GetMapping("/create-blog")
    public ModelAndView createForm(){
    ModelAndView modelAndView = new ModelAndView("create/create");
    modelAndView.addObject("blog",new Blog());
    return modelAndView;
    }
    @PostMapping("/create")
    public  ModelAndView createBlog(RedirectAttributes redirectAttributes, Blog blog){
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/title");
        redirectAttributes.addFlashAttribute("message","Finish Create New Blog");
        return modelAndView;

    }
}
