package com.bc.springboot;

import com.bc.springboot.controller.UserController;
import com.bc.springboot.model.User;
import com.bc.springboot.repository.IUserRepository;
import com.bc.springboot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class SpringbootApplicationTests {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService _userService;

    @Autowired
    private IUserRepository _iUserRepository;

    private List<User> _users = new ArrayList<>();
    User user = new User();

    @Before
    public void setUp() {
        _userService = new UserService();
        mvc = MockMvcBuilders.standaloneSetup(_userService).build();
        UserController controller = new UserController();
         user = new User("name1", "mail1@mail1.com", "password1", "fds");
    }

    @Test
    public void testFindUser() throws Exception {
        user = new User("name2", "mail2@mail2.com", "password2", "asd");

         mvc.perform(post("/user/{id}", 1)
                .contentType("application/json")
                 .content(asJsonString(user)))
                 .andExpect(status().isOk());

         //var User = _iUserRepository.findByName("name2");
    }

    @Test
    public void testAddUser() throws Exception {
        //given
        _users.add(new User("name2", "mail2@mail2.com", "password2", "asd"));

        //when
        Mockito.when(_userService.getUsers()).thenReturn(_users);

        //then
        Assert.assertEquals(_users.get(1).getName(), "name2");
    }

    @Test
    public void testDeleteUser() throws Exception {
        //given
        long countNew = _users.stream().count();
        User user = new User(1);
        String test = "";
        //when
        Mockito.when(_userService.DeleteUser(1)).thenReturn("Success");
        mvc.perform(MockMvcRequestBuilders.delete("/user", 1))
                .andExpect(status().isOk());

        //then
        Assert.assertEquals(countNew - 1, _users.stream().count());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
