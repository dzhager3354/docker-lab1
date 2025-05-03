package ru.dzhager3354.back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public TodoDto findById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<TodoDto> findAll() {
        return repository.findAll();
    }

    public TodoDto create(TodoDto dto) {
        return repository.save(dto);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
