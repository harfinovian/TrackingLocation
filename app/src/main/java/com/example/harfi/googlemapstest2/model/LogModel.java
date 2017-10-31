package com.example.harfi.googlemapstest2.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by harfi on 10/17/2017.
 */
@Entity
public class LogModel {
    @Id(autoincrement = true)
    long id;
    Date date;
    Float longitude;
    Float latitude;
    long event_id;
    @ToOne(joinProperty = "event_id")
    EventModel event;
    boolean sts_deleted;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 791703473)
    private transient LogModelDao myDao;
    @Generated(hash = 338752165)
    public LogModel(long id, Date date, Float longitude, Float latitude,
            long event_id, boolean sts_deleted) {
        this.id = id;
        this.date = date;
        this.longitude = longitude;
        this.latitude = latitude;
        this.event_id = event_id;
        this.sts_deleted = sts_deleted;
    }
    @Generated(hash = 1039532375)
    public LogModel() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Date getDate() {
        return this.date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Float getLongitude() {
        return this.longitude;
    }
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
    public Float getLatitude() {
        return this.latitude;
    }
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
    public long getEvent_id() {
        return this.event_id;
    }
    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }
    public boolean getSts_deleted() {
        return this.sts_deleted;
    }
    public void setSts_deleted(boolean sts_deleted) {
        this.sts_deleted = sts_deleted;
    }
    @Generated(hash = 520039006)
    private transient Long event__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 519037407)
    public EventModel getEvent() {
        long __key = this.event_id;
        if (event__resolvedKey == null || !event__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EventModelDao targetDao = daoSession.getEventModelDao();
            EventModel eventNew = targetDao.load(__key);
            synchronized (this) {
                event = eventNew;
                event__resolvedKey = __key;
            }
        }
        return event;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1660324349)
    public void setEvent(@NotNull EventModel event) {
        if (event == null) {
            throw new DaoException(
                    "To-one property 'event_id' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.event = event;
            event_id = event.getId();
            event__resolvedKey = event_id;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2007717607)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getLogModelDao() : null;
    }

}
