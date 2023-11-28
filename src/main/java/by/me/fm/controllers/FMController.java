package by.me.fm.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static by.me.fm.FMApplication.stage;

public class FMController implements Initializable{
    @FXML
    private TextArea textArea;
    @FXML
    private Label lblInfo;
    @FXML
    private Button createBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private Button removeBtn;
    private FileChooser fileChooser;
    private boolean fileOpened;
    private final Saver saver = new Saver();
    private final Reader reader = new Reader();
    private final Remover remover = new Remover();
    private final FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*" +
            ".txt");
    private String tempFile = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setDisable(true);
        fileOpened = false;
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extFilter);
        saveBtn.setDisable(true);
    }
    @FXML
    protected void onCreate() {
       if(fileOpened){
           onSave();
       }
        textArea.setDisable(false);
        lblInfo.setText("Новый файл");
        fileOpened = true;
        textArea.requestFocus();
        saveBtn.setDisable(false);
    }
    @FXML
    protected void onEdit() {
        fileOpened = true;
        String data = getData();
        textArea.setDisable(false);
        textArea.setText(data);

        if(tempFile != null) {
            lblInfo.setText("Файл:" + tempFile);
            saveBtn.setDisable(false);
        }else{
            lblInfo.setText("Файл не выбран");

        }
    }
    @FXML
    protected void onSave() {
        if(tempFile == null) {
            File file = fileChooser.showSaveDialog(stage);
            if(file != null) {
                tempFile = file.getAbsolutePath();
            }
        }
        String editedText = textArea.getText();
        if (!saver.saveFile(tempFile, editedText)) {
            lblInfo.setText("Файл не сохранен!");
        }else {
            clearText();
            textArea.setDisable(true);
            fileOpened = false;
            lblInfo.setText("Файл сохранен!");
            tempFile = null;
            saveBtn.setDisable(true);
        }
    }
    @FXML
    protected void onRemove() {
        if(tempFile == null){
            File file = fileChooser.showOpenDialog(stage);
            if(file !=null) {
                tempFile = file.getAbsolutePath();
            }else{
                clearText();
                textArea.setDisable(true);
                fileOpened = false;
                lblInfo.setText("Файл не выбран");
            }
        }
        if(remover.remove(tempFile)) {
            lblInfo.setText("Файл '" + tempFile + "' удален!");
            clearText();
            textArea.setDisable(true);
            tempFile = null;
            fileOpened = false;
            saveBtn.setDisable(true);
        }else{
            lblInfo.setText("Ошибка удаления!");
        }
    }

    protected String getData(){
        String data;
        tempFile = null;
        File ofile = fileChooser.showOpenDialog(stage);
        if(ofile != null) {
            data = reader.openFile(ofile);
            tempFile = ofile.getAbsolutePath();
            return data;
        }
        return null;
    }
    @FXML
    protected void clearText(){
        textArea.clear();
        textArea.requestFocus();
    }
}