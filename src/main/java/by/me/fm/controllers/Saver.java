package by.me.fm.controllers;

import by.me.fm.logic.FileLogicImpl;
import by.me.fm.logic.LogicException;
import by.me.fm.logic.LogicProvider;


public class Saver {
    private final LogicProvider logicProvider = LogicProvider.getINSTANCE();
    private final FileLogicImpl logic = logicProvider.getFileLogic();
    public Saver() {
    }
    public boolean saveFile(String fileName, String text) {

        try {
            logic.creatFile(fileName);
            logic.updateFile(fileName,text);

            return true;

        } catch (LogicException e) {
            throw new RuntimeException(e);
        }

    }
}