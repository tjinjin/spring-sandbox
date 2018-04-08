package hello;

import ch.qos.logback.classic.pattern.MethodOfCallerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import hello.User;
import hello.UserRepository;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/users") // This means URL's start with /demo (after Application path)
public class MainController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public @ResponseBody String addNewUser(@RequestBody User user){

        userRepository.save(user);
        return "Saved";
    }

    @RequestMapping(method=RequestMethod.PUT, path="{id}")
    public @ResponseBody User modifyUser(@RequestBody User user,
                                         @PathVariable Integer id){

        user.setId(id);
        return userRepository.save(user);
    }

    @RequestMapping(method=RequestMethod.DELETE)
    public @ResponseBody Iterable<User> deleteUser() {
        // This returns a JSON or XML with the users
        userRepository.deleteAll();
        return userRepository.findAll();
    }
}
