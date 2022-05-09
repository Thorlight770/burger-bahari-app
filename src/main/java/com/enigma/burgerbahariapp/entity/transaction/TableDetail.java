package com.enigma.burgerbahariapp.entity.transaction;

import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "trx_table_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TableDetail {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "dining_table_id")
    private DiningTable diningTable;
    private LocalDateTime date;
    @OneToMany(mappedBy = "tableDetail", fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetailList;
}
