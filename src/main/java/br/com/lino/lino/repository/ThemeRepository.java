package br.com.lino.lino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lino.lino.entity.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
