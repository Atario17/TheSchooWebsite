package com.kondrat.TheSchooWebsite.repository;

import com.kondrat.TheSchooWebsite.controllers.SchoolController;
import com.kondrat.TheSchooWebsite.domain.Pupil;
import org.junit.Before;
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
    @Autowired
    SchoolController schoolController;
    @Before
    public void setUp() throws Exception{
        pupilRepository.deleteAll();
        pupilRepository.flush();
        schoolController.fullListOfPupils();

    }

    @Test
    public void makeStringsPupils(){
        assertEquals(4, pupilRepository.findAll().size());
        pupilRepository.createIfNotExists("Мария");
        assertEquals(5, pupilRepository.findAll().size());
        pupilRepository.createIfNotExists("Константин");
        assertEquals(5, pupilRepository.findAll().size());

    }
    @Test
    public void pupilPresentTest(){
        assertEquals(false, pupilRepository.pupilPresent(null));
        assertEquals(true, pupilRepository.pupilPresent(new Pupil("Константин",1)));
        assertEquals(false, pupilRepository.pupilPresent(new Pupil("Марина",1)));
        //assertEquals(true, pupilRepository.pupilPresent(new Pupil("Дмитрий",1)));
        assertEquals(true, pupilRepository.pupilPresent(new Pupil("София",1)));
    }


    @Test
    public void queryByMethodName() throws Exception {
        assertEquals(0, pupilRepository.findByName("Марина").size());
        assertEquals(1, pupilRepository.findByName("Константин").size());

        assertEquals(0, pupilRepository.countByName("Марина"));
        assertEquals(1, pupilRepository.countByName("Константин"));

        assertEquals(false, pupilRepository.existsByName("Марина"));
        assertEquals(true, pupilRepository.existsByName("Константин"));

        assertEquals(false, pupilRepository.existsByNameAndId("Константин", 152));
        assertEquals(true, pupilRepository.existsByNameAndId("Константин", 1));

        assertEquals(true, pupilRepository.existsByNameOrId("Константин", 152));
        assertEquals(true, pupilRepository.existsByNameLike("%онстанти%"));

    }
}
