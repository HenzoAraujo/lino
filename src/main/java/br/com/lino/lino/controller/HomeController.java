package br.com.lino.lino.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String home(Model model, @RequestParam(required = false) String search) {
        List<Theme> theme = themeService.listTheme(search);
        model.addAttribute("themes", theme);
        return "index.html";
    }

}
