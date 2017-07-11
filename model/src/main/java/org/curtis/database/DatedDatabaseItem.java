package org.curtis.database;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class DatedDatabaseItem extends DatabaseItem {
    @Column(name = "date_created")
    private Date dateCreated = new Date();

    @Column(name = "date_modified")
    private Date dateModified = new Date();

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }
}
