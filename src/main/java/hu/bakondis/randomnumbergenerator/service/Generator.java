package hu.bakondis.randomnumbergenerator.service;

import org.springframework.stereotype.Service;

@Service
public class Generator {


    public int getRandom(Long min, Long max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }

}
