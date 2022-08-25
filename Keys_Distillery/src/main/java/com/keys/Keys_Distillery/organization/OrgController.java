package com.keys.Keys_Distillery.organization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(path = "/api/org")
@CrossOrigin()
public class OrgController {

    private final OrgService orgService;

    @Autowired
    public OrgController(OrgService orgService) {
        this.orgService = orgService;
    }

    @GetMapping
    public List<Organization> getOrganizations(){
        return orgService.getOrganizations();
    }

    @GetMapping(path="response")
    public String usingHttpServletResponse(HttpServletResponse response) {
        response.addHeader("x-total-count", String.valueOf(orgService.getOrganizations().size()));
        return String.valueOf(orgService.getOrganizations().size());
    }

    @PostMapping(path = "/register")
    public void RegisterNewOrganization(@RequestBody Organization Organization){
        orgService.addNewOrganization(Organization);
    }

    @DeleteMapping(path = "{OrganizationId}")
    public void DeleteOrganization(@PathVariable("OrganizationId") Integer id){
        orgService.deleteOrganization(id);
    }

}
