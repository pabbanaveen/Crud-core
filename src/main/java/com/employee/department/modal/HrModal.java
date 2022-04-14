package com.employee.department.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HrModal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "recruited")
    private long recruited;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fistName) {
        this.firstName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getRecruited() {
        return recruited;
    }

    public void setRecruited(long recruited) {
        this.recruited = recruited;
    }

    public HrModal() {
        super();
        // TODO Auto-generated constructor stub
    }

    public HrModal(long id, String fistName, String lastName, String email, String phone, long recruited) {
        super();
        this.id = id;
        this.firstName = fistName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.recruited = recruited;
    }

    @Override
    public String toString() {
        return "HrModal [id=" + id + ", fistName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + ", phone=" + phone + ", recruited=" + recruited + "]";
    }
    
    
}
