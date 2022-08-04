package lockermanagementsystem.model;

public abstract class LockerUser {

    private final Contact contact;

    public LockerUser(Contact contact) {
        this.contact = contact;
    }
}
