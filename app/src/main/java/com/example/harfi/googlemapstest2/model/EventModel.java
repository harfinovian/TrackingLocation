package com.example.harfi.googlemapstest2.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by harfi on 10/17/2017.
 */
@Entity
public class EventModel {
    @Id(autoincrement = true)
    long id;
    String event_name;
    boolean sts_deleted;

    @Generated(hash = 781470668)
    public EventModel(long id, String event_name, boolean sts_deleted) {
        this.id = id;
        this.event_name = event_name;
        this.sts_deleted = sts_deleted;
    }
    @Generated(hash = 1307476520)
    public EventModel() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEvent_name() {
        return this.event_name;
    }
    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
    public boolean getSts_deleted() {
        return this.sts_deleted;
    }
    public void setSts_deleted(boolean sts_deleted) {
        this.sts_deleted = sts_deleted;
    }
    
}
