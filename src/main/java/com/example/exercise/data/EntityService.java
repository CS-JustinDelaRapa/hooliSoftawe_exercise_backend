package com.example.exercise.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntityService {

    private final EntityRepository entityRepository;

    @Autowired
    public EntityService(EntityRepository entityRepository) {
        this.entityRepository = entityRepository;
    }

    public List<EntityDTO> getEntity(){
        return entityRepository.findAll()
                .stream()
                .map(this::modelToDTO)
                .collect(Collectors.toList());
    }

    public void addNewEntity(EntityModel entityModel) {
        entityRepository.save(entityModel);
    }

    public void deleteEntity(int entityId) {
        boolean exist = entityRepository.existsById(entityId);
        if(!exist){
            throw new IllegalStateException(
                    "Entity with ID "+entityId+" does not exist"
            );
        }
        entityRepository.deleteById(entityId);
    }

    public Optional<EntityDTO> getSingletEntity(int entityId) {
        boolean exist = entityRepository.existsById(entityId);
        if(!exist){
            throw new IllegalStateException(
                    "Entity with ID "+entityId+" does not exist"
            );
        }else{
            EntityModel singleEntity = entityRepository.getById(entityId);
            return Optional.of(modelToDTO(singleEntity));
        }
    }

    public void updateEntity(int entityId, EntityModel entityModel
//                             String username, String description, String targetDateString
    ) {
        entityRepository.save(entityModel);
//        //check if user with given ID exist
//        EntityModel entityModel = entityRepository.findById(entityId)
//                .orElseThrow(() -> new IllegalStateException(
//                        "Entity with ID "+entityId+" does not exist"
//        ));
//
//        //validate updating fields,
//        if (username != null &&
//                username.length() > 0 &&
//                !Objects.equals(entityModel.getUsername(), username)){
//            entityModel.setUsername(username);
//        }
//
//        if (description != null &&
//                description.length() > 0 &&
//                !Objects.equals(entityModel.getDescription(), description)){
//            entityModel.setDescription(description);
//        }
//
//        if (username != null &&
//                username.length() > 0 &&
//                !Objects.equals(entityModel.getUsername(), username)){
//            entityModel.setUsername(username);
//        }
//
//        //date validation
//        if (targetDateString != null ){
//            entityModel.setTargetDate(LocalDate.parse(targetDateString));
//        }
//
//        entityRepository.save(entityModel);
    }

    //convert entityModel to DTO
    private EntityDTO modelToDTO (EntityModel entity){
        EntityDTO entityDTO = new EntityDTO();
          entityDTO.setId(entity.getId());
          entityDTO.setUsername(entity.getUsername());
          entityDTO.setDescription((entity.getDescription()));
          entityDTO.setTargetDate(entity.getTargetDate());
        return entityDTO;
    }
}
