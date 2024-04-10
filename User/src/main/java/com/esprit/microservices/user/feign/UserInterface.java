package com.esprit.microservices.user.feign;

import com.esprit.microservices.user.dto.Reclamation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name ="Reclamation")
public interface UserInterface {

    @PostMapping("/create")
    ResponseEntity<Reclamation> createReclamation(@RequestBody Reclamation reclamation);

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteReclamation(@PathVariable("id") Long id);
}
