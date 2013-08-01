package com.jgoodies.binding.tutorial;

/**
 * Created with IntelliJ IDEA.
 * User: ddogaru
 * Date: 01/08/13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class Driver {

    public static void main(String[] args){
        ContactManagerUI ui =
                new ContactManagerUI(
                        new ContactManagerPresentation(
                                new ContactManager()));
        UIUtils.showInFrame(ui.getPanel(), "Contact Manager");
    }
}
