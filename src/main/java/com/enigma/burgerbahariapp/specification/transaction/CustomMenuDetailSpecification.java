package com.enigma.burgerbahariapp.specification.transaction;

import com.enigma.burgerbahariapp.dto.transaction.MenuDetailDTO;
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
                if (menuDetailDTO.getMenu().getId() != null){
                    Join<MenuDetail, Menu> join = root.join("menu", JoinType.INNER);
                    join.on(criteriaBuilder.equal(join.get("id"), menuDetailDTO.getMenu().getId()));
                    Predicate idMenuDetail = join.getOn();
                    predicates.add(idMenuDetail);
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
