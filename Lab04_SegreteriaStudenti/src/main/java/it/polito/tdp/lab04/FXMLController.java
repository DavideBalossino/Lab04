/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<Corso> boxCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private CheckBox check;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	txtResult.clear();
    	String matricolaS=txtMatricola.getText();
    	if(matricolaS.length()==0 || matricolaS==null)
    	{
    		txtResult.setText("Inserire una matricola");
    		check.setSelected(false);
    		return;
    	}
    	Integer matricola;
    	try {
    		matricola=Integer.parseInt(matricolaS);
    	} catch(NumberFormatException e) {
    		txtResult.setText("La matricola deve contenere numeri");
    		check.setSelected(false);
    		return;
    	}
    	
    	Studente s=model.getNomeDaMatricola(matricola);
    	if(s==null) {
    		txtResult.setText("Inserire una matricola esistente");
    		return;}
    	
    	StringBuilder sb=new StringBuilder();
    	for(Corso c:model.corsiMatricolaIscritta(matricola)) {
    		sb.append(String.format("%-8s ", c.getCodins()));
    		sb.append(String.format("%-3d ", c.getCrediti()));
    		sb.append(String.format("%-50s ", c.getNome() ));
    		sb.append(String.format("%-2d\n",c.getPeriodo() ));
    	} 
    	txtResult.appendText(sb.toString());
    	
    }

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	txtResult.clear();
    	Corso c=boxCorsi.getValue();
    	if(c==null || c.getCodins()==null) {
    		txtResult.setText("Selezionare un corso");
    		return;
    	}
    	StringBuilder sb=new StringBuilder();
    	for(Studente s:model.studentiIscrittiCorso(c)) {
    		sb.append(String.format("%-8d ", s.getMatricola()));
    		sb.append(String.format("%-40s ", s.getNome()));
    		sb.append(String.format("%-40s ", s.getCognome() ));
    		sb.append(String.format("%-8s\n",s.getCds() ));
    	}
    	if(model.studentiIscrittiCorso(c).size()==0) {
    		txtResult.appendText("Nessuno studente al corso");
    		return;
    	}
    	txtResult.appendText(sb.toString());
    }
    
    @FXML
    void doCheck(ActionEvent event) {
    	txtResult.clear();
    	String matricolaS=txtMatricola.getText();
    	if(matricolaS.length()==0 || matricolaS==null)
    	{
    		txtResult.setText("Inserire una matricola");
    		check.setSelected(false);
    		return;
    	}
    	Integer matricola;
    	try {
    		matricola=Integer.parseInt(matricolaS);
    	} catch(NumberFormatException e) {
    		txtResult.setText("La matricola deve contenere numeri");
    		check.setSelected(false);
    		return;
    	}
    	
    	Studente s=model.getNomeDaMatricola(matricola);
    	if(s==null) {
    		txtResult.setText("Inserire una matricola esistente");
    		check.setSelected(false);
    		return;
    	}
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    	
    //	Studente s=model.getNomeDaMatricola(matricola);
    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	txtResult.clear();
    	Corso c=boxCorsi.getValue();
    	if(c==null || c.getCodins()==null) {
    		txtResult.setText("Selezionare un corso");
    		return;
    	}
    	
    	String matricolaS=txtMatricola.getText();
    	if(matricolaS.length()==0 || matricolaS==null)
    	{
    		txtResult.setText("Inserire una matricola");
    		check.setSelected(false);
    		return;
    	}
    	Integer matricola;
    	try {
    		matricola=Integer.parseInt(matricolaS);
    	} catch(NumberFormatException e) {
    		txtResult.setText("La matricola deve contenere numeri");
    		check.setSelected(false);
    		return;
    	}
    	Studente s=model.getNomeDaMatricola(matricola);
    	if(s==null) {
    		txtResult.setText("Inserire una matricola esistente");
    		check.setSelected(false);
    		return;
    	}
    	
    	if(model.iscriviStudenteAlCorso(s, c)==true) {
    		txtResult.appendText("Matricola gia iscritta al corso");
    		return;
    	}
    	else {
    		txtResult.appendText("Matricola ora iscritta al corso");
    		return;
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	boxCorsi.setValue(null);
    	check.setSelected(false);
    	txtNome.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    }

    @FXML
    void initialize() {
        assert boxCorsi != null : "fx:id=\"boxCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert check != null : "fx:id=\"check\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model m) {
    	this.model=m;
    	boxCorsi.getItems().addAll(model.elencoCorsi());
    	boxCorsi.getItems().add(new Corso(null,null,null,null));
    	check.styleProperty().set("-fx-color:#11da2c");
    	txtResult.setStyle("-fx-font-family: monospace");
    }
}
