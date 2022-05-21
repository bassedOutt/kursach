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
public class PaymentId implements Serializable {
    private static final long serialVersionUID = 1542591605697483608L;
    @Column(name = "CustomerID", nullable = false)
    private Integer customerID;
    @Column(name = "PaymentID", nullable = false)
    private Integer paymentID;

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, customerID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PaymentId entity = (PaymentId) o;
        return Objects.equals(this.paymentID, entity.paymentID) &&
                Objects.equals(this.customerID, entity.customerID);
    }
}