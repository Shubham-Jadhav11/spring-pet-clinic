package com.marvel.petclinic.bootstrap;

import com.marvel.petclinic.model.*;
import com.marvel.petclinic.service.OwnerService;
import com.marvel.petclinic.service.PetTypeService;
import com.marvel.petclinic.service.SpecialityService;
import com.marvel.petclinic.service.VetService;
import com.marvel.petclinic.service.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count == 0)loadData();
    }

    private void loadData() {
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

        Pet snowbell = new Pet();
        snowbell.setName("snowbell");
        snowbell.setPetType(cat);
        snowbell.setBirthDate(LocalDate.now());
        snowbell.setOwner(peter);
        peter.getPet().add(snowbell);
        ownerService.save(peter);

        Visit snowbellVisit = new Visit();
        snowbellVisit.setPet(snowbell);
        snowbellVisit.setDate(LocalDate.now());
        snowbellVisit.setDescription("Snezzy kitti");

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

        Speciality surgeon = new Speciality();
        surgeon.setDescription("surgeon");
        Speciality saveSurgery = specialityService.save(surgeon);

        Speciality radioLogiest = new Speciality();
        surgeon.setDescription("radioLogiest");
        Speciality saveRadiology = specialityService.save(radioLogiest);

        Vet stephen = new Vet();
        stephen.setFirstName("Stephen");
        stephen.setLastName("Strange");
        stephen.getSpecialities().add(saveRadiology);
        vetService.save(stephen);

        Vet thor = new Vet();
        thor.setFirstName("Thor");
        thor.setLastName("Odinson");
        thor.getSpecialities().add(saveSurgery);
        vetService.save(thor);

        System.out.println("Loaded Vets");
    }
}
