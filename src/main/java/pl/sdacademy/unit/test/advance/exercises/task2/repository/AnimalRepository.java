package pl.sdacademy.unit.test.advance.exercises.task2.repository;

import org.springframework.stereotype.Repository;
import pl.sdacademy.unit.test.advance.exercises.task2.dto.AnimalDto;
import pl.sdacademy.unit.test.advance.exercises.task2.model.Animal;

import java.util.Optional;

@Repository
public interface AnimalRepository{

    Optional<Animal> findById(long id);
    Animal add(AnimalDto animalDto);
}
