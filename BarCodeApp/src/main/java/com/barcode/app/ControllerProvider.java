package com.barcode.app;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barcode.app.entities.Provider;
import com.barcode.app.services.ProviderService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

@Component
public class ControllerProvider implements Initializable {

	@FXML
	private TextField txtFieldName;

	@FXML
	private TextField txtFieldLastname;

	@FXML
	private TextField txtFieldPhone;

	@FXML
	private TextField txtFieldEmail;

	@FXML
	private TextField txtFieldDni;

	@FXML
	private Text txtMsm;

	@Autowired
	private ProviderService serviceProvider;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void onSave() {
		Provider newProvider = new Provider();
		newProvider.setName(txtFieldName.getText());
		newProvider.setLastname(txtFieldLastname.getText());
		newProvider.setPhone(txtFieldPhone.getText());
		newProvider.setEmail(txtFieldEmail.getText());
		newProvider.setDni(txtFieldDni.getText());
		if (serviceProvider.add(newProvider)) {
			txtMsm.setText("Proveedor creado");
			txtFieldName.setText("");
			txtFieldLastname.setText("");
			txtFieldPhone.setText("");
			txtFieldEmail.setText("");
			txtFieldDni.setText("");
		} else {
			txtMsm.setText("Error al crear Proveedor");
		}
	}
}
