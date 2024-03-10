package com.first_week.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.first_week.demo.Entity.UserDTO;
import com.first_week.demo.pojo.User;
import com.first_week.demo.web.UserDTOController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(UserDTOController.class)
public class FirstWeekApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserDTOController userDTOController;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() throws Exception {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(new UserDTOController()).build();
	}

	@Test
	public void testGetUserById() throws Exception {
		// 创建测试用户
		User user = new User();
		user.setId(1L);
		user.setName("John Doe");
		user.setAge(30);
		UserDTO userDTO = new UserDTO();

		// 模拟控制器行为
		when(userDTOController.getUserById(1L)).thenReturn(userDTO);

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
	@Test
	public void testUsercontroller() throws Exception {
		RequestBuilder request;

		User user = new User();
		user.setId(1L);
		user.setName("John Doe");
		user.setAge(30);

		String userJson = objectMapper.writeValueAsString(user);
		//post加用户
		mockMvc.perform(MockMvcRequestBuilders.post("/users/")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJson))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("success"));

		//更新

		request = put("/users/1").contentType(MediaType.APPLICATION_JSON)
				.content(userJson);

		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("success")));
		//删除

		request = delete("/users/1");
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("111")))
		;


	}
}
