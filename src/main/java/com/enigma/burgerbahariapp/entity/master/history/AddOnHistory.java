package com.enigma.burgerbahariapp.entity.master.history;

import com.enigma.burgerbahariapp.entity.master.AddOn;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "mst_add_on_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class AddOnHistory {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @ManyToOne
    @JoinColumn(name = "add_on_id")
    private AddOn addOn;
    private LocalDate date;
}
