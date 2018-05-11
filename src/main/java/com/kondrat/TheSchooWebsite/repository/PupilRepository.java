package com.kondrat.TheSchooWebsite.repository;

import com.kondrat.TheSchooWebsite.domain.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface PupilRepository extends JpaRepository<Pupil, Integer> {

    default List<Pupil>  makeStringsPupils(String name) {
        List<Pupil> pupils = new ArrayList<>();
        boolean pupilPresent = false;
        Pupil pupil = new Pupil(name, (int) (Math.random() * 1000000));
        for (Pupil pupil1 : findAll()) {
            if (findAll().size() == 0) {
                break;
            }
            if(pupil1.getName().equals(name)){
                pupilPresent = true;
                pupil = pupil1;
                break;
            }
        }if(!pupilPresent){
            save(pupil);
        }pupils.add(pupil);
        return pupils;
    }

}
