package structural.facade;

class Cpu {

    public void start() {
        System.out.println("inicialização inicial");
    }
    public void execute() {
        System.out.println("executa algo no processador");
    }
    public void load() {
        System.out.println("carrega registrador");
    }
    public void free() {
        System.out.println("libera registradores");
    }
}

class Memoria {
    public void load(int position, String info) {
        System.out.println("carrega dados na memória");
    }
    public void free(int position, String info) {
        System.out.println("libera dados da memória");
    }
}

class HardDrive {
    public String read(int startPosition, int size) {
        System.out.println("lê dados do HD");
        return "Dados";
    }
    public void write(int position, String info) {
        System.out.println("escreve dados no HD");
    }
}

class ComputadorFacade {

    private Cpu cpu = null;
    private Memoria memoria = null;
    private HardDrive hardDrive = null;

    public ComputadorFacade(Cpu cpu,
                            Memoria memoria,
                            HardDrive hardDrive) {
        this.cpu = cpu;
        this.memoria = memoria;
        this.hardDrive = hardDrive;
    }

    public void ligarComputador() {
        int BOOT_SECTOR = 0;
        int SECTOR_SIZE = 0;
        int BOOT_ADDRESS = 0;
        cpu.start();
        String hdBootInfo = hardDrive.read(BOOT_SECTOR, SECTOR_SIZE);
        memoria.load(BOOT_ADDRESS, hdBootInfo);
        cpu.execute();
        memoria.free(BOOT_ADDRESS, hdBootInfo);
    }
}