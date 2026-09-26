package br.com.lino.lino.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.lino.lino.entity.Theme;
import br.com.lino.lino.service.ThemeService;
import org.springframework.ui.Model;

@Controller
public class HomeController {

    private final ThemeService themeService;

    public HomeController(ThemeService themeService){
        this.themeService = themeService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Theme> theme = themeService.listTheme();
        model.addAttribute("themes", theme);
        return "home.html";
    }

}
