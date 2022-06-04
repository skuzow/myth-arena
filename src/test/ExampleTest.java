package test;

import mytharena.data.Data;
import mytharena.data.user.Admin;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class ExampleTest {

    @Test
    public void defaultAdminCreation() {
        Admin admin = new Admin("admin", "admin123", new Data());
        assertSame(admin, admin);
    }

}
