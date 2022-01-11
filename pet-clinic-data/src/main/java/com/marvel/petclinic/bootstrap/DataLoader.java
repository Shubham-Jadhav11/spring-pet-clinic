package com.marvel.petclinic.bootstrap;

import com.marvel.petclinic.model.Owner;
import com.marvel.petclinic.model.PetType;
import com.marvel.petclinic.model.Vet;
import com.marvel.petclinic.service.OwnerService;
import com.marvel.petclinic.service.PetTypeService;
import com.marvel.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {
        // Adding some pets
        PetType dog = new PetType();
        dog.setName("Scooby");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Tom");
        petTypeService.save(cat);

        System.out.println("Added pet type");

        Owner peter = new Owner();
        peter.setFirstName("Peter");
        peter.setLastName("Parker");
        ownerService.save(peter);

        Owner stark = new Owner();
        stark.setFirstName("Tony");
        stark.setLastName("Stark");
        ownerService.save(stark);

        System.out.println("Loaded owners");

        Vet stephen = new Vet();
        stephen.setFirstName("Stephen");
        stephen.setLastName("Strange");
        vetService.save(stephen);

        Vet thor = new Vet();
        thor.setFirstName("Thor");
        thor.setLastName("Odinson");
        vetService.save(thor);

        System.out.println("Loaded Vets");
    }
}
