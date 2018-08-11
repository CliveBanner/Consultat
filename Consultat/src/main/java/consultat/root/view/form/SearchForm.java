package consultat.root.view.form;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

import consultat.root.view.StartView;

public class SearchForm extends FormLayout {
	
	private TextField filterText = new TextField();
	private Button searchBtn = new Button("Suchen");
	private StartView view;
	
	public SearchForm(StartView view) {
		this.view = view;
		
		filterText.setPlaceholder("Suche nach Branche, Name, Adresse ...");
		filterText.setWidth("100vh");
		
		searchBtn.setSizeFull();
		searchBtn.setWidth("100vh");
		searchBtn.addClickListener(e -> view.updateList());
		
		HorizontalLayout layout = new HorizontalLayout();
		layout.add(filterText, searchBtn);
		
		add(layout);
	}
	
	public String getToSearch() {
		return filterText.getValue();
	}
}
