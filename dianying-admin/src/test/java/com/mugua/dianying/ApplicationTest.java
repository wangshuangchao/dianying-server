package com.mugua.dianying;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.AntPathMatcher;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mugua.dianying.Application;
import com.mugua.dianying.entity.AdminUser;
import com.mugua.dianying.entity.Menu;
import com.mugua.dianying.entity.MenuTree;
import com.mugua.dianying.entity.Role;
import com.mugua.dianying.mapper.AdminUserMapper;
import com.mugua.dianying.mapper.MenuMapper;
import com.mugua.dianying.service.MenuService;
import com.mugua.dianying.service.impl.MenuServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类  
public class ApplicationTest {

	@Autowired
	private MenuMapper mapper;
	@Autowired
	private AdminUserMapper userMapper;
	@Autowired
	private MenuService menuService;
	
	
	@Test
	public void test() {
//		List<Menu> list = mapper.selectList(null);
//		List<Menu> list = mapper.getAll();
//		List<Menu> list = mapper.getAllMenu();
		List<Menu> list = mapper.getByAdminUserId("1");
		MenuTree menuTree = new MenuTree();
		List<Object> menuList = menuTree.menuList(list);
		System.out.println(menuList);
		System.out.println("-------------------");
		System.out.println(list);
		System.out.println("-------------------");
	}
	@Test
	public void test1() {
//		List<Menu> selectList = mapper.selectList(null);
		List<Menu> list = mapper.getMenusByRoleid("1");
		System.out.println(list);
	}
	@Test
	public void testUser() {
//		List<AdminUser> list = userMapper.selectList(new EntityWrapper<AdminUser>().eq("username", "root"));
//		System.out.println(list);
		AdminUser user = userMapper.loadUserByUsername("root");
		List<Role> list = userMapper.getRolesByAdminUserId("1");
		System.out.println(list);
		System.out.println("==============");
		System.out.println(user);
	}
	@Test
	public void testUrl() {
		AntPathMatcher antPathMatcher = new AntPathMatcher();
//		String requestUrl = ((FilterInvocation) o).getRequestUrl();
//        List<Menu> allMenu = menuService.getAllMenu();
        boolean match = antPathMatcher.match("/login", "/login");
        System.out.println(match);
	}

	@Autowired
	private MenuServiceImpl menuImpl;
	@Test
	public void testMe(){
		List<Object> list = menuImpl.getMenusByAdminId("1");
		System.out.println(list);
		System.out.println("==========================");
	}
	@Test
	public void testPassword(){
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		AdminUser user=new AdminUser();
		user.setPassword("root");
		String encode = encoder.encode(user.getPassword().trim());
		System.out.println(encode);
	}
}
