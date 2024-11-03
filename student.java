package com.studentmanagerDCB.studentManagementSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data// getter setter ToString methods will be generated
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_Student")
public class student {

    @Id
    @SequenceGenerator(
            name = "Student_Sequence",
            sequenceName = "Student_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Student_Sequence"
    )
    @Column(nullable = false,unique = true)
    private Long studentID;
    @Column(name = "studentFirstName",nullable = false)
    private String firstName;
    @Column(name = "studentLastName")
    private String lastName;
    @Column(name = "studentEmailAddress",nullable = false,unique = true)
    private String Email;

    @OneToOne
    private Laptop laptop;



//    // should be in saperate class
//    @Column(name="guardianName")
//    private  String guardianName;
//    @Column(name="guardianEmailAddress",nullable = false,unique = true)
//    private String guardianEmail;
//    @Column(name="guardianMobNumber",nullable = false,unique = true)
//    private String guardianMobNumber;


    @Embedded
    private Guardian guardian;


}
