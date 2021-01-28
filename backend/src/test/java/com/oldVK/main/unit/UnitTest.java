package com.oldVK.main.unit;

import com.oldVK.main.models.User;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class UnitTest {
    @Test
    public void testUser() {
        User user = new User(1, "Tester", "test1");

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "Tester");
        assertEquals(user.getPassword(), "test1");
    }
}
