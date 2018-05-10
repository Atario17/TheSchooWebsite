package com.kondrat.TheSchooWebsite;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

class MyModel implements Model {
    Object obj;

    @Override
    public Model addAttribute(String s, Object o) {
        if(s.equals("list")){
            obj = o;
        }
        return this;
    }

    @Override
    public Model addAttribute(Object o) {
        return null;
    }

    @Override
    public Model addAllAttributes(Collection<?> collection) {
        return null;
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public Model mergeAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public boolean containsAttribute(String s) {
        return false;
    }

    @Override
    public Map<String, Object> asMap() {
        return null;
    }
}

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolControllerTest {

    @Test
    public void showListOfPupilsTest(){

    }

}
