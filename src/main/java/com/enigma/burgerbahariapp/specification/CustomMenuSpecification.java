package com.enigma.burgerbahariapp.specification;

import com.enigma.burgerbahariapp.dto.MenuDTO;
import com.enigma.burgerbahariapp.entity.master.Menu;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomMenuSpecification {
    public static Specification<Menu> getSpecification(MenuDTO menuDTO){
        return new Specification<Menu>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (menuDTO.getIdMenu() != null){
                    Predicate menuIdPredicate = criteriaBuilder.equal(root.get("id"), menuDTO.getIdMenu());
                    predicates.add(menuIdPredicate);
                }
                if (menuDTO.getPriceCheapest() != null){
                    Predicate menuPrice;
                    if (menuDTO.getPriceExpensive() != null){
                        menuPrice = criteriaBuilder.between(root.get("price"), menuDTO.getPriceCheapest(), menuDTO.getPriceExpensive());
                    }else {
                        menuPrice = criteriaBuilder.equal(root.get("price"), menuDTO.getPriceCheapest());
                    }
                    predicates.add(menuPrice);
                }
                if (menuDTO.getDescription() != null){
                    Predicate menuDescription = criteriaBuilder.like(root.get("description"), "%" + menuDTO.getDescription() + "%");
                    predicates.add(menuDescription);
                }
                Predicate[] arrayPredicates = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicates);
            }
        };
    }
}
