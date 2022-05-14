package com.enigma.burgerbahariapp.specification.master;

import com.enigma.burgerbahariapp.dto.master.AddOnDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomAddOnSpecification {
    public static Specification<AddOn> getSpecification(AddOnDTO addOnDTO){
        return new Specification<AddOn>() {
            List<Predicate> predicates =new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<AddOn> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (addOnDTO.getName() != null){
                    Predicate addOnNamePredicate = criteriaBuilder.like(root.get("name"), "%" +addOnDTO.getName()+ "%");
                    predicates.add(addOnNamePredicate);
                }
                if (addOnDTO.getDescription() != null){
                    Predicate addOnDescriptionPredicate = criteriaBuilder.like(root.get("description"), "%" +addOnDTO.getDescription()+ "%");
                    predicates.add(addOnDescriptionPredicate);
                }
                if (addOnDTO.getPriceCheapest() != null){
                    Predicate addOnPrice;
                    if (addOnDTO.getPriceExpensive() != null){
                        addOnPrice = criteriaBuilder.between(root.get("price"), addOnDTO.getPriceCheapest(), addOnDTO.getPriceExpensive());
                    }else {
                        addOnPrice = criteriaBuilder.equal(root.get("price"), addOnDTO.getPriceCheapest());
                    }
                    predicates.add(addOnPrice);
                }
                Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
