package structural.adapter.ey;

class Data {}

interface XMLService {
    void sendData();
}

interface JSONService {
    void sendData();
}

class XMLData implements XMLService {

    public Data data;

    @Override
    public void sendData() {/*...*/}
}

class JSONData implements JSONService {

    public Data data;

    @Override
    public void sendData() {/*...*/}
}

class XMLDataAdapter implements XMLService {

    private JSONData jsonData;

    public XMLDataAdapter(JSONData data) {
        this.jsonData = data;
    }

    @Override
    public void sendData() {
        jsonData.sendData();
    }
}

class Demo {

    public static void main(String[] args) {

        JSONData data = new JSONData();
        XMLDataAdapter adapter = new XMLDataAdapter(data);

        adapter.sendData();
    }
}