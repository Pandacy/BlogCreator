package com.bc.springboot;

import com.bc.springboot.controller.UserController;
import com.bc.springboot.model.User;
import com.bc.springboot.repository.IUserRepository;
import com.bc.springboot.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@WebMvcTest(UserController.class)
public class SpringbootApplicationTests {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private UserService _userService;

    @Before
    public void setUp() {
        _userService = new UserService();
        mvc = MockMvcBuilders.standaloneSetup(_userService).build();
    }

    @Test
    public void testGetUsers() throws Exception {
        /*User user = new User();
        user.setName("Test");
        user.setPassword("Test1");
        user.setToken("asd");
        user.setEmail("Test@Test.nl");

        when(_userService.getUserById(anyInt())).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/user/1"))
                .andExpect(status().isOk());*/
    }

}
