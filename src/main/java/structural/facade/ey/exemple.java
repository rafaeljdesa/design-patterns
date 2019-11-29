package structural.facade.ey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface FileService {
    void saveFile(File file);
}

interface XLSXFacade {
    void generateBlankFile();
}

class XLSXFacadeImpl implements XLSXFacade{

    FileService fileService;

    public XLSXFacadeImpl() {
    }

    public XLSXFacadeImpl(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void generateBlankFile() {

        List<Sheet> sheets = new ArrayList<>();
        sheets.forEach(s ->
            s.rows = Arrays.asList(
                new Row()
            )
        );

        fileService.saveFile(new XLSXFile(sheets));
    }
}

class Row {}

class Sheet {

    public List<Row> rows;
}

class File {}

class XLSXFile extends File {

    public List<Sheet> sheets;

    public XLSXFile(List<Sheet> sheets) {
        this.sheets = sheets;
    }
}

class Demo1 {

    public static void main(String[] args) {

        XLSXFacade xlsxFacade = new XLSXFacadeImpl();
        xlsxFacade.generateBlankFile();
    }
}