package br.com.lino.lino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lino.lino.entity.Theme;
import br.com.lino.lino.repository.ThemeRepository;

@Service 
public class ThemeService {
    
    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository){
        this.themeRepository = themeRepository;
    }

    public Theme createTheme(Theme theme){
        return themeRepository.save(theme);
    }

    public void deleteTheme(Theme theme){
        themeRepository.delete(theme);
    }

    public List<Theme> listTheme(){
        return themeRepository.findAll();
    }

    public void loadTheme(Long idTheme){
        themeRepository.findById(idTheme);
    }

}
