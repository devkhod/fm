package by.me.fm.logic;

import java.io.File;

public interface AppLogic {
    boolean creatFile(String fileName) throws LogicException;
    boolean updateFile(String fileName, String data) throws LogicException;
    boolean removeFile(String fileName) throws LogicException;
    String readFile(File fileName) throws LogicException;
}