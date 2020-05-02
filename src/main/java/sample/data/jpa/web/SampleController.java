/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.data.jpa.service.UsersService;
import sample.data.jpa.domain.Users;

@RestController
public class SampleController {

	@Autowired
	private UsersService usersService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String helloWorld() {
		return "WELCOME";
	} 	
	
	@RequestMapping(value="/getUser", method=RequestMethod.POST)
	@ResponseBody
	@Transactional(readOnly = true)
	public Users getUser(@RequestBody Users user, HttpServletRequest request, HttpServletResponse response) throws Exception{
		Users users = usersService.getUsers(user.getUserId());
		if(users != null) {
			return users; }
		else {
			return new Users("User Not Found","Role Not Found");
		}
	}

	@RequestMapping(path="/clearCache", method=RequestMethod.GET)
	public String clearCache() {
		return usersService.clearCache();
	} 	
	
	@RequestMapping(path="/clearCacheByUserId", method=RequestMethod.POST)
	public String clearCacheByUserId(@RequestBody Users user, HttpServletRequest request, HttpServletResponse response) throws Exception{
		return usersService.clearCacheByUserId(user.getUserId());
	} 	

}
