package com.oldVK.main.unit;

import com.oldVK.main.dao.UserDao;
import com.oldVK.main.dao.UserJdbcDao;
import com.oldVK.main.models.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnitTest {
    @Test
    public void testUser() {
        User user = new User(1, "Tester", "test1");

        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "Tester");
        assertEquals(user.getPassword(), "test1");
    }
}
