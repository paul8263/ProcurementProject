package com.paul.domain.abstractEntity;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by paulzhang on 19/12/2016.
 *
 * Super class with create date field
 */
@MappedSuperclass
public abstract class CreateDateEntity extends VersionedEntity {

    /**
     * Date when the entity was created
     */
    @Temporal(TemporalType.DATE)
    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreateDateEntity that = (CreateDateEntity) o;

        return createDate != null ? createDate.equals(that.createDate) : that.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
