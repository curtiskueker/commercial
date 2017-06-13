package org.curtis.access;

import org.curtis.database.DatedDatabaseItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "access_role")
public class AccessRole extends DatedDatabaseItem {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "accessRoles")
    private List<AccessUser> accessUsers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AccessUser> getAccessUsers() {
        return accessUsers;
    }

    public void setAccessUsers(List<AccessUser> accessUsers) {
        this.accessUsers = accessUsers;
    }
}
