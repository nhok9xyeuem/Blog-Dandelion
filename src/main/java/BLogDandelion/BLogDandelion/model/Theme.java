package BLogDandelion.BLogDandelion.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theme;
    @OneToMany(mappedBy = "theme")
    private Set<Title> titles;

    public Theme() {
    }

    public Theme(String theme, Set<Title> titles) {
        this.theme = theme;
        this.titles = titles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Set<Title> getTitles() {
        return titles;
    }

    public void setTitles(Set<Title> titles) {
        this.titles = titles;
    }
}
