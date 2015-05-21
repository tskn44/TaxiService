/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.taxiservice.api.dao;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lasitha
 */
@Entity
@Table(name = "taxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taxi.findAll", query = "SELECT t FROM Taxi t"),
    @NamedQuery(name = "Taxi.findByTid", query = "SELECT t FROM Taxi t WHERE t.tid = :tid"),
    @NamedQuery(name = "Taxi.findByNumber", query = "SELECT t FROM Taxi t WHERE t.number = :number"),
    @NamedQuery(name = "Taxi.findBySeats", query = "SELECT t FROM Taxi t WHERE t.seats = :seats")})
public class Taxi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tid")
    private Long tid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "number")
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seats")
    private int seats;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxiId")
    private Collection<TaxiBooking> taxiBookingCollection;

    public Taxi() {
    }

    public Taxi(Long tid) {
        this.tid = tid;
    }

    public Taxi(Long tid, String number, int seats) {
        this.tid = tid;
        this.number = number;
        this.seats = seats;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @XmlTransient
    public Collection<TaxiBooking> getTaxiBookingCollection() {
        return taxiBookingCollection;
    }

    public void setTaxiBookingCollection(Collection<TaxiBooking> taxiBookingCollection) {
        this.taxiBookingCollection = taxiBookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tid != null ? tid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxi)) {
            return false;
        }
        Taxi other = (Taxi) object;
        if ((this.tid == null && other.tid != null) || (this.tid != null && !this.tid.equals(other.tid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.taxiservice.api.dao.Taxi[ tid=" + tid + " ]";
    }
    
}
