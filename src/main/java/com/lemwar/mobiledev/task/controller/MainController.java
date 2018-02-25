package com.lemwar.mobiledev.task.controller;

import com.lemwar.mobiledev.task.Note;
import com.lemwar.mobiledev.task.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.HEAD})
    public @ResponseBody
    Collection<Note> getAllNotes() {
        return noteService.getAll();
    }

    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.HEAD})
    public ResponseEntity<ModelMap> saveNote(@RequestBody Note note) {
        ModelMap resp = new ModelMap();
        ResponseEntity<ModelMap> response;
        try {
            resp.put("notes", noteService.add(note));
            resp.put("status", "ok");
            response = ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp.put("status", "error");
            resp.put("error", e.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
        return response;
    }


    @RequestMapping(value = "/", method = {RequestMethod.PUT, RequestMethod.HEAD})
    public ResponseEntity<ModelMap> changeNote(@RequestBody Note note) {
        ModelMap resp = new ModelMap();
        ResponseEntity<ModelMap> response;
        try {
            resp.put("notes", noteService.change(note));
            resp.put("status", "ok");
            response = ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp.put("status", "error");
            resp.put("error", e.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
        return response;
    }

    @RequestMapping(value = "/", method = {RequestMethod.DELETE, RequestMethod.HEAD})
    public ResponseEntity<ModelMap> deleteNote(@RequestBody Note note) {
        ModelMap resp = new ModelMap();
        ResponseEntity<ModelMap> response;
        try {
            resp.put("notes", noteService.delete(note.getId()));
            resp.put("status", "ok");
            response = ResponseEntity.ok(resp);
        } catch (Exception e) {
            resp.put("status", "error");
            resp.put("error", e.getMessage());
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
        return response;
    }

    @RequestMapping(value = "/healthcheck", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<ModelMap> healthCheck() {
        ModelMap resp = new ModelMap();
        ResponseEntity<ModelMap> response;
        resp.put("status", "ok");
        resp.put("name", "mobiledev task");
        resp.put("time", LocalDateTime.now());
        resp.put("OS", System.getProperty("os.name"));
        response = ResponseEntity.ok(resp);
        return response;
    }
}
