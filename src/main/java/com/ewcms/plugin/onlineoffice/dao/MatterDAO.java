/*
 * Copyright (c)2010 Jiangxi Institute of Computing Technology(JICT), All rights reserved.
 * JICT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * http://www.jict.org
 */
package com.ewcms.plugin.onlineoffice.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ewcms.common.dao.JpaDAO;
import com.ewcms.plugin.onlineoffice.model.Matter;

/**
 *
 * @author 吴智俊
 */
@Repository()
public class MatterDAO extends JpaDAO<Integer, Matter> {
	public Integer findMatterMaxSort(){
    	String hql = "SELECT MAX(a.sort) FROM Matter AS a";
    	TypedQuery<Integer> query = this.getEntityManager().createQuery(hql, Integer.class);
    	return query.getSingleResult();
    }
    
    public Matter findMatterBySort(Integer sort){
    	String hql = "FROM Matter AS a WHERE a.sort=:sort";
    	TypedQuery<Matter> query = this.getEntityManager().createQuery(hql, Matter.class);
    	query.setParameter("sort", sort);
    	return query.getSingleResult();
    }
    
	public List<Matter> findMatterAllOrderBySort(){
    	String hql = "FROM Matter AS a ORDER BY a.sort";
    	TypedQuery<Matter> query = this.getEntityManager().createQuery(hql, Matter.class);
    	return query.getResultList();
    }
    
	public Matter findMatterByMatterName(String matterName){
    	String hql = "From Matter As l Where l.name=:matterName";
    	TypedQuery<Matter> query = this.getEntityManager().createQuery(hql, Matter.class);
    	query.setParameter("matterName", matterName);
    	return query.getSingleResult();
    }
    
	public Matter findMatterByMatterIdAndMatterName(Integer matterId, String matterName){
    	String hql = "From Matter As l Where l.id!=:matterId And l.name=:matterName";
    	TypedQuery<Matter> query = this.getEntityManager().createQuery(hql, Matter.class);
    	query.setParameter("matterId", matterId);
    	query.setParameter("matterName", matterName);
    	return query.getSingleResult();
    }
}
