package foodz.db;

import foodz.entity.User.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;

@EntityScan("foodz.entity")
public interface UserRepository extends JpaRepository<User, Long>{
    User getByUsername(String userName);
    User getByEmail(String email);
}
