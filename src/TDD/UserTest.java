package TDD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class UserTest {
        @Test
        void testOfUser(){
            UserKON.User user = new UserKON.User("tomas","abc123");
        }
    }

