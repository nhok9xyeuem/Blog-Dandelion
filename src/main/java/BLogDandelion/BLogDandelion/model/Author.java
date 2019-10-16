package BLogDandelion.BLogDandelion.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;

    @OneToMany(mappedBy = "author")
    private List<Title> titleAuthor;

    public Author() {
    }

    public Author(String author, List<Title> titleAuthor) {
        this.author = author;
        this.titleAuthor = titleAuthor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Title> getTitleAuthor() {
        return titleAuthor;
    }

    public void setTitleAuthor(List<Title> titleAuthor) {
        this.titleAuthor = titleAuthor;
    }
}
