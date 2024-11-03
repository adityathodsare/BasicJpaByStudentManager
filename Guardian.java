package com.studentmanagerDCB.studentManagementSystem.entity;


import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "guardianName", column = @Column(name = "guardian_name", nullable = false)),
        @AttributeOverride(name = "guardianEmail", column = @Column(name = "guardian_email_address", nullable = false, unique = true)),
        @AttributeOverride(name = "guardianMobNumber", column = @Column(name = "guardian_mob_number", nullable = false, unique = true))
})
public class Guardian {

    private  String guardianName;
    private String guardianEmail;
    private String guardianMobNumber;

}
