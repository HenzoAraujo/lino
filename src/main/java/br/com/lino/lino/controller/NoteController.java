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
import br.com.lino.lino.service.ThemeService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller 
public class NoteController {
    
    private final NoteService noteService;
    private final ThemeService themeService;

    public NoteController(NoteService noteService, ThemeService themeService){
        this.noteService = noteService;
        this.themeService = themeService;
    }

    @GetMapping("/tema/{idTheme}")
    public String themeNote(@PathVariable Long idTheme, Model model, @RequestParam(required = false) String search) {
        Theme theme = themeService.loadTheme(idTheme);  
        List<Note> note = noteService.listNote(idTheme, search);
        model.addAttribute("idTheme", idTheme);
        model.addAttribute("theme", theme);
        model.addAttribute("notes", note);
        return "notes.html";
    }

    @PostMapping("/tema/{idTheme}/nota")
    public String createNote(@PathVariable Long idTheme, @ModelAttribute Note note) {
        noteService.createNote(note, idTheme);
        return "redirect:/tema/{idTheme}";
    }

    @PostMapping("/tema/{idTheme}/nota/{idNote}/excluir")
    public String deleteNote(@PathVariable Long idNote) {
        noteService.deleteNote(idNote);
        return "redirect:/tema/{idTheme}";
    }

    @GetMapping("/tema/{idTheme}/nota/{idNote}")
    public String noteID(@PathVariable Long idTheme, @PathVariable Long idNote, Model model) {
        Note note = noteService.loadNote(idNote);
        model.addAttribute("note", note);
        return "noteID.html";
    }
    

}
