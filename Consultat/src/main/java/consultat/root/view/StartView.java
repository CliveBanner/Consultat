package consultat.root.view;

import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import consultat.root.dummybackend.Customer;
import consultat.root.dummybackend.CustomerService;
import consultat.root.view.form.SearchForm;

@HtmlImport("styles/shared-styles.html")
@Route("")
public class StartView extends VerticalLayout {
	//
	CustomerService service = CustomerService.getInstance();
	//
	Grid<Customer> grid = new Grid<>();
	//
	private SearchForm searchForm = new SearchForm(this);
	
	public StartView() {
		
		grid.setSizeFull();
		grid.addColumn(Customer::getBusiness).setHeader("Branche");
		grid.addColumn(Customer::getName).setHeader("Name");
		grid.addColumn(Customer::getAdress).setHeader("Adresse");
		
		add(searchForm);
		
		add(grid);
		setHeight("100vh");
		updateList();
	}
	
	public void updateList() {
		grid.setItems(service.findAll(searchForm.getToSearch()));
	}
}
