package structural.adapter.ey;

import java.util.ArrayList;
import java.util.List;

class Row {}

class Sheet {
    public List<Row> rows;
}

class XLSXFile {
    public List<Sheet> sheets;
}

class XLSXFileV2 {
    public List<Sheet> sheets;
}

interface XLSXGenerator {
    void createFile();
    Sheet createSheet();
    Row createRow();
    XLSXFile saveAndClose();
}

interface XLSXGeneratorV2 {
    Sheet createSheet();
    Row createRow();
    XLSXFileV2 saveAndClose();
}

class XLSXGeneratorAdapter implements XLSXGenerator {

    private XLSXGeneratorV2 xlsxGeneratorV2;
    private List<Sheet> sheets = new ArrayList<>();

    public XLSXGeneratorAdapter() {
    }

    public XLSXGeneratorAdapter(XLSXGeneratorV2 xlsxGeneratorV2) {
        this.xlsxGeneratorV2 = xlsxGeneratorV2;
    }

    @Override
    public void createFile() {
        System.out.println("Method was removed in v2");
    }

    @Override
    public Sheet createSheet() {
        Sheet sheet = xlsxGeneratorV2.createSheet();
        sheets.add(sheet);
        return sheet;
    }

    @Override
    public Row createRow() {
        return xlsxGeneratorV2.createRow();
    }

    @Override
    public XLSXFile saveAndClose() {
        xlsxGeneratorV2.saveAndClose();
        XLSXFile oldFile = new XLSXFile();
        oldFile.sheets = sheets;
        return oldFile;
    }
}

class DemoAdapter {

    public static void main(String[] args) {
        XLSXGeneratorAdapter adapter = new XLSXGeneratorAdapter();
        adapter.createFile();
        adapter.createSheet();
        adapter.createRow();
        XLSXFile file = adapter.saveAndClose();
    }
}