package org.curtis.access;

import org.curtis.database.DatedDatabaseItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "access_user")
public class AccessUser extends DatedDatabaseItem {
    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "access_role_user",
            joinColumns = @JoinColumn(name = "access_user_id"),
            inverseJoinColumns = @JoinColumn(name = "access_role_id"))
    private List<AccessRole> accessRoles = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Column(name = "is_active")
    private Boolean isActive;

    public List<AccessRole> getAccessRoles() {
        return accessRoles;
    }

    public void setAccessRoles(List<AccessRole> accessRoles) {
        this.accessRoles = accessRoles;
    }
}
