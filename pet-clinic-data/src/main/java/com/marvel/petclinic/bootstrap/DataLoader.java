package com.marvel.petclinic.bootstrap;

import com.marvel.petclinic.model.Owner;
import com.marvel.petclinic.model.Vet;
import com.marvel.petclinic.service.OwnerService;
import com.marvel.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
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
