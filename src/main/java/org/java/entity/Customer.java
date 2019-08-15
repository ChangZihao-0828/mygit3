package org.java.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customer_id;
    private String customer_name;
    private String customer_shortName;
    private Integer customer_vocation_id;
    private String customer_contacts;
    private Integer customer_creditIimit;
    private String customer_pwd;

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_shortName() {
        return customer_shortName;
    }

    public void setCustomer_shortName(String customer_shortName) {
        this.customer_shortName = customer_shortName;
    }

    public Integer getCustomer_vocation_id() {
        return customer_vocation_id;
    }

    public void setCustomer_vocation_id(Integer customer_vocation_id) {
        this.customer_vocation_id = customer_vocation_id;
    }

    public String getCustomer_contacts() {
        return customer_contacts;
    }

    public void setCustomer_contacts(String customer_contacts) {
        this.customer_contacts = customer_contacts;
    }

    public Integer getCustomer_creditIimit() {
        return customer_creditIimit;
    }

    public void setCustomer_creditIimit(Integer customer_creditIimit) {
        this.customer_creditIimit = customer_creditIimit;
    }

    public String getCustomer_pwd() {
        return customer_pwd;
    }

    public void setCustomer_pwd(String customer_pwd) {
        this.customer_pwd = customer_pwd;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public Integer getCustomer_telephone() {
        return customer_telephone;
    }

    public void setCustomer_telephone(Integer customer_telephone) {
        this.customer_telephone = customer_telephone;
    }

    private String customer_email;
    private String customer_address;
    private Integer customer_telephone;

    @Override
    public String toString() {
        return "Info{" +
                "customer_id=" + customer_id +
                ", customer_shortName='" + customer_shortName + '\'' +
                ", customer_vocation_id='" + customer_vocation_id + '\'' +
                ", customer_contacts='" + customer_contacts + '\'' +
                ", customer_creditIimit=" + customer_creditIimit +
                '}';
    }
}
