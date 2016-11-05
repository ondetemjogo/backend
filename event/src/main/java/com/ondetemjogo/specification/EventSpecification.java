package com.ondetemjogo.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.ondetemjogo.model.Event;

public class EventSpecification {

	private EventSpecification() {
		
	}
	
	public static Specification<Event> findEvents(Date date, String search) {
		return new Specification<Event>() {

			@Override
			public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<Date> paramDate = root.get("date");
				Predicate andPredicate = cb.greaterThanOrEqualTo(paramDate, date);
				
				List<Predicate> predicates = new ArrayList<>();
				if (StringUtils.isNotBlank(search)) {
					String searchLike = String.format("%%%s%%", search.toLowerCase());
					Path<String> paramEstablishmentName = root.get("establishment").get("name");
					predicates.add(cb.like(cb.lower(paramEstablishmentName), searchLike));
					
					Path<String> paramEstablishmentAddress = root.get("establishment").get("address");
					predicates.add(cb.like(cb.lower(paramEstablishmentAddress), searchLike));
					
					Path<String> paramHouseTeamName = root.get("houseTeam").get("name");
					predicates.add(cb.like(cb.lower(paramHouseTeamName), searchLike));
					
					Path<String> paramVisitTeamName = root.get("visitTeam").get("name");
					predicates.add(cb.like(cb.lower(paramVisitTeamName), searchLike));
				}
				
				Predicate orPredicates = cb.or(predicates.toArray(new Predicate[predicates.size()]));
				
				if (predicates.isEmpty()) {
					return cb.and(andPredicate);
				} else {
					return cb.and(andPredicate, orPredicates);
				}
			}
			
		};
	}

}
