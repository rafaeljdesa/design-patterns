package solid.ocp.ey.wrong;

enum ReportType {
    XLSX, PDF
}

class Report {
    public ReportType type;
}

class ReportPrinter {

    Report report;

    public ReportPrinter(Report report) {
        this.report = report;
    }

    public void print() {

        if (report.type == ReportType.PDF ) {

            printToPDF();

        } else if (report.type == ReportType.XLSX) {

            printToXLSX();

        }

    }

    public void printToPDF() {/*...*/}
    public void printToXLSX() {/*...*/}
}

