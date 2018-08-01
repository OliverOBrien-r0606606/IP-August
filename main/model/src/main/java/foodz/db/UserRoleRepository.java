package foodz.db;

import foodz.entity.User.UserRole;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EntityScan("foodz.entity")
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    @Query("select a.role from UserRole a, User b where b.username=?1 and a.userid=b.userId")
    public List<String> findRoleByUserName(String username);


}
