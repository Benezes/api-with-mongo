package br.com.mnz.userservice.repository;

import br.com.mnz.userservice.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserRepository extends MongoRepository<UserModel, UUID> {

    UserModel findByFirstName(String firstName);
}
