package com.conneqt.canara.service;

import javax.persistence.EntityManager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conneqt.canara.models.canara_loans_cpl_cel_cgl;
import com.conneqt.canara.repo.CampianRepository;



@Service
public class Canara_Loans_Cpl_Cel_Cgl_Service {

    @Autowired
    private EntityManager entityManager;

    
    @Autowired
    private CampianRepository campain;
    
    public boolean saveBOIEFRMDetailsUAT(canara_loans_cpl_cel_cgl entity) {
    	
    	boolean f = false;
        // Fetching maximum recordId and handling NULL case
        Integer maxRecordId = entityManager.createQuery("SELECT COALESCE(MAX(e.recordId), 0) FROM canara_loans_cpl_cel_cgl e", Integer.class)
                .getSingleResult();
        
        System.out.println("Maxrecord Id: "+maxRecordId);
        
        // Incrementing the maxRecordId for the new entity
        entity.setRecordId(maxRecordId + 1);
        
        System.out.println("Record ID Value: "+entity.getRecordId());
        
        Integer maxchainId = entityManager.createQuery("SELECT COALESCE(MAX(e.chainId), 0) FROM canara_loans_cpl_cel_cgl e", Integer.class)
                .getSingleResult();
        
        entity.setChainId(maxchainId + 1);

        System.out.println("Chain ID Value: "+entity.getChainId());
        
        
        
       
      
        
        
        // Similarly, if there's a campaignId to set, retrieve and set it here

        // Saving the entity using CampianRepository
        
        try{
        	 campain.save(entity);

             f = true;
        	
        }catch (Exception e) {
			System.out.println("Error Occured during inserting: "+e.getMessage());
		}
        

        return f;
    }
}

