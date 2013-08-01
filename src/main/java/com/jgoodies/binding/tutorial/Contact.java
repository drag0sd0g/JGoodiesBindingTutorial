package com.jgoodies.binding.tutorial;

import com.jgoodies.binding.beans.Model;

/**
 * Created with IntelliJ IDEA.
 * User: ddogaru
 * Date: 01/08/13
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */
public class Contact extends Model{

    private String firstName = "";
    private String secondName = "";
    private boolean fictional;

    public Contact() {
    }

    public Contact(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        String oldVal = this.firstName;
        this.firstName = firstName;
        firePropertyChange("firstName", oldVal, firstName);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        String oldVal = this.secondName;
        this.secondName = secondName;
        firePropertyChange("secondName", oldVal, secondName);
    }

    public boolean isFictional() {
        return fictional;
    }

    public void setFictional(boolean fictional) {
        this.fictional = fictional;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " " + fictional;
    }
}
