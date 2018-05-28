package edu.pucmm.grails;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by aluis on 5/27/18.
 */
@Push
@Theme("valo")
@Widgetset("AppWidgetSet")
@SpringUI(path = "/")
public class AppUI extends UI {

    private VerticalLayout mainLayout = new VerticalLayout();

    @Override
    protected void init(VaadinRequest request) {
        Button btnHello = new Button("Hello");
        btnHello.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Notification.show("Hola", "Vaadin on Grails", Notification.Type.HUMANIZED_MESSAGE);
            }
        });
        mainLayout.addComponent(btnHello);
        setContent(mainLayout);
    }
}
