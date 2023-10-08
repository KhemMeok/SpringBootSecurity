package project_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project_api.model.RoleModel;
@Repository
public interface RoleRepository extends JpaRepository<RoleModel,Long> {
}
