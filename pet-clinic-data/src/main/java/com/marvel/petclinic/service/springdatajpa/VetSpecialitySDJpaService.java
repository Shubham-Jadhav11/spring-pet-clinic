package com.marvel.petclinic.service.springdatajpa;

import com.marvel.petclinic.model.Speciality;
import com.marvel.petclinic.repository.SpecialityRepository;
import com.marvel.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpecialitySDJpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public VetSpecialitySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().iterator().forEachRemaining(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }
}
