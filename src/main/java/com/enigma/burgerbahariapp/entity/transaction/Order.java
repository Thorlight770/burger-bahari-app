package com.enigma.burgerbahariapp.entity.transaction;

import com.enigma.burgerbahariapp.entity.master.Customer;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trx_order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Boolean status;
    @OneToMany(mappedBy = "order")
    private List<TableDetail> tableDetailList;
}
