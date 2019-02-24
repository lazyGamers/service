package com.lazygamers.services;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import com.lazygamers.entities.TestDTO;
import com.lazygamers.entities.TestEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TestService {
    
    @PersistenceContext(unitName = "main-jpa-unit")
    private EntityManager em;
    
    public List<TestEntity> getAll(QueryParameters query) {
        return JPAUtils.queryEntities(em, TestEntity.class, query);
    }
    
    public TestEntity getByName(String name) {
        TypedQuery<TestEntity> query = em.createNamedQuery("Test.findByName", TestEntity.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
    
    @Transactional
    public void remove(long id) {
        TestEntity testEntity = em.find(TestEntity.class, id);
        if (testEntity != null) {
            em.remove(testEntity);
        }
    }
    
    @Transactional
    public void create(TestDTO dto) {
        TestEntity entity = new TestEntity();
        entity.setAddress(dto.getAddress());
        entity.setLastName(dto.getLastName());
        entity.setName(dto.getName());
        em.persist(entity);
    }
}
