package com.marvel.petclinic.bootstrap;

import com.marvel.petclinic.model.Owner;
import com.marvel.petclinic.model.Vet;
import com.marvel.petclinic.service.OwnerService;
import com.marvel.petclinic.service.VetService;
import com.marvel.petclinic.service.map.OwnerServiceMap;
import com.marvel.petclinic.service.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner peter = new Owner();
        peter.setFirstName("Peter");
        peter.setLastName("parker");
        peter.setId(1L);
        ownerService.save(peter);

        Owner stark = new Owner();
        stark.setFirstName("Tony");
        stark.setLastName("Stark");
        stark.setId(2L);
        ownerService.save(stark);

        System.out.println("Loaded owners");

        Vet stephen = new Vet();
        stephen.setFirstName("Stephen");
        stephen.setLastName("Strange");
        stephen.setId(1L);
        vetService.save(stephen);

        Vet thor = new Vet();
        thor.setFirstName("Thor");
        thor.setLastName("Odinson");
        thor.setId(2L);
        vetService.save(thor);

        System.out.println("Loaded Vets");
    }
}
