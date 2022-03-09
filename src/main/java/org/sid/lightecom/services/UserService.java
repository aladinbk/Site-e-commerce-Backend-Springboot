package org.sid.lightecom.services;

import org.sid.lightecom.dao.UsersRepository;
import org.sid.lightecom.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UsersRepository usersRepository;
	public Users authenticate(Users user) {
		return usersRepository.findOneByEmailAndPassword(user.getEmail(),
				user.getPassword());
	}
}
