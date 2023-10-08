package project_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project_api.model.AddressModel;

public interface AddressRepository extends JpaRepository<AddressModel,Long>{
    
}
