package by.me.fm.dao;

import java.io.File;

public interface FileDao {
    boolean create(String fileName) throws DaoException;
    boolean update(String fileName,String data) throws DaoException;
    boolean delete(String filename) throws DaoException;
    String raed(File fileName) throws DaoException;
}