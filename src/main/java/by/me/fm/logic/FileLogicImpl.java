package by.me.fm.logic;

import by.me.fm.dao.DaoException;
import by.me.fm.dao.DaoProvider;
import by.me.fm.dao.FileDaoImpl;

import java.io.File;

public class FileLogicImpl implements AppLogic{
    private final DaoProvider dp = DaoProvider.getINSTANCE();
    private final FileDaoImpl fileDao = dp.getFileDao();
    @Override
    public boolean creatFile(String fileName) throws LogicException {
        try {
            return fileDao.create(fileName);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public boolean updateFile(String fileName, String data) throws LogicException {
        try {
            return fileDao.update(fileName,data);
        } catch (DaoException e) {
            throw new LogicException(e);
        }

    }

    @Override
    public boolean removeFile(String fileName) throws LogicException {
        try {
            return fileDao.delete(fileName);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public String readFile(File fileName) throws LogicException {
        try {
            return fileDao.raed(fileName);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }
}