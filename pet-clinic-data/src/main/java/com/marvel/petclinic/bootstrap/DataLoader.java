package com.marvel.petclinic.bootstrap;

import com.marvel.petclinic.model.Owner;
import com.marvel.petclinic.model.Pet;
import com.marvel.petclinic.model.PetType;
import com.marvel.petclinic.model.Vet;
import com.marvel.petclinic.service.OwnerService;
import com.marvel.petclinic.service.PetTypeService;
import com.marvel.petclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        System.out.println("Added pet type");

        Owner peter = new Owner();
        peter.setFirstName("Peter");
        peter.setLastName("Parker");
        peter.setCity("NY");
        peter.setAddress("20 Ingram St. in Queens");
        peter.setTelephone("147536982");

        Pet mani = new Pet();
        mani.setName("Mani");
        mani.setPetType(cat);
        mani.setBirthDate(LocalDate.now());
        mani.setOwner(peter);
        peter.getPet().add(mani);
        ownerService.save(peter);


        Owner stark = new Owner();
        stark.setFirstName("Tony");
        stark.setLastName("Stark");
        stark.setAddress("10880 Malibu Point, 90265");
        stark.setCity("Malibu");
        stark.setTelephone("7895201463");

        Pet jarvis = new Pet();
        jarvis.setName("Jarvis");
        jarvis.setPetType(dog);
        jarvis.setBirthDate(LocalDate.now());
        jarvis.setOwner(stark);
        stark.getPet().add(jarvis);
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
