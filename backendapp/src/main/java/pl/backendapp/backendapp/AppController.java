package pl.backendapp.backendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.persistence.GeneratedValue;
import javax.swing.plaf.PanelUI;
import java.util.List;

@Controller
public class AppController  {
    @Autowired
    private UserRepository repo;

    @Autowired
    private UserDataRepository repoData;

    @Autowired
    private SendRepository repoSend;

    @GetMapping("")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model){
        model.addAttribute("user", new User());

        return "signup_form";
    }
    @GetMapping("/add_user_data")
    public String showAddDataForm(Model model){

        model.addAttribute("userData", new UserData());
        return "add_data";
    }


    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repo.save(user);
        return "register_success";
    }

    @PostMapping("/add_user_data")
    public String addSomeUsersData(UserData userData){
        repoData.save(userData);
        return "add_data_success";
    }

    @GetMapping("/list_users")
    public String viewUser(Model model){
        List<UserData> listUsers = repoData.findAll();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/send_form")
    public String sendpackage(Model model){

        model.addAttribute("send", new Send());
        return "send_form";
    }

    @PostMapping("/send_process")
    public String sendprocess(Send send){
        repoSend.save(send);
        return "send_success";
    }
    @GetMapping("/spy")
    public String spypackage(){
        return "spy";
    }
}
