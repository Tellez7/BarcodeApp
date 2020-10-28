package com.barcode.app;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.barcode.app.entities.BarCode;
import com.barcode.app.entities.Product;
import com.barcode.app.entities.Provider;
import com.barcode.app.services.BarCodeService;
import com.barcode.app.services.ProductService;
import com.barcode.app.services.ProviderService;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

@Component
public class ControllerHome implements Initializable {

	@Autowired
	private ProviderService serviceProvider;

	@Autowired
	private ProductService serviceProduct;

	@Autowired
	private BarCodeService serviceBarcode;

	@FXML
	private Label lblTitle;

	@FXML
	private Text textProduct;

	@FXML
	private Text textProvider;

	@FXML
	private TextField txtFieldSearch;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	public void onSearch() {
		List<Provider> providers = serviceProvider.getAll();
		for (int i = 0; i < providers.size(); i++) {
			List<Product> products = serviceProduct.getAll();
			for (int j = 0; j < products.size(); j++) {
				List<BarCode> barcodes = serviceBarcode.getAll();
				for (int k = 0; k < barcodes.size(); k++) {
					if (txtFieldSearch.getText().equals(barcodes.get(k).getBarcode())) {
						textProduct.setText("Producto : " + products.get(j).getName());
						textProvider.setText("Proveedor: " + providers.get(i).getName());
					} else {
						textProduct.setText("Producto: ");
						textProvider.setText("Proveedor: ");
					}
				}
			}
		}
	}

	@FXML
	public void btnProvider() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Provider.fxml"));
			loader.setControllerFactory(BarCodeApplication.appContext::getBean);
			Scene scene = new Scene(loader.load(), 400, 400);
			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void btnProduct() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Product.fxml"));
			loader.setControllerFactory(BarCodeApplication.appContext::getBean);
			Scene scene = new Scene(loader.load(), 400, 400);
			Stage newWindow = new Stage();
			newWindow.setScene(scene);
			newWindow.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
