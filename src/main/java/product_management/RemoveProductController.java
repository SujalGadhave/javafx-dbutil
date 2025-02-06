package product_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import common.DBUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RemoveProductController extends DBUtil {
	
	@FXML
	private TextField removeProduct;
		
	@FXML
    private Label errorMessage;
		
	public void removeProduct() throws SQLException {
		
		String query = "DELETE FROM ecomlogin.product WHERE productname = '" + removeProduct.getText() + "'";
		
		DBUtil.executeQuery(query);
		
		if((removeProduct.getText() != null)) {
			
			errorMessage.setTextFill(Color.GREEN);
			errorMessage.setText("Product removed...");
		}else {
			errorMessage.setTextFill(Color.RED);
			errorMessage.setText("Something went wrong...");
		}
	}
	
	public void back() {
		new MenuProductScreen().show();
	}
}
