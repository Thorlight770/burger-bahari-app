package com.enigma.burgerbahariapp.entity.transaction;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "trx_order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "table_detail_id")
    private TableDetail tableDetail;
    @ManyToOne
    @JoinColumn(name = "menu_detail_id")
    private MenuDetail menuDetail;
    private Double subtotal;

}
