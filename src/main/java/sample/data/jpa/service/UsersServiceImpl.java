package sample.data.jpa.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import sample.data.jpa.domain.Users;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("usersService")
@CacheConfig(cacheNames = "users")
@Transactional
class UsersServiceImpl implements UsersService {
	
	private final UsersRepository usersRepository;	
	private final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
	
	public UsersServiceImpl(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}	
	
	@Override
	@Cacheable("getusers")
	public Users getUsers(String userId) {
		log.info("Inside getUser call");
		Assert.notNull(userId, "Users Id must not be null");
		return this.usersRepository.findByUserIdAllIgnoringCase(userId);
	}
	
	@Override
	@CacheEvict(value = "getusers", allEntries = true)
	public String clearCache() {
		log.info("Inside clearCache call");
		return "getusers values removed from Cache";
	}
	
	@Override
	@CacheEvict(value = "getusers", beforeInvocation = true)	
	public String clearCacheByUserId(String userId) {
		log.info("Inside clearCacheByUserId call");
		return "getusers ["+userId+"]value removed from Cache";
	}
}
