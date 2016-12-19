package com.paul.domain.abstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by paulzhang on 19/12/2016.
 *
 * Base super class
 */
@MappedSuperclass
public abstract class VersionedEntity implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Version
     */
    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VersionedEntity that = (VersionedEntity) o;

        if (id != that.id) return false;
        return version == that.version;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (version ^ (version >>> 32));
        return result;
    }
}
