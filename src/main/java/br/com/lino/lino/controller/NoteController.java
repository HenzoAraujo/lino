package br.com.lino.lino.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.lino.lino.entity.Note;
import br.com.lino.lino.entity.Theme;
import br.com.lino.lino.service.NoteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class NoteController {
    
    private final NoteService noteService;

    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }

    @GetMapping("/tema/{idTheme}")
    public String themeNote(@PathVariable Long idTheme, Model model, @RequestParam(required = false) String search) {
        List<Note> note = noteService.listNote(idTheme, search);
        model.addAttribute("idTheme", idTheme);
        model.addAttribute("notes", note);
        return "notes.html";
    }

    @PostMapping("/tema/{idTheme}/nota")
    public String createNote(@PathVariable Long idTheme, @ModelAttribute Note note) {
        noteService.createNote(note, idTheme);
        return "redirect:/tema/{idTheme}";
    }

}
