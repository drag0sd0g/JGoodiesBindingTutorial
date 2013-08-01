package com.jgoodies.binding.tutorial;

import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.common.collect.ObservableList;

import javax.swing.*;

public class ContactManager {
    private ObservableList<Contact> contacts;
    public ContactManager() {
        contacts = new ArrayListModel<Contact>();
    }
    public Contact createNewContact(){
        Contact contact = new Contact();
        contacts.add(contact);
        return contact;
    }
    public ListModel getContacts(){
        return contacts;
    }
    public void removeContact(Contact contact){
        contacts.remove(contact);
    }
}