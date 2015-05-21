/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.taxiservice.api.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lasitha
 */
@Entity
@Table(name = "taxi_booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaxiBooking.findAll", query = "SELECT t FROM TaxiBooking t"),
    @NamedQuery(name = "TaxiBooking.findByBid", query = "SELECT t FROM TaxiBooking t WHERE t.bid = :bid"),
    @NamedQuery(name = "TaxiBooking.findByDate", query = "SELECT t FROM TaxiBooking t WHERE t.date = :date")})
public class TaxiBooking implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bid")
    private Long bid;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "cutomer_id", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Customer cutomerId;
    @JoinColumn(name = "taxi_id", referencedColumnName = "tid")
    @ManyToOne(optional = false)
    private Taxi taxiId;

    public TaxiBooking() {
        this.date = new Date();
    }

    public TaxiBooking(Long bid) {
        this.bid = bid;
    }

    public TaxiBooking(Long bid, Date date) {
        this.bid = bid;
        this.date = date;
    }

    public Long getBid() {
        return bid;
    }

    public void setBid(Long bid) {
        this.bid = bid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(Customer cutomerId) {
        this.cutomerId = cutomerId;
    }

    public Taxi getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Taxi taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bid != null ? bid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxiBooking)) {
            return false;
        }
        TaxiBooking other = (TaxiBooking) object;
        if ((this.bid == null && other.bid != null) || (this.bid != null && !this.bid.equals(other.bid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.taxiservice.api.dao.TaxiBooking[ bid=" + bid + " ]";
    }
    
}
