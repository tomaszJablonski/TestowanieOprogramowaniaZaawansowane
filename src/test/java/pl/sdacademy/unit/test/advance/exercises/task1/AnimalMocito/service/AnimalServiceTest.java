package pl.sdacademy.unit.test.advance.exercises.task1.AnimalMocito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.sdacademy.unit.test.advance.exercises.task2.dto.AnimalDto2;
import pl.sdacademy.unit.test.advance.exercises.task2.model.Animal;
import pl.sdacademy.unit.test.advance.exercises.task2.repository.AnimalRepository;
import pl.sdacademy.unit.test.advance.exercises.task2.service.AnimalService;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
class AnimalServiceTest {

    private static final Animal ANIMAL = new Animal(1l, "mammal", "dog");
    private static final AnimalDto2 ANIMAL_DTO_2 = new AnimalDto2(1l, "mammal", "dog",true);

    @Mock
    private AnimalRepository animalRepository;

    @InjectMocks
    private AnimalService animalService;

    @Test
    void shouldAddNewAnimal() {
        //given
        Mockito.when(animalRepository.add(any())).thenReturn(ANIMAL);
        //when
        AnimalDto2 result = animalService.add("mammal", "dog");
        //then
        assertEquals(ANIMAL_DTO_2, result);
    }

    @Test
    void shouldReturnAnimalById() {
        //give
        Mockito.when(animalRepository.findById(anyLong())).thenReturn(Optional.of(ANIMAL));
        //when
        Animal result = animalService.getById(1L);
        //then
        assertEquals(ANIMAL, result); // junit
        assertThat(result).isEqualTo(ANIMAL);
    }

    @Test
    void shouldThrowExceptionWhenUserNotExist(){
        //given
        Mockito.when(animalRepository.findById(anyLong())).thenReturn(Optional.empty());
        //when & then
        //junit
        assertThrows(IllegalArgumentException.class,
                ()-> animalService.getById(1L));
        //assertj
        assertThatThrownBy(()->animalService.getById(1L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("animal not exist with id:1");
    }


}