package edu.pucmm.grails;

import com.vaadin.ui.*;
import demograils.KoffeeService;
import edu.pucmm.grails.domain.Koffee;
import edu.pucmm.grails.utils.Grails;

import java.math.BigDecimal;

/**
 * Created by aluis on 6/1/18.
 */
public class NewKoffee extends Window {

    private TextField tfName = new TextField("Name");
    private TextArea taDescription = new TextArea("Description");
    private TextField tfPrice = new TextField("Price");

    private Button btnOK = new Button("OK");
    private Button btnCancel = new Button("Cancel");

    private Koffee koffee;

    public NewKoffee(Koffee koffee) {
        this.koffee = koffee;
        prepare();
    }

    public NewKoffee() {
        prepare();
    }

    private void prepare() {
        center();
        VerticalLayout main = new VerticalLayout();
        main.addComponent(tfName);
        main.addComponent(taDescription);
        main.addComponent(tfPrice);

        btnOK.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                if (koffee == null) {
                    koffee = new Koffee();
                }
                koffee.setName(tfName.getValue());
                koffee.setDescription(taDescription.getValue());
                koffee.setPrice(new BigDecimal(tfPrice.getValue()));
                Grails.get(KoffeeService.class).createKoffe(koffee);
                close();
            }
        });

        btnCancel.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                close();
            }
        });

        HorizontalLayout hlControls = new HorizontalLayout();
        hlControls.addComponent(btnOK);
        hlControls.addComponent(btnCancel);
        main.addComponent(hlControls);
        setContent(main);
    }
}
