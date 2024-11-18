package com.usermodule.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "roleCode", unique = true, nullable = false, length = 2)
    private String roleCode;

    @Column(name = "roleName", unique = true, nullable = false, length = 50)
    private String roleName;

    /** The role description. */
    @Column(name = "roleDescription", nullable = false, length = 200)
    private String roleDescription;

}