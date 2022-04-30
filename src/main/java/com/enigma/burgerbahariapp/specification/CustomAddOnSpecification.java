package com.enigma.burgerbahariapp.specification;

import com.enigma.burgerbahariapp.dto.AddOnDTO;
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
                if (addOnDTO.getDescription() != null){
                    Predicate addOnDescriptionPredicate = criteriaBuilder.equal(root.get("description"), "%" +addOnDTO.getDescription()+ "%");
                    predicates.add(addOnDescriptionPredicate);
                }
                if (addOnDTO.getPriceCheapest() != null){
                    if (addOnDTO.getPriceExpensive() != null){
                        Predicate addOnPriceBetween = criteriaBuilder.between(root.get("price"), addOnDTO.getPriceCheapest(), addOnDTO.getPriceExpensive());
                        predicates.add(addOnPriceBetween);
                    }else {
                        Predicate addOnPriceCheapest = criteriaBuilder.equal(root.get("price"), addOnDTO.getPriceCheapest());
                        predicates.add(addOnPriceCheapest);
                    }
                }
                Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
