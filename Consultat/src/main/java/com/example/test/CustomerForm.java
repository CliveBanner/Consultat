package com.example.test;

import com.example.test.DummyBackend.Customer;
import com.example.test.DummyBackend.CustomerService;
import com.example.test.DummyBackend.CustomerStatus;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CustomerForm extends FormLayout{
	private CustomerService service = CustomerService.getInstance();
	private Binder<Customer> binder = new Binder<>(Customer.class);
	private Customer customer;
	private MainView view;
	//Components
	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private ComboBox<CustomerStatus> status = new ComboBox<>();
	private Button save = new Button("Save");
	private Button delete = new Button("Delete");
	
	public CustomerForm(MainView view) {
		//
		this.view = view;
		//
		binder.bindInstanceFields(this);
		//
		HorizontalLayout buttons = new HorizontalLayout(save, delete);
		//
		status.setItems(CustomerStatus.values());
		//
		save.getElement().setAttribute("theme", "primary");
		save.addClickListener(e -> save());
		//
		delete.addClickListener(e -> delete());
		//
		add(firstName, lastName, status, buttons);
		//
		setCustomer(null);
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		binder.setBean(customer);
		boolean enabled = customer != null;
		save.setEnabled(enabled);
		delete.setEnabled(enabled);
		if(enabled) {
			firstName.focus();
		}
	}
	
	private void delete() {
	    service.delete(customer);
	    view.updateList();
	    setCustomer(null);
	}

	private void save() {
	    service.save(customer);
	    view.updateList();
	    setCustomer(null);
	}
	
}
