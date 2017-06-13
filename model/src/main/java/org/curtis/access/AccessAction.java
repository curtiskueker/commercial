package org.curtis.access;

import org.curtis.database.DatedDatabaseItem;

import javax.persistence.*;

@Entity
@Table(name = "access_action")
public class AccessAction extends DatedDatabaseItem {
    @OneToOne
    @JoinColumn(name = "access_user_id")
    private AccessUser accessUser;

    @Column(name = "access_action_type")
    private String accessActionType;

    @Column(name = "id_value")
    private Integer idValue;

    public AccessUser getAccessUser() {
        return accessUser;
    }

    public void setAccessUser(AccessUser accessUser) {
        this.accessUser = accessUser;
    }

    public String getAccessActionType() {
        return accessActionType;
    }

    public void setAccessActionType(String accessActionType) {
        this.accessActionType = accessActionType;
    }

    public Integer getIdValue() {
        return idValue;
    }

    public void setIdValue(Integer idValue) {
        this.idValue = idValue;
    }
}
