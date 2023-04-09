package com.company.gamestore.repository;
import com.company.gamestore.model.Shirt;
import org.junit.Before;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class ShirtRepositoryTest {

    @Mock
    private ShirtRepository shirtRepo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        shirtRepo.deleteAll();
    }

    @Test
    public void shouldReturnAllShirts() {
        Shirt Shirt  = new Shirt();
        Shirt.setSize("Large");
        Shirt.setColor("Red");
        Shirt.setPrice(10.00);
        Shirt.setShirtQuantity(10);
        shirtRepo.save(Shirt);

        Shirt Shirt2  = new Shirt();
        Shirt2.setSize("Medium");
        Shirt2.setColor("Blue");
        Shirt2.setPrice(10.00);
        Shirt2.setShirtQuantity(10);
        shirtRepo.save(Shirt2);

        System.out.println(shirtRepo.findAll());
    }

    @Test
    public void shouldReturnShirtById() {
        Shirt Shirt  = new Shirt();
        Shirt.setSize("Large");
        Shirt.setColor("Red");
        Shirt.setPrice(10.00);
        Shirt.setShirtQuantity(10);
        shirtRepo.save(Shirt);

        Shirt Shirt2  = new Shirt();
        Shirt2.setSize("Medium");
        Shirt2.setColor("Blue");
        Shirt2.setPrice(10.00);
        Shirt2.setShirtQuantity(10);
        shirtRepo.save(Shirt2);

        System.out.println(shirtRepo.findById(Shirt.getShirtId()));
    }

    @Test
    public void shouldReturnShirtByColor() {
        Shirt Shirt  = new Shirt();
        Shirt.setSize("Large");
        Shirt.setColor("Red");
        Shirt.setPrice(10.00);
        Shirt.setShirtQuantity(10);
        shirtRepo.save(Shirt);

        Shirt Shirt2  = new Shirt();
        Shirt2.setSize("Medium");
        Shirt2.setColor("Blue");
        Shirt2.setPrice(10.00);
        Shirt2.setShirtQuantity(10);
        shirtRepo.save(Shirt2);

        System.out.println(shirtRepo.findByColor("Red"));
    }

    @Test
    public void shouldReturnShirtBySize() {
        Shirt Shirt  = new Shirt();
        Shirt.setSize("Large");
        Shirt.setColor("Red");
        Shirt.setPrice(10.00);
        Shirt.setShirtQuantity(10);
        shirtRepo.save(Shirt);

        Shirt Shirt2  = new Shirt();
        Shirt2.setSize("Medium");
        Shirt2.setColor("Blue");
        Shirt2.setPrice(10.00);
        Shirt2.setShirtQuantity(10);
        shirtRepo.save(Shirt2);

        System.out.println(shirtRepo.findBySize("Large"));
    }
}