package project_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import project_api.model.UserModel;

@Repository
//public interface UserRepository extends MongoRepository<UserModel, Long> {
//    UserModel getUserByUsername(String username);
//    List<UserModel> findByActiveTrue();
//}
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
    UserModel findByUserId(String userId);
    List<UserModel> findByActiveTrueOrderByIdAsc();

}
