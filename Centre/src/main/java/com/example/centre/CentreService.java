package com.example.centre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class CentreService {

    @Autowired
    private CentreRepository centreRepo;
    public List<Centre> getAllCentres() {
        return centreRepo.findAll();
    }

    public Centre getCentreById(int id) {
        return centreRepo.findById(id).orElse(null);
    }

    public Centre createCentre(Centre centre) {
        return centreRepo.save(centre);
    }

    public Centre updateCentre(int id, Centre centreDetails) {
        Centre centre = centreRepo.findById(id).orElse(null);
        if (centre!=null) {
            centre.setName(centreDetails.getName());
            centre.setDescription(centreDetails.getDescription());
            centre.setVille(centreDetails.getVille());
            return centreRepo.save(centre);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public void deleteCentre(int id) {
        centreRepo.deleteById(id);
    }



}
