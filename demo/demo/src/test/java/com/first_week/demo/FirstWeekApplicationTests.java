package com.first_week.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first_week.demo.pojo.User;
import com.first_week.demo.web.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserController.class)
public class FirstWeekApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserController userController;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void testGetUserById() throws Exception {
		// 创建测试用户
		User user = new User();
		user.setId(1L);
		user.setName("John Doe");
		user.setAge(30);

		// 模拟控制器行为
		when(userController.getUserById(1L)).thenReturn(user);

		// 执行 GET 请求
		mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age").value(30));
	}

	@Test
	public void testPostUser() throws Exception {
		// 创建测试用户
		User user = new User();
		user.setId(1L);
		user.setName("Jane Smith");
		user.setAge(25);

		// 将用户对象转换为JSON字符串
		String userJson = objectMapper.writeValueAsString(user);

		// 执行 POST 请求
		mockMvc.perform(MockMvcRequestBuilders.post("/users/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("success"));
	}
}
