package tests;

import org.junit.jupiter.api.Test;
import utils.extensions.WithLogin;

public class BookStoreTests extends TestBase{

    @Test
    @WithLogin
    void emptyBookList() {}
}
