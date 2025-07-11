package SiDev.spring_ecomm.repository;

import SiDev.spring_ecomm.entity.userentity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long>,CustomRepository {
    UserEntity findByUserName(String username);
    UserEntity findByUserGmail(String usergmail);
    UserEntity findByUserPhoneNo(String phoneno);
}

