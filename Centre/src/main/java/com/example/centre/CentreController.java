package com.example.centre;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centres")
public class CentreController {

    @Autowired
    private CentreService centreService;

    @GetMapping
    public List<Centre> getAllCentres() {
        return centreService.getAllCentres();
    }

    @GetMapping("/{id}")
    public Centre getCentreById(@PathVariable int id) {
        return centreService.getCentreById(id);
    }

    @PostMapping
    public Centre createCentre(@RequestBody Centre centre) {
        return centreService.createCentre(centre);
    }

    @PutMapping("/{id}")
    public Centre updateCentre(@PathVariable int id, @RequestBody Centre centre) {
        return centreService.updateCentre(id, centre);
    }

    @DeleteMapping("/{id}")
    public void deleteCentre(@PathVariable int id) {
        centreService.deleteCentre(id);
    }

}
