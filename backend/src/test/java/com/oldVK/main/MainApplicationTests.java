package com.oldVK.main;

import com.oldVK.main.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ainApplicationTests {

    @Test
    public void testUser() {
        User user = new User(1, "Tester", "test1");

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "Tester");
        assertEquals(user.getPassword(), "test1");
    }

    @Test
    public void testUserLogPass() {
        User user = new User("Tester", "test1");

        assertEquals(user.getName(), "Tester");
        assertEquals(user.getPassword(), "test1");
    }
}
