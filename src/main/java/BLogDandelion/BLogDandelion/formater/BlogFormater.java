//package BLogDandelion.BLogDandelion.formater;
//
//import BLogDandelion.BLogDandelion.model.ThemeBlog;
//import BLogDandelion.BLogDandelion.service.ThemeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//
//import java.text.ParseException;
//import java.util.Locale;
//import java.util.Optional;
//
//public class BlogFormater implements Formatter<Optional<ThemeBlog>> {
//
//    private ThemeService themeService;
//
//    @Autowired
//    public BlogFormater(ThemeService themeService) {
//        this.themeService = themeService;
//    }
//
//    @Override
//    public Optional<ThemeBlog> parse(String text, Locale locale) throws ParseException {
//        return themeService.findById(Long.parseLong(text));
//    }
//
//    @Override
//    public String print(Optional<ThemeBlog> object, Locale locale) {
//        return "[" + object.get().getId() + ", " +object.get().getTheme() + "]";
//    }
//}
