package rw.aos.demotasksservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rw.aos.demotasksservice.domain.Task;

public interface TaskRespository extends JpaRepository<Task, Long> {
}
