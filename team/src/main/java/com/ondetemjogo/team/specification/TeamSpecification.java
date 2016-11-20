package com.ondetemjogo.team.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.ondetemjogo.team.model.Team;

public class TeamSpecification {

	private TeamSpecification() {
		
	}
	
	public static Specification<Team> findTeams(String search) {
		return new Specification<Team>() {

			@Override
			public Predicate toPredicate(Root<Team> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (StringUtils.isBlank(search)) {
					return null;
				}
				
				String searchLike = String.format("%%%s%%", search.toLowerCase());
				Path<String> paramName = root.get("name");
				return cb.like(cb.lower(paramName), searchLike);
			}
			
		};
	}

}
