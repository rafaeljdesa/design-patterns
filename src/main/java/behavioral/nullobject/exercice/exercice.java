package behavioral.nullobject.exercice;

interface Log
{
    // max # of elements in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);
}

class Account
{
    private Log log;

    public Account(Log log)
    {
        this.log = log;
    }

    public void someOperation() throws Exception
    {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if (c+1 != log.getRecordCount())
            throw new Exception();
        if (log.getRecordCount() >= log.getRecordLimit())
            throw new Exception();
    }
}

class NullLog implements Log
{
    int count = 0;

    @Override
    public int getRecordLimit() {
        return count + 1;
    }

    @Override
    public int getRecordCount() {
        return ++count;
    }

    @Override
    public void logInfo(String message) {
        System.out.println(message);
    }
}