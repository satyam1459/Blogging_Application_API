package com.blog_satyam.Blogging_App;

import com.blog_satyam.Blogging_App.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BloggingAppApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest(){
		String className = this.userRepo.getClass().getName();
		String packName =this.userRepo.getClass().getPackageName();
		System.out.println(packName);
		System.out.println(className);
	}

}
