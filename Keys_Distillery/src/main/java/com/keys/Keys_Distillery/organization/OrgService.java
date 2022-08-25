package com.keys.Keys_Distillery.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrgService {

    OrgRepository Repository;

    @Autowired
    public OrgService(OrgRepository Repository) {
        this.Repository = Repository;
    }

    public List<Organization> getOrganizations(){
        return Repository.findAll();
    }

    public void addNewOrganization(Organization Organization) {
        Optional<Organization> OrganizationOptional =
                Repository.findOrganizationByLink(Organization.getLink());
        if (OrganizationOptional.isPresent()){
            throw new IllegalStateException("link is taken");
        }
        Repository.save(Organization);
    }

    public void deleteOrganization(Integer id) {
        boolean exists = Repository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Organization with id " + id + "does not exists");
        }
        Repository.deleteById(id);
    }
}
