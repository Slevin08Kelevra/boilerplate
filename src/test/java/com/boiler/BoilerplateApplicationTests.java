package com.boiler;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.boiler.services.PeopleService;

import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest
public class BoilerplateApplicationTests {
	
	
	@Autowired
    private MockMvc mockMvc;
	
	
	@MockBean
	@Qualifier("userServiceImp")
    private PeopleService userService;
	
	@Test
	public void testCont() throws Exception {
		
		
		given(userService.findById(1)).willReturn(true);
		
		 this.mockMvc.perform(get("/users/2"))
         .andExpect(status().isOk());
	}



}
