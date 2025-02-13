package ao.com.angotech.service;

import ao.com.angotech.dto.AuthRequest;
import ao.com.angotech.enums.RoleEnum;
import ao.com.angotech.model.User;

public interface AuthService {

    String register(AuthRequest request, RoleEnum role);
    String login(String email, String password);
}
