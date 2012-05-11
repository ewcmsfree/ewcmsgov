/*
 * Copyright (c)2010 Jiangxi Institute of Computing Technology(JICT), All rights reserved.
 * JICT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.jict.org
 */
package com.ewcms.content.document.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ewcms.common.dao.JpaDAO;
import com.ewcms.content.document.model.Citizen;
import com.ewcms.plugin.onlineoffice.model.Matter;

/**
 *
 * @author 吴智俊
 */
@Repository()
public class CitizenDAO extends JpaDAO<Integer, Citizen> {
	@SuppressWarnings("unchecked")
	public Citizen findCitizenByCitizenName(String citizenName){
    	String hql = "FROM Citizen AS c WHERE c.name=:citizenName";
    	TypedQuery<Citizen> query = this.getEntityManager().createQuery(hql, Citizen.class);
    	query.setParameter("citizenName", citizenName);
    	return query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public Citizen findCitizenByCitizenIdAndCitizenName(Integer citizenId, String citizenName){
    	String hql = "FROM Citizen AS c WHERE c.id!=:citizenId And c.name=:citizenName";
    	TypedQuery<Citizen> query = this.getEntityManager().createQuery(hql, Citizen.class);
    	query.setParameter("citizenId", citizenId);
    	query.setParameter("citizenName", citizenName);
    	return query.getSingleResult();
	}
}
