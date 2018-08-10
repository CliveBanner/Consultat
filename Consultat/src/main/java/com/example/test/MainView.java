package com.example.test;

import com.example.test.DummyBackend.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles/shared-styles.html")
@Route("")
public class MainView extends VerticalLayout {
	//
	private CustomerService service;
	private Grid<Customer> grid;
	// 
	private TextField filterText;
	private Button clearFilterTextBtn;
	//
	private CustomerForm form = new CustomerForm(this);
	
    public MainView() {
    	service = CustomerService.getInstance();
    	
    	grid = new Grid<>();
        grid.setSizeFull();
        grid.addColumn(Customer::getFirstName).setHeader("First Name");
        grid.addColumn(Customer::getLastName).setHeader("Last Name");
        grid.addColumn(Customer::getStatus).setHeader("Status");
        grid.asSingleSelect().addValueChangeListener(event -> {
            form.setCustomer(event.getValue());
        });
        
        filterText = new TextField();
        filterText.setPlaceholder("Filter by name ...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());
        
        clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearFilterTextBtn.addClickListener(e -> filterText.clear());
        
        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });
        
        HorizontalLayout filtering = new HorizontalLayout(filterText, clearFilterTextBtn);
        HorizontalLayout toolbar = new HorizontalLayout(filtering,
        	    addCustomerBtn);
        
        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        add(toolbar, main);
        setHeight("100vh");
        updateList();
    }
    
    public void updateList() {
    	grid.setItems(service.findAll(filterText.getValue()));
    }
}
