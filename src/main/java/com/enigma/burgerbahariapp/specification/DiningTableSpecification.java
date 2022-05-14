package com.enigma.burgerbahariapp.specification;

import com.enigma.burgerbahariapp.dto.DiningTableSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DiningTableSpecification {
    public static Specification<DiningTable> getSpecification(DiningTableSearchDTO diningTableSearchDTO) {
        return new Specification<DiningTable>() {
            @Override
            public Predicate toPredicate(Root<DiningTable> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (diningTableSearchDTO.getNumber()!=null) {
                    Predicate diningTableNumberPredicate = criteriaBuilder.equal(root.get("number"),
                            diningTableSearchDTO.getNumber());
                    predicates.add(diningTableNumberPredicate);
                }

                if (diningTableSearchDTO.getStatus()!=null) {
                    Predicate diningTableStatusPredicate = criteriaBuilder.equal(root.get("status"),
                            diningTableSearchDTO.getStatus());
                    predicates.add(diningTableStatusPredicate);
                }

                Predicate[] arrayPredicate = predicates.toArray(new Predicate[0]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
