package team.sunrise.managementplatform.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sunrise.managementplatform.entity.LoginData;
import team.sunrise.managementplatform.entity.response.AccountResponse;
import team.sunrise.managementplatform.entity.response.Response;
import team.sunrise.managementplatform.service.AccountService;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("login")
    Response login(@RequestBody LoginData data) {
        if (accountService.login(data)) {
            return AccountResponse.ACCOUNT_LOGIN_SUCCESS;
        }
        return AccountResponse.ACCOUNT_LOGIN_WRONG_PASSWORD;
    }
}