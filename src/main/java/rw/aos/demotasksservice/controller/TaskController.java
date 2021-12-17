package rw.aos.demotasksservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.aos.demotasksservice.domain.Task;
import rw.aos.demotasksservice.service.TaskService;

import java.util.Set;

@RestController
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("create")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task createNewTask(Task task){
        return taskService.createNewTask(task);
    }

    @GetMapping("get/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public Set<Task> getAllTask(){
        return taskService.getAllTasks();
    }
}
