package com.Chynchenko.service;

import static org.junit.jupiter.api.Assertions.*;

import com.Chynchenko.model.Car;
import com.Chynchenko.model.Engine;
import com.Chynchenko.service.CarArrayRepository;
import com.Chynchenko.util.RandomGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;
    private RandomGenerator randomGenerator;
    private Car car;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        randomGenerator = Mockito.mock(RandomGenerator.class);
        target = new CarService();
        car = new Car();
    }

    @Test
    void createWithRandomCount() {
        Mockito.when(randomGenerator.generate()).thenReturn(3);
        final int expected = 3;
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createWithRandomCountIncorrectNull() {
        final int expected = -1;
        final int actual = target.create(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createWithRandomCountIncorrectZero() {
        final int expected = -1;
        Mockito.when(randomGenerator.generate()).thenReturn(0);
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void createWithRandomCountIncorrectOutOfTheBound() {
        final int expected = -1;
        Mockito.when(randomGenerator.generate()).thenReturn(-5);
        final int actual = target.create(randomGenerator);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void create() {
        final Car car = target.create();
        Assertions.assertNotNull(car);
        Mockito.verify(repository).save(car);
    }

    @Test
    void insert() {
        final int count = 7;
        Assertions.assertDoesNotThrow(() -> target.insert(count, car));
        Mockito.verify(repository).insert(count, car);
    }

    @Test
    void insertIncorrectCount() {
        final int count = -8;
        Assertions.assertDoesNotThrow(() -> target.insert(count, car));
        Mockito.verify(repository).insert(count, car);
    }

    @Test
    void insertIncorrectCarNull() {
        final int count = -8;
        Assertions.assertDoesNotThrow(() -> target.insert(count, null));
        Mockito.verify(repository).insert(count, null);
    }

    @Test
    void printAll() {
        Assertions.assertDoesNotThrow(() -> target.printAll());
        Mockito.verify(repository).getAll();
    }

    @Test
    void getAll() {
        Assertions.assertNull(target.getAll());
        Mockito.verify(repository).getAll();
    }

    @Test
    void find() {
        final Car expected = new Car();
        String id = "1234567890";
        Mockito.when(repository.getById(id)).thenReturn(expected);
        final Car actual = target.find(id);
        Assertions.assertEquals(expected, actual);
        Mockito.verify(repository).getById(id);
    }

    @Test
    void findNotFound() {
        String id = "1234567890";
        Mockito.when(repository.getById(id)).thenReturn(null);
        car = target.find(id);
        Assertions.assertNull(car);
        Mockito.verify(repository).getById(id);
    }

    @Test
    void findIncorrectIdNull() {
        String id = null;
        car = target.find(id);
        Assertions.assertNull(car);
        Mockito.verify(repository, Mockito.never()).getById(null);
    }

    @Test
    void findIncorrectIdEmpty() {
        String id = "";
        car = target.find(id);
        Assertions.assertNull(car);
        Mockito.verify(repository, Mockito.never()).getById("");
    }

    @Test
    void delete() {
        String id = "123456";
        Assertions.assertDoesNotThrow(() -> target.delete(id));
        Mockito.verify(repository).delete(id);
    }

    @Test
    void deleteIncorrectIdNull() {
        String id = null;
        Assertions.assertDoesNotThrow(() -> target.delete(id));
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void deleteIncorrectIdEmpty() {
        String id = "";
        Assertions.assertDoesNotThrow(() -> target.delete(id));
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void changeRandomColor() {
        String id = car.getId();
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
    }

    @Test
    void changeRandomColorIncorrectIdNull() {
        String id = null;
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
        Mockito.verify(repository, Mockito.never()).updateColor(car.getId(), Car.Colors.BLACK);
    }

    @Test
    void changeRandomColorIncorrectIdEmpty() {
        String id = "";
        Assertions.assertDoesNotThrow(() -> target.changeRandomColor(id));
        Mockito.verify(repository, Mockito.never()).updateColor(car.getId(), Car.Colors.BLACK);
    }

    @Test
    void createWithThreeIncorrectParametersNull() {
        car = target.create();
        Assertions.assertNull(car);
        Mockito.verify(repository, Mockito.never()).save(null);
    }

    @Test
    void print() {
        Assertions.assertDoesNotThrow(() -> target.print(car));
    }

    @Test
    void printIncorrectCarNull() {
        Assertions.assertDoesNotThrow(() -> target.print(null));
    }

    @Test
    void check() {
        Assertions.assertDoesNotThrow(() -> CarService.check(car));
    }

    @Test
    void checkIncorrectCarNull() {
        Assertions.assertDoesNotThrow(() -> CarService.check(null));
    }
}