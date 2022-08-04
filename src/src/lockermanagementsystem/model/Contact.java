package lockermanagementsystem.model;

import lombok.Getter;

@Getter
public class Contact {

    private String phone;
    private String email;

    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }
}
