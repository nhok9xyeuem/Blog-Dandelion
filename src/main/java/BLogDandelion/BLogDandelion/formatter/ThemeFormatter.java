package BLogDandelion.BLogDandelion.formatter;

import BLogDandelion.BLogDandelion.model.Theme;
import BLogDandelion.BLogDandelion.service.ThemeService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class ThemeFormatter implements Formatter<Optional<Theme>> {

    private ThemeService themeService;

    public ThemeFormatter(ThemeService themeService) {
        this.themeService=themeService;
    }

    @Override
    public Optional<Theme> parse(String text, Locale locale) throws ParseException {
        return themeService.findById(Long.parseLong(text));
    }
    @Override
    public String print(Optional<Theme> object, Locale locale) {
        return object.get().toString();
    }
}
