package cz.leads.controller;

import cz.leads.model.Lead;
import cz.leads.model.Note;
import cz.leads.model.Reminder;
import cz.leads.service.LeadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {

    private final LeadService leadService;

    public LeadController(LeadService leadService) {
        this.leadService = leadService;
    }

    @PostMapping
    public Lead register(@RequestBody Lead lead) {
        return leadService.register(lead);
    }

    @PostMapping("/{id}/notes")
    public Note addNote(@PathVariable Long id, @RequestBody Note note) {
        return leadService.addNote(id, note);
    }

    @GetMapping("/{id}/notes")
    public List<Note> getNotes(@PathVariable Long id) {
        return leadService.getNotes(id);
    }

    @PostMapping("/{id}/reminders")
    public Reminder addReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        return leadService.addReminder(id, reminder);
    }

    @GetMapping("/{id}/reminders")
    public List<Reminder> getReminders(@PathVariable Long id) {
        return leadService.getReminders(id);
    }
}
