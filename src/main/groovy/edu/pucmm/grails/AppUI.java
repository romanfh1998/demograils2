package edu.pucmm.grails;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.DataProviderListener;
import com.vaadin.data.provider.Query;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.Registration;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import demograils.KoffeeService;
import edu.pucmm.grails.domain.Koffee;
import edu.pucmm.grails.utils.Grails;
import grails.boot.GrailsApp;

import java.math.BigDecimal;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

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

        Grid<Koffee> grid = new Grid<>();

        DataProvider<Koffee, Object> provider = new DataProvider<Koffee, Object>() {
            @Override
            public boolean isInMemory() {
                return false;
            }

            @Override
            public int size(Query<Koffee, Object> query) {
                return Grails.get(KoffeeService.class).countKoffees();
            }

            @Override
            public Stream<Koffee> fetch(Query<Koffee, Object> query) {
                return Grails.get(KoffeeService.class).allKoffees().stream();
            }

            @Override
            public void refreshItem(Koffee item) {

            }

            @Override
            public void refreshAll() {

            }

            @Override
            public Registration addDataProviderListener(DataProviderListener<Koffee> listener) {
                return null;
            }
        };

        grid.setDataProvider(provider);

        grid.addColumn(Koffee::getName).setCaption("Name");
        grid.addColumn(Koffee::getDescription).setCaption("Description");
        grid.addColumn(Koffee::getPrice).setCaption("Price");

        Button btnAdd = new Button("Add");

        btnAdd.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                NewKoffee koffee = new NewKoffee();
                koffee.addCloseListener(new Window.CloseListener() {
                    @Override
                    public void windowClose(Window.CloseEvent e) {
                        grid.setDataProvider(provider);
                    }
                });
                getUI().addWindow(koffee);
            }
        });

        Button btnDelete = new Button("Delete");
        btnDelete.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                Set<Koffee> selectedItems = grid.getSelectedItems();
                selectedItems.forEach(new Consumer<Koffee>() {
                    @Override
                    public void accept(Koffee koffee) {
                        Grails.get(KoffeeService.class).remove(koffee);
                    }
                });
                grid.setDataProvider(provider);
            }
        });

        mainLayout.addComponent(btnDelete);
        mainLayout.addComponent(btnAdd);
        mainLayout.addComponent(grid);
        setContent(mainLayout);
    }
}
