package com.enigma.burgerbahariapp.entity.transaction;

import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.entity.master.Menu;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "trx_menu_detail")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class MenuDetail {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "add_on_id")
    private AddOn addOn;
    private Integer quantity;
    private Double priceDetail;
}
