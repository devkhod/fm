package by.me.fm.dao;

import by.me.fm.utils.DataValidator;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;

public class FileDaoImpl implements FileDao{
    public FileDaoImpl() {
    }
    private final String DELIM = "\n";
    @Override
    public boolean create(String fileName) throws DaoException {
        if(DataValidator.validate(fileName)){
            try {
                File newFile = new File(fileName);
                if(newFile.createNewFile()) {
                    return true;
                }
            }catch(IOException e){
                throw new DaoException(e);
            }
        }
        return false;
    }

    @Override
    public boolean update(String fileName, String data) throws DaoException {
        if(DataValidator.validate(fileName) && DataValidator.validate(data)){
            try(OutputStream out = new FileOutputStream(fileName);
                OutputStreamWriter writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                BufferedWriter fr = new BufferedWriter(writer)) {

                fr.write(data);
            } catch (IOException e) {
                throw new DaoException(e);
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String fileName) throws DaoException {
        if(DataValidator.validate(fileName)){
            File file = new File(fileName);
            return file.delete();
        }
        return false;
    }

    @Override
    public String raed(File fileName) throws DaoException {
        if(fileName != null){
            String result;
            try (BufferedReader br = new BufferedReader(new FileReader(fileName.getPath()))){

                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine()) != null){
                    sb.append(line).append(DELIM);
                }
                result = sb.toString();
            } catch (IOException e) {
                throw new DaoException(e);
            }
            return result;
        }
        return null;
    }
}