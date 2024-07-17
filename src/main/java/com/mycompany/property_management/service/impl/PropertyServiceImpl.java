package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.PropertyConverter;
import com.mycompany.property_management.dto.PropertyDTO;
import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.repository.PropertyRepository;
import com.mycompany.property_management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        PropertyEntity propertyEntity = propertyConverter.ConverterDTOtoEntity(propertyDTO);
        propertyEntity = propertyRepository.save(propertyEntity);
        propertyDTO = propertyConverter.ConvertEntityToDTO(propertyEntity);

        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> propertyEntities = (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for (PropertyEntity propertyEntity : propertyEntities) {
            propList.add(propertyConverter.ConvertEntityToDTO(propertyEntity));
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO newPropertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
        PropertyDTO updatedProperty = new PropertyDTO();
        if (optEntity.isPresent()) {
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setOwnerName(newPropertyDTO.getOwnerName());
            propertyEntity.setOwnerEmail(newPropertyDTO.getOwnerEmail());
            propertyEntity.setTitle(newPropertyDTO.getTitle());
            propertyEntity.setDescription(newPropertyDTO.getDescription());
            propertyEntity.setPrice(newPropertyDTO.getPrice());
            propertyEntity.setAddress(newPropertyDTO.getAddress());
            updatedProperty = propertyConverter.ConvertEntityToDTO(propertyRepository.save(propertyEntity));
        }
        return updatedProperty;
    }

    @Override
    public PropertyDTO updatePropertyDescription(Long propertyId, PropertyDTO propertyDTO) {
        PropertyDTO updatedProperty = new PropertyDTO();
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);
        if (optEntity.isPresent()) {
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            updatedProperty = propertyConverter.ConvertEntityToDTO(propertyRepository.save(propertyEntity));
        }
        return updatedProperty;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}
