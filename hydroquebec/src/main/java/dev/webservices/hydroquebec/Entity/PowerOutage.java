package dev.webservices.hydroquebec.Entity;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import dev.webservices.addresses.Entity.Address;
import dev.webservices.employeelib.Entity.Employee;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PowerOutage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Multiple employees associated with a single power outage
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> employee;

    private Date startDate;
    private Time startTime;
    private Date updatedDate;
    private Time updatedTime;

    // Multiple power outages can occur at the same address,
    // but each power outage is associated with a specific address
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;

    private String status;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Time getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Time updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "PowerOutage [id=" + id + ", employee=" + employee + ", startDate=" + startDate + ", startTime="
                + startTime + ", updatedDate=" + updatedDate + ", updatedTime=" + updatedTime + ", address=" + address
                + ", status=" + status + ", description=" + description + "]";
    }

}
