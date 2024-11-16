package org.example.billiard_store.controller;


import org.example.billiard_store.model.Staff;
import org.example.billiard_store.service.impl.StaffServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StaffController {
    private final StaffServiceImpl staffService;

    @Autowired
    public StaffController(StaffServiceImpl staffService){
        this.staffService = staffService;
    }

    @GetMapping("/register")
    public String displayRegister(Model model){
        model.addAttribute("staff", new Staff());
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(Staff staff){
        staffService.registerNewStaff(staff);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("errorMessage", "Invalid username or password.");
        }
        if (logout != null) {
            model.addAttribute("logoutMessage", "You have been logged out successfully.");
        }
        return "login"; // Return the login.html view
    }

    @GetMapping("/home")
    public String homePage() {
        return "home"; // Return the home.html view
    }
}
