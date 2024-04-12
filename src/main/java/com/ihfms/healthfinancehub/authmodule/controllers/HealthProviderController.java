package com.ihfms.healthfinancehub.authmodule.controllers;

import com.ihfms.healthfinancehub.authmodule.models.usermodels.User;
import com.ihfms.healthfinancehub.authmodule.services.HealthProviderService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("health-hub/health-provider")
@CrossOrigin(origins = "http://localhost:3000")
public class HealthProviderController {

    private final HealthProviderService healthProviderService;

    public HealthProviderController(HealthProviderService healthProviderService) {
        this.healthProviderService = healthProviderService;
    }

    @GetMapping
    public User registerProvider(
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String password,
        @RequestParam(required = false) String specialization
    ) throws SQLException {
        return healthProviderService.registerHealthProvider(username, email, password, specialization);
    }
}
