package com.kiran.app.controller.unittest;

import com.kiran.app.controller.HosController;
import com.kiran.app.model.Hospital;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest {
    @InjectMocks
    private HosController hosController =new HosController();

    @Test
    public void test_createStudent(){
        Hospital hospital =new Hospital("stud1", "123",12);
        Hospital result= hosController.createStudent(hospital);
        assertEquals(hospital.getHname(),result.getHname());
        assertEquals(hospital.getAddress(),result.getAddress());
        assertEquals(hospital.getId(),result.getId());
    }

    @Test
    public void test_readeStudent(){
        Hospital hospital =new Hospital("stud1", "123",12);
        hosController.createStudent(hospital);
        Hospital result= hosController.readeStudent("stud1");
        assertEquals("stud1",result.getHname());
        assertEquals("123",result.getAddress());
//        assertEquals("std7",result.getStd());
        assertEquals(12,result.getId());
    }

    @Test
    public void test_updateStudent(){
        Hospital hospital =new Hospital("stud1", "123",12);
        hosController.createStudent(hospital);
        Hospital result= hosController.updateStudent("stud1",13);
        assertEquals("stud1",result.getHname());
        assertEquals("123",result.getAddress());
        assertEquals(13,result.getId());

    }

    @Test
    public void test_deleteStudent(){
        Hospital hospital =new Hospital();
        hospital.setId(12);
        hospital.setHname("stud1");
        hospital.setAddress("123");
        hosController.createStudent(hospital);
        hosController.deleteStudent("stud1");
        Hospital result= hosController.readeStudent("stud1");
        assertNull(result);
    }
}
