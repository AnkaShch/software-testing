package com.oldVK.main;

import com.oldVK.main.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class UserTest {

    @Test
    void testUser() throws SQLException {
        User user = new User("Test", "test");

        Assertions.assertEquals("Test", user.getName());

        Assertions.assertEquals("test", user.getPassword());
    }
}
