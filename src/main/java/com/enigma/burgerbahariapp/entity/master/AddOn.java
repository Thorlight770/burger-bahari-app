package com.enigma.burgerbahariapp.entity.master;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mst_add_on")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddOn {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String name;
    private Double price;
    private String description;
    private Boolean isDeleted = false;
}
