//package BLogDandelion.BLogDandelion.model;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "themeList")
//public class ThemeBlog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//    private String theme;
//    @OneToMany(mappedBy = "themeList")
//    private Set<Blog> blogs;
//
//
//    public ThemeBlog() {
//    }
//
//    public ThemeBlog(String theme, Set<Blog> blogs) {
//        this.theme = theme;
//        this.blogs = blogs;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTheme() {
//        return theme;
//    }
//
//    public void setTheme(String theme) {
//        this.theme = theme;
//    }
//
//    public Set<Blog> getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(Set<Blog> blogs) {
//        this.blogs = blogs;
//    }
//}
