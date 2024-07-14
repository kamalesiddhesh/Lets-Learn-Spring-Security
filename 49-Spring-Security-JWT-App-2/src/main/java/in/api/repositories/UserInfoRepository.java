package in.api.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import in.api.entities.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	 Optional<UserInfo> findByName(String username); 
}
