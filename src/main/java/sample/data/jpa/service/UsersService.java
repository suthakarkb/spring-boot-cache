package sample.data.jpa.service;

import sample.data.jpa.domain.Users;

public interface UsersService {
	
	Users getUsers(String userId);
	String clearCache();
	String clearCacheByUserId(String userId);

}