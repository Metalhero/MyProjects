package io.portfolio.application.service;

import io.portfolio.application.domain.Country;
import io.portfolio.application.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public void setCountryRepository(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    //Return list of countries
    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    //save new contry
    public void save(Country country) {
        countryRepository.save(country);
    }

    //get by id
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    //delete by id
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}