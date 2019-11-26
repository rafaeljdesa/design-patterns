package solid.ocp.ey.right;

interface ReportUtils {
    void print();
}

abstract class Report implements ReportUtils {}

class ReportPDF extends Report  {

    @Override
    public void print() {/*...*/}
}

class ReportXLSX extends Report implements ReportUtils {

    @Override
    public void print() {/*...*/}
}

class ReportPrinter {

    Report report;

    public ReportPrinter(Report report) {
        this.report = report;
    }

    public void print() {
        report.print();
    }
}

