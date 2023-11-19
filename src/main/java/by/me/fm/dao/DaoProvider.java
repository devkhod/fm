package by.me.fm.dao;

public final class DaoProvider {
    private static final DaoProvider INSTANCE = new DaoProvider();
    private final FileDaoImpl fileDao = new FileDaoImpl();

    public FileDaoImpl getFileDao() {
        return fileDao;
    }

    public static DaoProvider getINSTANCE() {
        return INSTANCE;
    }
}