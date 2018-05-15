package com.kondrat.TheSchooWebsite.repository;

import com.kondrat.TheSchooWebsite.domain.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface PupilRepository extends JpaRepository<Pupil, Integer> {

    default List<Pupil> createIfNotExists(String name) {
        boolean pupilPresent = false;
        Pupil newPupil = new Pupil(name, (int) (Math.random() * 1000000));
        if(!pupilPresent(newPupil)){
            save(newPupil);
        }
        return findAll();
    }
    default boolean pupilPresent(Pupil newPupil){
        if(newPupil==null){
            return false;
        }
        return existsByName(newPupil.getName());
//        if(newPupil==null){
//            return false;
//        }else {
//            for(Pupil pupil : findAll()){
//                if(pupil.getName().equals(newPupil.getName())){
//                    return true;
//                }
//            }
//        }
//        return false;
    }
    //заменить логику в методах в проекте wcic на вызов методов спринговских


    List<Pupil> findByName(String name);

    int countByName(String name);

    boolean existsByName(String name);

    boolean existsByNameAndId(String name, int id);

    boolean existsByNameOrId(String name, int id);

    boolean existsByNameLike(String name);
}
