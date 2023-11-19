package by.me.fm.logic;

public final class LogicProvider {
    private static final LogicProvider INSTANCE = new LogicProvider();
    private final FileLogicImpl fileLogic = new FileLogicImpl();

    public static LogicProvider getINSTANCE() {
        return INSTANCE;
    }

    public FileLogicImpl getFileLogic() {
        return fileLogic;
    }
}