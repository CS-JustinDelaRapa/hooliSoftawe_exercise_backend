package com.example.exercise.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/todo")
@CrossOrigin
public class EntityController {

    private final EntityService entityService;

    @Autowired
    public EntityController(EntityService entityService) {
        this.entityService = entityService;
    }

    @GetMapping
    public List<EntityDTO> getEntity(){
        return entityService.getEntity();
    }

    @GetMapping(path = "{entityId}")
    public Optional<EntityDTO> getSingleEntity(@PathVariable("entityId") int entityId){
        return entityService.getSingletEntity(entityId);
    }

    @PostMapping
    public void postNewEntity(@RequestBody EntityModel entityModel){
        entityService.addNewEntity(entityModel);
    }

    @DeleteMapping(path = "{entityId}")
    public void deleteEntity(@PathVariable("entityId") int entityId){
        entityService.deleteEntity(entityId);
    }

    @PutMapping(path = "{entityId}")
    public void putEntity(@PathVariable int entityId,
                         @RequestBody EntityModel entityModel){
        entityService.updateEntity(entityId,entityModel);
    }
}
