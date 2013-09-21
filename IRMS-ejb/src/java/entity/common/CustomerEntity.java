/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.common;

import java.io.Serializable;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import entity.accommodation.*;
import java.util.ArrayList;
import javax.persistence.Column;

/**
 *
 * @author sunjunfan
 */
@Entity(name = "Customer")
public class CustomerEntity implements Serializable {

    @Id
    private Long customerId;
    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;
    private String account;
    private String passport;
    private String password;
    private Boolean memberStatus;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "customer")
    private Collection<RoomReservationEntity> reservations = new ArrayList<RoomReservationEntity>();
    @OneToMany(cascade = {CascadeType.ALL})
    private Collection<RoomServiceRecordEntity> serviceRecord = new ArrayList<RoomServiceRecordEntity>();
    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "customer")

    private Collection<TransactionEntity> transactions = new ArrayList<TransactionEntity>();
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "customer")
    private Collection< RoomEntity> rooms = new ArrayList<RoomEntity>();

    public CustomerEntity() {
        setCustomerId(System.nanoTime());
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(Boolean memberStatus) {
        this.memberStatus = memberStatus;
    }

    public Collection<RoomReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(Collection<RoomReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public Collection<RoomServiceRecordEntity> getServiceRecord() {
        return serviceRecord;
    }

    public void setServiceRecord(Collection<RoomServiceRecordEntity> serviceRecord) {
        this.serviceRecord = serviceRecord;
    }



    public Collection<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Collection<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public Collection<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<RoomEntity> rooms) {
        this.rooms = rooms;
    }

    
   
}
