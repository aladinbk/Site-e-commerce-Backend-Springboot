package org.sid.lightecom.dao;

import org.sid.lightecom.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
	
	public Users findOneByEmailAndPassword(String username, String password);

}
