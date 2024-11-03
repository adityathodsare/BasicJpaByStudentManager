package com.studentmanagerDCB.studentManagementSystem.repository;


import com.studentmanagerDCB.studentManagementSystem.entity.student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface studentRepository extends JpaRepository< student,Long > {

    public List<student> findByFirstName(String firstName);


    public List<student> findByFirstNameContaining(String name);

    public List<student> findByLastNameNotNull();

    public List<student> findByGuardianGuardianName(String GuardianGuardianName);

    public List<student> findByGuardianGuardianNameContaining(String name);
//
//     List<student> findByID(Integer ID);
    @Query("select s from student s where studentID = ?1 ")
    public student getStudentByID(Integer studentID);

//    // getting name of the student using id

    @Query("select s.Email from student s  where s.studentID =?1 ")
    public String getEmailByID (Integer studentID);



    // use of native query
    @Query(
            value = "select s.guardian_name from tbl_student s where s.studentid = ?1 ",
            nativeQuery = true
    )
    public String getGuardianNameByID(Integer studentId);


    // use of named param
    @Query(
            value = "select s.guardian_name from tbl_student s where s.studentid = : ID ",
            nativeQuery = true
    )
    public String getGuardianNameByIDByNamedParam(@Param("ID") Integer studentId);


    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set student_email_address = ?1 where  studentid = ?2 ",
            nativeQuery = true
    )
    public int UpdateEmailById ( String Email , Integer studentId);



}
