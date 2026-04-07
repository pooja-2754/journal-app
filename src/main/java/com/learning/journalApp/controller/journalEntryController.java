package com.learning.journalApp.controller;

import com.learning.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/journal")
public class journalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public String createEntry(@RequestBody JournalEntry entry) {
        journalEntries.put(entry.getId(), entry);
        return "Entry added";
    }

    @GetMapping("/id/{id}")
    public JournalEntry getById(@PathVariable Long id) {
        return journalEntries.get(id);
    }

    @DeleteMapping("/id/{id}")
    public String delete(@PathVariable Long id) {
        journalEntries.remove(id);
        return "Deleted";
    }

    @PutMapping("/id/{id}")
    public String update(@PathVariable Long id, @RequestBody JournalEntry entry) {
        journalEntries.put(id, entry);
        return "Updated";
    }
}