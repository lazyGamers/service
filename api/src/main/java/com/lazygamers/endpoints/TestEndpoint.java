package com.lazygamers.endpoints;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import com.kumuluz.ee.rest.beans.QueryParameters;
import com.lazygamers.entities.TestDTO;
import com.lazygamers.entities.TestEntity;
import com.lazygamers.services.TestService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@RequestScoped
@GraphQLClass
public class TestEndpoint {

    @Inject
    private TestService testService;
    
    @Context
    protected UriInfo uriInfo;
    
    @GraphQLQuery
    public List<TestEntity> getAll() {
        QueryParameters query;
        
        if (uriInfo == null) {
            query = new QueryParameters();
        } else {
            query = QueryParameters.query(uriInfo.getRequestUri().getQuery()).build();
        }
        return testService.getAll(query);
    }
    
    @GraphQLQuery
    public TestEntity getByName(@GraphQLArgument(name="name") String name) {
        return testService.getByName(name);
    }
    
    @GraphQLMutation
    public boolean delete(@GraphQLArgument(name="id") long id) {
        testService.remove(id);
        return true;
    }
    
    @GraphQLMutation
    public boolean create(@GraphQLArgument(name = "entity") TestDTO entity) {
        testService.create(entity);
        return true;
    }
}
