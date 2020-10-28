package com.barcode.app;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barcode.app.entities.Product;
import com.barcode.app.entities.Provider;
import com.barcode.app.services.ProductService;
import com.barcode.app.services.ProviderService;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class ControllerProduct implements Initializable {

	@FXML
	private TextField txtFieldName;

	@Autowired
	private ProductService serviceProduct;

	@Autowired
	private ProviderService serviceProvider;

	@FXML
	private ComboBox<String> comboBoxProviders;

	@FXML
	private Text txtMsm;

	private List<String> items;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// Charge Items
		items = new ArrayList<>();
		for (int i = 0; i < serviceProvider.getAll().size(); i++) {
			items.add(serviceProvider.getAll().get(i).getIdProvider() + " - "
					+ serviceProvider.getAll().get(i).getName());
		}
		comboBoxProviders.setItems(FXCollections.observableArrayList(items));
	}

	@FXML
	public void onSave() {
		Product newProduct = new Product();
		newProduct.setName(txtFieldName.getText());
		for (int i = 0; i < serviceProvider.getAll().size(); i++) {
			Provider provider = serviceProvider.getAll().get(i);
			if (provider.getIdProvider() == Long.parseLong(comboBoxProviders.getValue().split("-")[0].trim())) {
				newProduct.setProvider(provider);
			}
		}
		if (serviceProduct.add(newProduct)) {
			txtMsm.setText("Producto creado");
			txtFieldName.setText("");
			comboBoxProviders.setItems(null);
			comboBoxProviders.setItems(FXCollections.observableArrayList(items));
		} else {
			txtMsm.setText("Error al crear producto");
		}
	}
}
