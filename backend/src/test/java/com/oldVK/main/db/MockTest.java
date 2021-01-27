package com.oldVK.main.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oldVK.main.controllers.PostController;
import com.oldVK.main.controllers.UserController;
import com.oldVK.main.dao.PostDao;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.models.Post;
import com.oldVK.main.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@AutoConfigureRestDocs(outputDir = "target/doc")
public class MockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDao userDao;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetUser() throws Exception {
        int id = 1;
        String login = "Vasily";
        String password = "123456";

        Post post = new Post("asd", "asd");

        User user = new User(id, login, password);

        when(userDao.addUser(login, password)).thenReturn(id);

        String expectedContent = mapper.writeValueAsString(userDao.getUsers());
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getListOfUsers"))
                .andExpect(status().isOk()).andExpect(content().string(expectedContent)).andDo(document("getCoins"));;
    }
}
