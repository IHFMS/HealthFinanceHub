package com.ihfms.healthfinancehub.authmodule.controllers;
import com.ihfms.healthfinancehub.authmodule.models.usermodels.*;
import com.ihfms.healthfinancehub.authmodule.services.FinanceStaffService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("health-hub/finance-staff")
@CrossOrigin(origins = "http://localhost:3000")
public class FinanceStaffController {

    private final FinanceStaffService financeStaffService;

    public FinanceStaffController(FinanceStaffService financeStaffService) {
        this.financeStaffService = financeStaffService;
    }

    @PostMapping
    public User registerFinanceUser(
        @RequestParam(required = false) String username,
        @RequestParam(required = false) String email,
        @RequestParam(required = false) String password
    ) throws SQLException {
        return financeStaffService.registerFinanceStaff(username, email, password);
    }
}
