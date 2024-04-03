// com.ihfms.healthfinancehub.accountsmodule.controllers.ApplicationController
package com.ihfms.healthfinancehub.accountsmodule.controllers;

import com.ihfms.healthfinancehub.accountsmodule.services.EventManagerService;

public class ApplicationController {
    public void config() {
        Editor editor = new Editor();

        LoggingListener logger = new LoggingListener(
                "/path/to/log.txt",
                "Someone has opened the file: %s");
        editor.getEvents().subscribe("open", logger);

        EmailAlertsListener emailAlerts = new EmailAlertsListener(
                "admin@example.com",
                "Someone has changed the file: %s");
        editor.getEvents().subscribe("save", emailAlerts);
    }
}
