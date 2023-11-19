package by.me.fm.controllers;

import by.me.fm.logic.FileLogicImpl;
import by.me.fm.logic.LogicException;
import by.me.fm.logic.LogicProvider;
import javafx.stage.FileChooser;

import java.io.File;


public class Saver {
    private final LogicProvider logicProvider = LogicProvider.getINSTANCE();
    private final FileLogicImpl logic = logicProvider.getFileLogic();
    public Saver() {
    }
    public boolean saveFile(String fileName, String text){
        if (!fileName.isEmpty()) {
            try {
                File f = new File(fileName);
                if(!f.exists()){
                    logic.creatFile(fileName);
                }
                return logic.updateFile(fileName, text);
            } catch (LogicException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}