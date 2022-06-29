package gui;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Funcionario;
import model.exceptions.ValidationException;
import model.services.FuncionarioService;

public class FuncionarioFormController implements Initializable {
	
	private FuncionarioService service;
	
	private Funcionario entity;
	
	@FXML
	private TextField txtEmail;
	
	@FXML 
	private TextField txtName;
	
	@FXML
	private TextField txtArea;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Label labelErrorEmail;
	
	@FXML
	private Label labelErrorArea;
	
	@FXML 
	private Button btSave;
	
	@FXML 
	private Button btCancel;
	
	public void setFuncionario(Funcionario entity) {
		this.entity = entity;
	}
	
	public void setFuncionarioService(FuncionarioService service) {
		this.service = service;
	}
	
	public FuncionarioService getFuncionarioService() {
		return service;
	}
	
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity is null!");
		}
		
		if(service == null) {
			throw new IllegalStateException("Service is null");
		}
		
		if(labelErrorName != null) {
			labelErrorName.setText(null);
		}
		
		if(labelErrorEmail != null) {
			labelErrorEmail.setText(null);
		}
		
		if(labelErrorArea != null) {
			labelErrorArea.setText(null);
		}
		
		try {
			entity = getFormData(); //pega os dados dos TextField e seta os atributos de entity com esses dados(inverso de updateFormData()).
			service.saveOrUpdate(entity); //implementar!!!
			Utils.currentStage(event).close(); //fecha a tela.
		} catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		}
	}

	private Funcionario getFormData() {
		Funcionario obj = new Funcionario();
		
		ValidationException exception = new ValidationException("Erro de validação");
		
		if(txtName.getText() == null || txtName.getText().trim().equals(" ")) {
			exception.addError("name", " Field can't be empty");
		}
		obj.setName(txtName.getText());
		
		if(txtEmail.getText() == null || txtEmail.getText().trim().equals(" ")) {
			exception.addError("email", " Field can't be empty");
		}
		obj.setEmail(txtEmail.getText());
		
		if(txtArea.getText() == null || txtArea.getText().trim().equals(" ")) {
			exception.addError("area", " Field can't be empty");
		}
		obj.setArea(txtArea.getText());
		
		if(exception.getErrors().size() > 0) {
			throw exception;
		}
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}
	
	private void InitializeNodes() {
		Constraints.setTextFieldMaxLength(txtEmail, 40);
		Constraints.setTextFieldMaxLength(txtName, 40);
	}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity is null!");
		}
		txtEmail.setText(entity.getEmail());
		txtName.setText(entity.getName());
		txtArea.setText(entity.getArea());
	}
	
	private void setErrorMessages(Map<String, String> errors) { 
		Set<String> fields = errors.keySet();
		
		if(fields.contains("name")) {
			labelErrorName.setText(errors.get("name"));
		}
		
		if(fields.contains("email")) {
			labelErrorEmail.setText(errors.get("email"));
		}
		
		if(fields.contains("area")) {
			labelErrorArea.setText(errors.get("area"));
		}
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		InitializeNodes();
	}

}
