package rw.aos.demotasksservice.service;

import org.springframework.stereotype.Service;
import rw.aos.demotasksservice.domain.Task;
import rw.aos.demotasksservice.repository.TaskRespository;

import java.util.HashSet;
import java.util.Set;

@Service
public class TaskService {
    private final TaskRespository taskRespository;

    public TaskService(TaskRespository taskRespository) {
        this.taskRespository = taskRespository;
    }

    public Task createNewTask(Task task){
        return taskRespository.save(task);
    }

    public Set<Task> getAllTasks(){
        return new HashSet<>(taskRespository
                .findAll());
    }

    public Task getTaskById(Long taskId){
        return taskRespository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task Not Found"));
    }
}
