package by.me.fm.controllers;

import by.me.fm.logic.FileLogicImpl;
import by.me.fm.logic.LogicException;
import by.me.fm.logic.LogicProvider;

public class Remover {
    private final LogicProvider logicProvider = LogicProvider.getINSTANCE();
    private final FileLogicImpl logic = logicProvider.getFileLogic();
    public boolean remove(String fileName){
        try {
            return logic.removeFile(fileName);
        } catch (LogicException e) {
            throw new RuntimeException(e);
        }
    }
}