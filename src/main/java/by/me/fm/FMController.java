package by.me.fm;

import by.me.fm.controllers.Reader;
import by.me.fm.controllers.Remover;
import by.me.fm.controllers.Saver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import static by.me.fm.FMApplication.stage;

public class FMController implements Initializable{
    @FXML
    TextArea textArea;
    @FXML
    private Label lblInfo;

    FileChooser fileChooser;
    private boolean fileOpened;
    private final Saver saver = new Saver();
    private final Reader reader = new Reader();
    private final Remover remover = new Remover();

    String tempFile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setDisable(true);
        fileOpened = false;
        fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Text files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
    }
    @FXML
    protected void onCreateBtnClick() {
       if(fileOpened){
           onSaveBtnClick();
       }
           textArea.setDisable(false);
           fileOpened = true;
    }
    @FXML
    protected void onEditBtnClick() {
        fileOpened = true;
        String data = getData();
        textArea.setDisable(false);
        textArea.setText(data);
        lblInfo.setText("Файл:" + tempFile);
    }
    @FXML
    protected void onSaveBtnClick() {
        if(tempFile == null) {
            File file = fileChooser.showSaveDialog(stage);
            tempFile = file.getAbsolutePath();
        }
        String editedText = textArea.getText();
        if(!saver.saveFile(tempFile,editedText)){
            System.out.println("File not saved!\n Filepath: " + tempFile);

        }else {
            clearText();
            textArea.setDisable(true);
            fileOpened = false;
            lblInfo.setText("Файл не выбран");
            tempFile = null;
            System.out.println("File saved!");
        }
    }
    @FXML
    protected void onRemoveBtnClick() {
        if(tempFile != null){
            clearText();
            textArea.setDisable(true);
            fileOpened = false;
            lblInfo.setText("Файл не выбран");

        }else{
            File file = fileChooser.showOpenDialog(stage);
            tempFile = file.getAbsolutePath();
        }
        remover.remove(tempFile);
        tempFile = null;
    }

    protected String getData(){
        String data;
        File file = fileChooser.showOpenDialog(stage);
        if(file != null) {
            data = reader.openFile(file);
            tempFile = file.getAbsolutePath();
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