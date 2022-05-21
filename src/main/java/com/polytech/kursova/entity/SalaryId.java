package com.polytech.kursova.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class SalaryId implements Serializable {
    private static final long serialVersionUID = 1880387779839073648L;
    @Column(name = "SalaryID", nullable = false)
    private Integer salaryID;
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeID;

    @Override
    public int hashCode() {
        return Objects.hash(employeeID, salaryID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SalaryId entity = (SalaryId) o;
        return Objects.equals(this.employeeID, entity.employeeID) &&
                Objects.equals(this.salaryID, entity.salaryID);
    }
}