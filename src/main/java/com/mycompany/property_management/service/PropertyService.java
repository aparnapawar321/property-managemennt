package com.mycompany.property_management.service;

import com.mycompany.property_management.dto.PropertyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyDescription(Long propertyId, PropertyDTO propertyDTO);
    void deleteProperty(Long propertyId);

}
