package br.com.lino.lino.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lino.lino.entity.Note;
import java.util.List;


public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAllByTheme_IdTheme(Long idTheme);
    List<Note> findAllByTheme_IdThemeAndNameNoteContainingIgnoreCase(Long idTheme, String search);
}
