package com.jgoodies.binding.tutorial;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.ValueModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: ddogaru
 * Date: 01/08/13
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public class ContactManagerPresentation {


    private final ContactManager domain;
    private final SelectionInList<Contact> contactSelection;
    private ValueModel hasSelection;
    private final ComponentValueModel firstName;
    private final ComponentValueModel lastName;
    private final ComponentValueModel fictional;
    private final Action add;
    private final Action remove;

    public ContactManagerPresentation(ContactManager domain) {
        this.domain = domain;
        contactSelection =
                new SelectionInList(this.domain.getContacts());
        hasSelection = new IsNotNullConverter(contactSelection);
        PresentationModel contactAdapter =
                new PresentationModel(contactSelection);
        firstName = contactAdapter.getComponentModel("firstName");
        lastName = contactAdapter.getComponentModel("secondName");
        fictional = contactAdapter.getComponentModel("fictional");
        add = new AbstractAction("Add"){
            public void actionPerformed(ActionEvent e) {
                add();
            }
        };
        remove = new AbstractAction("Remove") {
            public void actionPerformed(ActionEvent e) {
                remove();
            }
        };
        PropertyConnector.connectAndUpdate(hasSelection, remove,
                "enabled");
    }
    private void remove() {
        if (contactSelection.getValue() == null){
            return;
        }
        domain.removeContact(contactSelection.getValue());
    }
    private void add() {
        Contact newContact = domain.createNewContact();
        contactSelection.setValue(newContact);
    }

    public ContactManager getDomain() {
        return domain;
    }

    public SelectionInList<Contact> getContactSelection() {
        return contactSelection;
    }

    public ValueModel getHasSelection() {
        return hasSelection;
    }

    public ComponentValueModel getFirstName() {
        return firstName;
    }

    public ComponentValueModel getLastName() {
        return lastName;
    }

    public ComponentValueModel getFictional() {
        return fictional;
    }

    public Action getAdd() {
        return add;
    }

    public Action getRemove() {
        return remove;
    }
}
