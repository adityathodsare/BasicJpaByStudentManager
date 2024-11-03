package com.studentmanagerDCB.studentManagementSystem.repository;

import com.studentmanagerDCB.studentManagementSystem.entity.Guardian;
import com.studentmanagerDCB.studentManagementSystem.entity.student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@DataJpaTest
@SpringBootTest
class studentRepositoryTest {

    @Autowired
    private studentRepository studentRepository;

//    @Test
//    public void saveStudent(){
//
//        student student1 = student.builder()
//                .firstName("aditya")
//                .lastName("thodsare")
//                .Email("aditya@gmail.com")
//                //.guardianName("amol_thodsare")
//                //.guardianEmail("amol@gmail.com")
//                //.guardianMobNumber("9658741203")
//                .build();
//
//        studentRepository.save(student1);
//
//    }



    @Test
    public void viewAllStudent(){

        List<student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void  studentWithGuardian(){

        Guardian guardian1 = Guardian.builder()
                .guardianName("om")
                .guardianEmail("om@gmail.com")
                .guardianMobNumber("8690741203")
                .build();

        student student2 = student.builder()
                .firstName("sham")
                .lastName("sodhi")
                .Email("sham@gmail.com")
                .guardian(guardian1)
                .build();

        studentRepository.save(student2);
    }

    @Test
    public void getStudentByFirstName(){
        List<student> studentsList = studentRepository.findByFirstName("shree");
        System.out.println(studentsList);
    }

    @Test
    public void getStudentByFirstNamePart(){
        List<student> studentsList = studentRepository.findByFirstNameContaining("a");
        System.out.println(studentsList);
    }

    @Test
    public void getStudentByLastNameNotNull(){
        List<student> studentsList = studentRepository.findByLastNameNotNull();
        System.out.println(studentsList);

    }

    @Test
    public void getStudentByGuardianName(){
        List<student> studentsList = studentRepository.findByGuardianGuardianName("amol_thodsare");
        System.out.println(studentsList);

    }

    @Test
    public void getStudentByGuardianNameByPart(){
        List<student> studentsList = studentRepository.findByGuardianGuardianNameContaining("suvarna");
        System.out.println(studentsList);

    }

    @Test
    public void getStudentByID(){
        student studentList = studentRepository.getStudentByID(1);
        System.out.println(studentList);
    }

    @Test
    public void getEmailById(){
        String email = studentRepository.getEmailByID(1);
        System.out.println(email);
    }


    // by native Query
    @Test
    public void getGuardianNameByID(){
        String GuardianName = studentRepository.getGuardianNameByID(1);
        System.out.println(GuardianName);
    }


    //By Named Param
    @Test
    public void getGuardianNameByIDByNamedParam(){
        String GuardianName = studentRepository.getGuardianNameByIDByNamedParam(3);
        System.out.println(GuardianName);
    }

    // updating using repository layer method
    @Test
    public void update_email(){
        studentRepository.UpdateEmailById("adityathodsare@gmail.com",1);
    }
}