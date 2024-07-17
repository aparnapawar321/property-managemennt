package com.mycompany.property_management.repository;

import com.mycompany.property_management.entity.PropertyEntity;
import com.mycompany.property_management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //CrudRepo takes 2 parameters : first being  on which crud operations are to be performed and 2nd data type of primary key here it is Id's
}
