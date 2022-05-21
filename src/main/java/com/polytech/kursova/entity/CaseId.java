package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class CaseId implements Serializable {
    private static final long serialVersionUID = -247033872115158786L;
    @Column(name = "CasesID", nullable = false)
    private Integer casesID;
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;

    @Override
    public int hashCode() {
        return Objects.hash(customerID, casesID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CaseId entity = (CaseId) o;
        return Objects.equals(this.customerID, entity.customerID) &&
                Objects.equals(this.casesID, entity.casesID);
    }
}