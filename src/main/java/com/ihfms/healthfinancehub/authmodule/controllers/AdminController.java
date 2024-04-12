package com.ihfms.healthfinancehub.authmodule.controllers;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("health-hub/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public User registerAdmin(
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String password
    ) throws SQLException {
        return adminService.registerAdminUser(username, email, password);
    }

}
