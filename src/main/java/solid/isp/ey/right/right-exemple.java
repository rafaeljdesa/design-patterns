package solid.isp.ey.right;

class Document {}

interface PrinterUtils {
    void print(Document document);
}

interface ScannerUtils {
    void scan(Document document);
}

interface MultifunctionalUtils extends PrinterUtils, ScannerUtils {}

class Printer implements MultifunctionalUtils {

    @Override
    public void scan(Document document) {
        /*...*/
    }

    @Override
    public void print(Document document) {
        /*...*/
    }
}

class Scanner implements ScannerUtils {

    @Override
    public void scan(Document document) {
        /*...*/
    }
}

