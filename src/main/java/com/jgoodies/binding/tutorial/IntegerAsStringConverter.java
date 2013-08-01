package com.jgoodies.binding.tutorial;

import com.jgoodies.binding.value.AbstractConverter;
import com.jgoodies.binding.value.ValueModel;

public class IntegerAsStringConverter extends AbstractConverter {
        public IntegerAsStringConverter(ValueModel valueModel) {
            super(valueModel);
        }
        @Override
        public Object convertFromSubject(Object subjectValue) {
            return subjectValue.toString();
        }
        public void setValue(Object newValue) {
            subject.setValue(Integer.parseInt((String) newValue));
        }
    }