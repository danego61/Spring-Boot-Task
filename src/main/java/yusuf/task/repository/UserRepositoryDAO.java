package yusuf.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yusuf.task.model.entity.User;

import java.util.Optional;

@Repository
public interface UserRepositoryDAO extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailOrTelephone(String email, String telephone);

}
