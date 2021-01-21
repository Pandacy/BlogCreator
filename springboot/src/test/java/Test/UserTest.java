package Test;

import Repository.UserRepository;
import com.bc.springboot.model.User;
import com.bc.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class UserTest {
    @Test
    public void FindUserByName(){
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        repo.users.add(user);
        //act
        User returnUser = service.getUserByName(user.getName());
        //assert
        assertEquals(repo.users.get(0), returnUser);
    }

    @Test
    public void addUserTest(){
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        //act
        service.AddUser(user);
        //assert
        assertTrue(repo.users.contains(user));
    }

    @Test
    public void deleteUserTest(){
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        repo.users.add(user);
        //act
        service.DeleteUser(1);
        //assert
        assertTrue(repo.users.isEmpty());
    }

    @Test
    public void updateUserTest(){
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        repo.users.add(user);
        User userInput = new User(1, "name2", "name2@hotmail.com", "password2", "token2");
        //act
        service.UpdateUser(userInput);
        //assert
        assertEquals(repo.users.get(0).getName(), userInput.getName());
        assertEquals(repo.users.get(0).getPassword(), userInput.getPassword());
        assertEquals(repo.users.get(0).getToken(), userInput.getToken());
    }

    @Test
    public void verifyUserTest()
    {
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        repo.users.add(user);
        User userInput = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        //act
        Boolean isVerified = service.verify(userInput);
        //assert
        assertTrue(isVerified);
    }

    @Test
    public void verifyAuthTest()
    {
        //arrange
        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        User user = new User(1, "name1", "name1@hotmail.com", "password1", "token1");
        repo.users.add(user);
        String token = "token1";
        //act
        Boolean isVerified = service.isAuthorized(token);
        //assert
        assertTrue(isVerified);
    }
}
