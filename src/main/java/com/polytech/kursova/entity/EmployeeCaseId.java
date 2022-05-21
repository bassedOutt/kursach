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
public class EmployeeCaseId implements Serializable {
    private static final long serialVersionUID = -7262072560992614554L;
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;
    @Column(name = "CaseID", nullable = false)
    private Integer caseID;
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;

    @Override
    public int hashCode() {
        return Objects.hash(caseID, customerID, employeeID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmployeeCaseId entity = (EmployeeCaseId) o;
        return Objects.equals(this.caseID, entity.caseID) &&
                Objects.equals(this.customerID, entity.customerID) &&
                Objects.equals(this.employeeID, entity.employeeID);
    }
}