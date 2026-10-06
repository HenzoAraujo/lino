package br.com.lino.lino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.lino.lino.entity.Theme;
import br.com.lino.lino.service.ThemeService;

@Controller 
public class ThemeController {
    
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService){
        this.themeService = themeService;
    };

    @PostMapping("/tema")
    public String createTheme(@ModelAttribute Theme theme) {
        themeService.createTheme(theme);
        return "redirect:/home";
    }

    @PostMapping("/tema/{idTheme}/excluir") 
    public String deleteTheme(@PathVariable Long idTheme) {
        themeService.deleteTheme(idTheme);
        return "redirect:/home";
    }
}
