package com.kondrat.TheSchooWebsite.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PupilRepositoryTest {
    @Autowired
    PupilRepository pupilRepository;

    @Test
    public void makeStringsPupils(){
        assertEquals(4, pupilRepository.findAll().size());
        pupilRepository.makeStringsPupils("Мария");
        assertEquals(5, pupilRepository.findAll().size());
        pupilRepository.makeStringsPupils("Константин");
        assertEquals(5, pupilRepository.findAll().size());

    }
}
