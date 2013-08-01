package com.jgoodies.binding.tutorial;

import com.jgoodies.binding.value.AbstractConverter;
import com.jgoodies.binding.value.ValueModel;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created with IntelliJ IDEA.
 * User: ddogaru
 * Date: 01/08/13
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class IsNotNullConverter extends AbstractConverter {
    public IsNotNullConverter(ValueModel valueModel) {
        super(valueModel);
    }
    @Override
    public Object convertFromSubject(Object subjectValue) {
        return subjectValue != null;
    }
    public void setValue(Object newValue) {
        subject.setValue(new Boolean(newValue != null));
    }
}
