package solid.isp.ey.wrong;

class Document {}

interface PrinterUtils {
    void scan(Document document);
    void print(Document document);
}

class Printer implements PrinterUtils {

    @Override
    public void scan(Document document) {
        /*...*/
    }

    @Override
    public void print(Document document) {
        /*...*/
    }
}

class Scanner implements PrinterUtils {

    @Override
    public void scan(Document document) {
        /*...*/
    }

    @Override
    public void print(Document document) {
        // Scanner not do this
    }
}

