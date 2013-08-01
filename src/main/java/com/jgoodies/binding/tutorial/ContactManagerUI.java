package com.jgoodies.binding.tutorial; /**
 * Created with IntelliJ IDEA.
 * User: ddogaru
 * Date: 01/08/13
 * Time: 15:48
 * To change this template use File | Settings | File Templates.
 */
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.factories.ButtonBarFactory;

import javax.swing.*;

import static com.jgoodies.binding.adapter.BasicComponentFactory.createCheckBox;
import static com.jgoodies.binding.adapter.BasicComponentFactory.createList;
import static com.jgoodies.binding.adapter.BasicComponentFactory.createTextField;

public class ContactManagerUI {

    private JList contactList;
    private JTextField firstName;
    private JTextField lastName;
    private JCheckBox fictional;
    private JButton add;
    private JButton remove;
    private JPanel panel;

    public ContactManagerUI(ContactManagerPresentation presenter) {
        contactList = createList(presenter.getContactSelection());
        firstName = createTextField(presenter.getFirstName());
        lastName = createTextField(presenter.getLastName());
        fictional = createCheckBox(presenter.getFictional(), "");

        add = new JButton(presenter.getAdd());
        remove = new JButton(presenter.getRemove());
        buildPanel();
    }
    private void buildPanel() {
        DefaultFormBuilder b = UIUtils.singleColumnFormBuilder();
        b.appendSeparator("Contacts");
        b.append(new JScrollPane(contactList), 3);
        b.append(ButtonBarFactory.buildAddRemoveBar(add, remove)
                , 3);
        b.appendSeparator("Detail");
        b.append("First name", firstName);
        b.append("Last name", lastName);
        b.append("Type", fictional);
        b.setDefaultDialogBorder();
        panel = b.getPanel();
    }

    public JPanel getPanel() {
        return panel;
    }
}
