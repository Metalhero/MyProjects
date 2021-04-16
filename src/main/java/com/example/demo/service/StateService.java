package com.example.demo.service;

import com.example.demo.domain.State;
import com.example.demo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    StateRepository stateRepository;

    @Autowired
    public void setStateRepository(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> getStates() {
    return stateRepository.findAll();
    }

    public void save(State state) {
        stateRepository.save(state);
    }

    public State findById(Long id) {
        return stateRepository.findById(id).get();
    }

    public void delete(Long id) {
        stateRepository.deleteById(id);
    }
}