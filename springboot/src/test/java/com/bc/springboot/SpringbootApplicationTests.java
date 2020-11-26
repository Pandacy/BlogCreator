package com.bc.springboot;

import com.bc.springboot.controller.UserController;
import com.bc.springboot.model.User;
import com.bc.springboot.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(UserController.class)
@SpringBootTest
public class SpringbootApplicationTests {
    //private MockMvc mvc;
    private UserService _userService;
    private List<User> _users = new ArrayList<>();

    @Before
    public void setUp() {
        _userService = mock(UserService.class);
        //mvc = MockMvcBuilders.standaloneSetup(_userController).build();
        _users.add(new User(1, "name1", "mail1@mail1.com", "password1"));
    }

    @Test
    public void testAddUser() throws Exception {
        //given
        _users.add(new User(1, "name2", "mail2@mail2.com", "password2"));
        Mockito.when(_userService.getUsers()).thenReturn(_users);

        Assert.assertEquals(_users.get(1).getName(), "name2");
        //
        //when

        //then
    }

}
