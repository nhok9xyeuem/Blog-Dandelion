package BLogDandelion.BLogDandelion.model;


import javax.persistence.*;


@Entity
@Table(name = "listTittle")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
//    @ManyToOne
//    @JoinColumn(name = "themelist_id")
//    private ThemeBlog themeBlog;

    public Blog() {
    }

//    public ThemeBlog getThemeBlog() {
//        return themeBlog;
//    }
//
//    public void setThemeBlog(ThemeBlog themeBlog) {
//        this.themeBlog = themeBlog;
//    }

    public Blog(String title, String content ) {
        this.title = title;
        this.content = content;
//        this.themeBlog=themeBlog;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
