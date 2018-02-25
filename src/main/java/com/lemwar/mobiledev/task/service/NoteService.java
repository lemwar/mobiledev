package com.lemwar.mobiledev.task.service;

import com.lemwar.mobiledev.task.Note;
import com.lemwar.mobiledev.task.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {

    private List<Note> notes;

    public NoteService() {
        this.notes = new ArrayList<>();
    }

    public List<Note> getAll() {
        return notes;
    }

    public List<Note> add(Note note) {
        Date date = new Date();
        // Set UUID
        if (note.getId() == null || note.getId().isEmpty()) {
            note.setId(Utils.generateID());
        }
        // Set create_time
        if (note.getDate_create() == 0) {
            note.setDate_create(date.getTime());
        }
        // Set update_time
        if (note.getDate_update() == 0) {
            note.setDate_update(note.getDate_create());
        } else {
            note.setDate_update(date.getTime());
        }
        //insert element
        notes.add(note);
        return notes;
    }

    public List<Note> change(Note note) {
        Date date = new Date();
        note.setDate_update(date.getTime());
        // change element
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(note.getId())) {
                note.setDate_create(notes.get(i).getDate_create());
                notes.set(i, note);
                return notes;
            }
        }
        // insert element if it's not found
        note.setDate_create(date.getTime());
        note.setDate_update(date.getTime());
        notes.add(note);
        return notes;
    }

    public List<Note> delete(String id) {
        // delete element
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getId().equals(id)) {
                notes.remove(i);
                return notes;
            }
        }

        return notes;
    }
}
