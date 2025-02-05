package com.br.ifba.task.repositorytest;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import com.br.ifba.task.infraestructure.entity.Task;
import com.br.ifba.task.infraestructure.repository.TaskRepository;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;



@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class TaskRepositoryTest {
    @Autowired
    private TaskRepository taskRepository;

    @Test
    void testSaveAndFindById(){
        // criando uma nova task
        Task task = new Task();
        task.setDescription("Estudar test junit");
        // salvando
        Task savedTask = taskRepository.save(task);
        //
        Optional<Task> foundTask = taskRepository.findById(savedTask.getId());
         // Verificando se foi salvo corretamente
         assertThat(foundTask).isPresent();
         assertThat(foundTask.get().getDescription()).isEqualTo("Estudar test junit");
    }

    @Test
    void testExistsTaskByDescription() {
        // Criando e salvando uma task
        Task task = new Task();
        task.setDescription("Aprender JUnit");
        taskRepository.save(task);

        // Verificando se existe uma task com essa descrição
        boolean exists = taskRepository.existsTaskByDescription("Aprender JUnit");

        // O método deve retornar true
        assertThat(exists).isTrue();
    }
    @Test
    void testDeleteTask() {
        // Criando e salvando uma task
        Task task = new Task();
        task.setDescription("Fazer exercícios");
        Task savedTask = taskRepository.save(task);

        // Deletando
        taskRepository.deleteById(savedTask.getId());

        // Verificando se foi deletado corretamente
        Optional<Task> deletedTask = taskRepository.findById(savedTask.getId());
        assertThat(deletedTask).isEmpty();
    }


}
