package br.com.lino.lino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.lino.lino.entity.Note;
import br.com.lino.lino.entity.Theme;
import br.com.lino.lino.repository.NoteRepository;
import br.com.lino.lino.repository.ThemeRepository;

@Service
public class NoteService {

    private final NoteRepository noteRepository;
    private final ThemeRepository themeRepository;


    public NoteService(NoteRepository noteRepository, ThemeRepository themeRepository) {
        this.noteRepository = noteRepository;
        this.themeRepository = themeRepository;
    }

    public Note createNote(Note note, Long idTheme){
        Theme theme = themeRepository.findById(idTheme).get(); // .get | .orElse (só pra me lembrar)
        note.setTheme(theme);
        return noteRepository.save(note);
    }

    public List<Note> listNote(Long idTheme, String search){
        if (search == null) {
            return noteRepository.findAllByTheme_IdTheme(idTheme);
        }
        return noteRepository.findAllByTheme_IdThemeAndNameNoteContainingIgnoreCase(idTheme, search);
    }

    public Note loadNote(Long idNote){
        return noteRepository.findById(idNote).orElse(null);
    }

    public void deleteNote(Long idNote){
        noteRepository.deleteById(idNote);
    }

}
