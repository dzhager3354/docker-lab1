package ru.dzhager3354.back;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world");
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoDto>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/todo")
    public ResponseEntity<TodoDto> getById(@PathParam("id") int id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping("/todo")
    public ResponseEntity<TodoDto> create(@RequestBody TodoDto dto) {
        System.out.println(dto);
	return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/todo")
    public ResponseEntity<Void> delete(@PathParam("id") int id) {
        service.delete(id);
        return ResponseEntity.ok(null);
    }
}
