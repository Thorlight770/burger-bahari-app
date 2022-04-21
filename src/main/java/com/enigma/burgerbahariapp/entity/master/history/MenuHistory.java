package com.enigma.burgerbahariapp.entity.master.history;

import com.enigma.burgerbahariapp.entity.master.Menu;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mst_menu_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class MenuHistory {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
    private LocalDate date;
}
