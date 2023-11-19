package by.me.fm.controllers;

import by.me.fm.logic.FileLogicImpl;
import by.me.fm.logic.LogicException;
import by.me.fm.logic.LogicProvider;

import java.io.File;

public class Reader {
    private final LogicProvider logicProvider = LogicProvider.getINSTANCE();
    private final FileLogicImpl logic = logicProvider.getFileLogic();

    public Reader() {
    }
    public String openFile(File file){
        try {
           return logic.readFile(file);
        } catch (LogicException e) {
            throw new RuntimeException(e);
        }
    }
}