package br.com.lino.lino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lino.lino.entity.Theme;
import java.util.List;


public interface ThemeRepository extends JpaRepository<Theme, Long> {
    List<Theme> findByNameThemeContainingIgnoreCase(String search);
}
