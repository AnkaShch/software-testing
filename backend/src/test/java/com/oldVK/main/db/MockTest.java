package com.oldVK.main.db;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oldVK.main.controllers.PostController;
import com.oldVK.main.controllers.UserController;
import com.oldVK.main.dao.PostDao;
import com.oldVK.main.dao.UserDao;
import com.oldVK.main.models.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = PostController.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class MockTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostDao postDao;

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testGetUser() throws Exception {
        int id = 1;
        String login = "Vasily";
        String password = "123456";

        Post post = new Post("asd", "asd");

//        when(userDao.getUser(login, password)).thenReturn(id);
        String expectedContent =
                mapper.writeValueAsString(post);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/GetPosts?=" + String.valueOf(id)))
                .andExpect(content().string(expectedContent));
    }
}
