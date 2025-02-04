package ao.com.angotech.enums;

public enum RoleEnum {

    CLIENTE("cliente"),
    ADMIN("admin");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
