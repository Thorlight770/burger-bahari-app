package com.enigma.burgerbahariapp.specification.master;

import com.enigma.burgerbahariapp.dto.master.CustomerSearchDTO;
import com.enigma.burgerbahariapp.entity.master.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CustomerSpecification {
    public static Specification<Customer> getSpecification(CustomerSearchDTO customerSearchDTO) {
        return new Specification<Customer>() {
            List<Predicate> predicates =new ArrayList<>();
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                if (customerSearchDTO.getName()!=null) {
                    Predicate customerNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),
                            "%" + customerSearchDTO.getName().toLowerCase(Locale.ROOT)+"%");
                    predicates.add(customerNamePredicate);
                }

                if (customerSearchDTO.getEmail()!=null) {
                    Predicate customerEmailPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("email")),
                            "%" + customerSearchDTO.getEmail().toLowerCase(Locale.ROOT)+"%");
                    predicates.add(customerEmailPredicate);
                }

                if (customerSearchDTO.getPhoneNumber()!=null) {
                    Predicate customerPhoneNumberPredicate = criteriaBuilder.like(root.get("phoneNumber"),
                            "%" + customerSearchDTO.getPhoneNumber()+"%");
                    predicates.add(customerPhoneNumberPredicate);
                }

                if (customerSearchDTO.getAddress()!=null) {
                    Predicate customerAddressPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("address")),
                            "%" + customerSearchDTO.getAddress().toLowerCase(Locale.ROOT)+"%");
                    predicates.add(customerAddressPredicate);
                }

                if (customerSearchDTO.getIsDeleted()!=null) {
                    Predicate customerIsDeletedPredicate = criteriaBuilder.equal(root.get("isDeleted"),
                            customerSearchDTO.getIsDeleted());
                    predicates.add(customerIsDeletedPredicate);
                }

                Predicate[] arrayPredicate =predicates.toArray(new Predicate[0]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
