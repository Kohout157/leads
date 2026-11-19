package cz.leads.service;

import cz.leads.model.Lead;
import cz.leads.model.Note;
import cz.leads.model.Reminder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeadService {

    private final Map<Long, Lead> leads = new HashMap<>();
    private final Map<Long, List<Note>> notes = new HashMap<>();
    private final Map<Long, List<Reminder>> reminders = new HashMap<>();
    private long nextId = 1;

    public synchronized Lead register(Lead lead) {
        for (Lead existing : leads.values()) {
            if (existing.getEmail().equalsIgnoreCase(lead.getEmail())) {
                return existing;
            }
        }

        Lead newLead = new Lead(nextId++, lead.getName(), lead.getEmail());
        leads.put(newLead.getId(), newLead);
        notes.put(newLead.getId(), new ArrayList<>());
        reminders.put(newLead.getId(), new ArrayList<>());
        return newLead;
    }

    public synchronized Note addNote(Long leadId, Note note) {
        notes.get(leadId).add(note);
        return note;
    }

    public synchronized List<Note> getNotes(Long leadId) {
        return notes.get(leadId);
    }

    public synchronized Reminder addReminder(Long leadId, Reminder reminder) {
        reminders.get(leadId).add(reminder);
        return reminder;
    }

    public synchronized List<Reminder> getReminders(Long leadId) {
        return reminders.get(leadId);
    }
}
