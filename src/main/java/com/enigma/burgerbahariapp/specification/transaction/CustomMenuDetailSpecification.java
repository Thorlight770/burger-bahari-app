package com.enigma.burgerbahariapp.specification.transaction;

import com.enigma.burgerbahariapp.dto.transaction.MenuDetailDTO;
import com.enigma.burgerbahariapp.entity.master.AddOn;
import com.enigma.burgerbahariapp.entity.master.Menu;
import com.enigma.burgerbahariapp.entity.transaction.MenuDetail;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class CustomMenuDetailSpecification {
    public static Specification<MenuDetail> getMenuDetailSpecification(MenuDetailDTO menuDetailDTO){
        return new Specification<MenuDetail>() {
            List<Predicate> predicates = new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<MenuDetail> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (menuDetailDTO.getMenu().getName() != null){
                    Join<MenuDetail, Menu> join = root.join("menu", JoinType.INNER);
                    join.on(criteriaBuilder.like(join.get("name"), "%"+menuDetailDTO.getMenu().getName()));
                    Predicate nameMenuMenuDetail = join.getOn();
                    predicates.add(nameMenuMenuDetail);
                }
                if (menuDetailDTO.getAddOn().getName() != null){
                    Join<MenuDetail, AddOn> join = root.join("addOn", JoinType.INNER);
                    join.on(criteriaBuilder.like(join.get("name"), "%"+menuDetailDTO.getAddOn().getName()));
                    Predicate nameAddOnMenuDetail = join.getOn();
                    predicates.add(nameAddOnMenuDetail);
                }
                if (menuDetailDTO.getQuantity() != null){
                    Predicate qtyDetail = criteriaBuilder.greaterThanOrEqualTo(root.get("quantity"), menuDetailDTO.getQuantity());
                    predicates.add(qtyDetail);
                }
                if (menuDetailDTO.getPriceDetail() != null){
                    Predicate priceDetail = criteriaBuilder.greaterThanOrEqualTo(root.get("priceDetail"), menuDetailDTO.getPriceDetail());
                    predicates.add(priceDetail);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
