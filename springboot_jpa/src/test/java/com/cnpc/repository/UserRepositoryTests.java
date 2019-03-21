package com.cnpc.repository;

import com.cnpc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Resource
    private UserRepository userRepository;

	@Test
	public void testSave() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		
//		userRepository.save(new User("aa", "aa123456","aa@1226.com", "aa",  formattedDate));
//		userRepository.save(new User("bb", "bb123456","bb@1326.com", "bb",  formattedDate));
//		userRepository.save(new User("cc", "cc123456","cc@1426.com", "cc",  formattedDate));
		for (int i = 0; i < 20 ; i++) {
			userRepository.save( new User( "magic"+i,"password"+i,"magic"+i+"@163.com","test"+i,formattedDate ) );
		}

	}


	@Test
	public void testBaseQuery() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);
		User user=new User("132ff", "1123456","ff@221126.com", "ff33",  formattedDate);
		System.out.println(userRepository.findAll());
		System.out.println(		userRepository.findById(3L));
		System.out.println(userRepository.save(user));
		System.out.println(userRepository.count());
		System.out.println(userRepository.existsById(3L));


		user.setId(2L);
		userRepository.delete(user);


	}

	@Test
	public void testCustomSql() {
		//userRepository.modifyById("neo",3L);
		//userRepository.deleteById(3L);
		User byEmail = userRepository.findByEmail("aa@1226.com");
		System.out.println(byEmail.toString());
	}


	@Test
	public void testPageQuery()  {
		int page=2,size=3;
		Sort sort = new Sort(Sort.Direction.ASC, "id");
		Pageable pageable = PageRequest.of(page, size, sort);
		Page<User> all = userRepository.findALL(pageable);
		for (User user:all) {
			System.out.println(user.toString());
		}
		//userRepository.findByNickName("aa", pageable);
	}

}