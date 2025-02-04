package ao.com.angotech.enums;

public enum RoleEnum {

    CUSTOMER("customer"),
    ADMIN("admin");

    private String role;

    RoleEnum(String role) {
        this.role = role;
    }
}
