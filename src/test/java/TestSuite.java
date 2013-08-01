import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.tutorial.Contact;
import com.jgoodies.binding.tutorial.IntegerAsStringConverter;
import com.jgoodies.binding.tutorial.LineItem;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import org.junit.Test;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class TestSuite {

    @Test
    public void testValueHolderBehaviour(){
        ValueHolder holder = new ValueHolder();
        holder.setValue("Old");
        PropertyChangeListener listener = mock(PropertyChangeListener.class);
        holder.addPropertyChangeListener(listener);
        holder.setValue("New");
        verify(listener).propertyChange(any(PropertyChangeEvent.class));
    }

    @Test
    public void testPropertyAdapter(){
        Contact contact = new Contact("Felix","The house cat");
        ValueModel firstNameModel =
                new PropertyAdapter(contact, "firstName");
        assertEquals("Felix", firstNameModel.getValue());
        firstNameModel.setValue("Holden");
        assertEquals("Holden", contact.getFirstName());
    }

    @Test
    public void testAdaptingAndConvertingAProperty(){
        LineItem lineItem = new LineItem();
        ValueModel quantityModel =
                new PropertyAdapter(lineItem, "quantity");
        ValueModel quantityStringValue =
                new IntegerAsStringConverter(quantityModel);
        lineItem.setQuantity(14);
        assertEquals(14, quantityModel.getValue());
        assertEquals("14", quantityStringValue.getValue());
        quantityStringValue.setValue("17");
        assertEquals(17, lineItem.getQuantity());

    }

    @Test
    public void testPropertyConnector(){
        Contact felix = new Contact("Felix", "Leipold");
        Contact holden = new Contact("Holden", "Caulfield");
        PropertyConnector.connect(felix, "firstName", holden, "secondName");
        assertEquals("Holden", holden.getFirstName());
        felix.setFirstName("Holden");
        assertEquals("Holden", holden.getSecondName());
        holden.setFirstName("Felix");
        assertEquals("Holden", felix.getFirstName());
    }

    @Test
    public void testPresentationModel(){
        Contact contact = new Contact("Felix", "Leipold");
        PresentationModel contactModel = new PresentationModel(contact);
        ValueModel firstName = contactModel.getModel("firstName");
        ValueModel lastName = contactModel.getModel("secondName");
        assertEquals("Felix", firstName.getValue());
        assertEquals("Leipold", lastName.getValue());
    }

    @Test
    public void testBeanChannel(){
        Contact felix = new Contact("Felix", "Leipold");
        Contact holden = new Contact("Holden", "Caulfield");
        ValueModel contactChannel = new ValueHolder();
        ((ValueHolder)contactChannel).setIdentityCheckEnabled(true);
        contactChannel.setValue(felix);
        PresentationModel contactModel =
                new PresentationModel(contactChannel);
        ValueModel firstName = contactModel.getModel("firstName");
        ValueModel lastName = contactModel.getModel("secondName");
        assertEquals("Felix", firstName.getValue());

        assertEquals("Leipold", lastName.getValue());
        contactChannel.setValue(holden);
        assertEquals("Holden", firstName.getValue());
        assertEquals("Caulfield", lastName.getValue());
    }

    @Test
    public void testComponentValueModel(){
        Contact contact = new Contact("Felix", "Leipold");
        PresentationModel contactModel =
                new PresentationModel(contact);
        ComponentValueModel firstName =
                contactModel.getComponentModel("firstName");
        JTextField nameField =
                BasicComponentFactory.createTextField(firstName);
        assertEquals("Felix", nameField.getText());
        firstName.setEditable(false);
        assertFalse(nameField.isEditable());
    }


}
