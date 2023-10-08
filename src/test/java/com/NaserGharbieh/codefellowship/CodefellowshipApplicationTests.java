package com.NaserGharbieh.codefellowship;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {
	@Autowired
	MockMvc mockMvc;

	@Test
	void contextLoads() {
	}



		@Test
		void testLoginPage() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/login"))
					.andDo(print()) // Print the response content to the console for debugging
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(containsString("<h1>Please log in!</h1>")));

		}
		@Test
		void testSignUpPage() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/signup"))
					.andDo(print()) // Print the response content to the console for debugging
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(containsString("<form action=\"/signup\" method=\"post\" >")));

		}	@Test
		void testHomePage() throws Exception {
			mockMvc.perform(MockMvcRequestBuilders.get("/"))
					.andDo(print()) // Print the response content to the console for debugging
					.andExpect(MockMvcResultMatchers.status().isOk())
					.andExpect(MockMvcResultMatchers.content().string(containsString("<h1>Welcome to CodeFellowShip  </h1>")));

		}


}
