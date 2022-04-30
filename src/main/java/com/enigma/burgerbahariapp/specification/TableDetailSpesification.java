package com.enigma.burgerbahariapp.specification;

import com.enigma.burgerbahariapp.dto.TableDetailSearchDTO;
import com.enigma.burgerbahariapp.entity.master.DiningTable;
import com.enigma.burgerbahariapp.entity.transaction.TableDetail;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class TableDetailSpesification {
    public static Specification<TableDetail> getSpecification(TableDetailSearchDTO tableDetailSearchDTO) {
        return new Specification<TableDetail>() {
            @Override
            public Predicate toPredicate(Root<TableDetail> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if
        }
    }
}
