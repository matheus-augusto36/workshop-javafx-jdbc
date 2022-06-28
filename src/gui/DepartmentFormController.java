package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import db.DbException;
import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {

	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	private DepartmentService service;
	
	private Department entity;
	
	@FXML
	private TextField txtId;
	
	@FXML 
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML 
	private Button btSave;
	
	@FXML 
	private Button btCancel;
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity is null!");
		}
		if(service == null) {
			throw new IllegalStateException("Service is null");
		}
		try {
			entity = getFormData(); //pega os dados dos TextField e seta os atributos de entity com esses dados(inverso de updateFormData()).
			service.saveOrUpdate(entity); //se o departamento ja existir, atualiza. Se n�o, cria um novo.
			notifyDataChangeListeners(); //avisa os "listeners"
			Utils.currentStage(event).close(); //fecha a tela.
		} catch (DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void notifyDataChangeListeners() {
		for(DataChangeListener listener: dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}

	private Department getFormData() {
		Department obj = new Department();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	private void InitializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity is null!");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		InitializeNodes();
	}

}
