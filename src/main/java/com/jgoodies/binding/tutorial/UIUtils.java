package com.jgoodies.binding.tutorial;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.*;

public class UIUtils {


    public static void showInFrame(JPanel pane){
        showInFrame(pane, "Test");
    }

    public static void showInFrame(JPanel pane, String title) {
        final JFrame frame=new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(pane);
        frame.pack();
        frame.setVisible(true);
        locateOnScreenCenter(frame);
    }

    /**
      * Locates the given component on the screen's center.
      *
      * @param component the component to be centered
      */
     public static void locateOnScreenCenter(Component component) {
         Dimension paneSize = component.getSize();
         Dimension screenSize = component.getToolkit().getScreenSize();
         component.setLocation(
                 (screenSize.width - paneSize.width) / 2,
                 (screenSize.height - paneSize.height) / 2);
     }



    public static DefaultFormBuilder singleColumnFormBuilder() {
        return new DefaultFormBuilder(new FormLayout("right:p, 4dlu, 100dlu:grow"));
    }


}
