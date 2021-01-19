package Test;

import Repository.UserRepository;
import com.bc.springboot.model.User;
import com.bc.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    @Test
    public void FindUserByName(){
        UserService service = new UserService(new UserRepository());

        //arrange
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        service.AddUser(user);
        //act
        User returnUser = service.getUserByName(user.getName());
        //assert
        assertEquals(user, returnUser);
    }
}
