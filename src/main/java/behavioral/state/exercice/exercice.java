package behavioral.state.exercice;

class CombinationLock
{
    private int [] combination;
    public String status;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        status = new StatusLocked().getStatus();
    }

    public void enterDigit(int digit)
    {
        System.out.println(digit);

        if (status.equals(new StatusLocked().getStatus())) {
            status = new Integer(digit).toString();
        } else if (!status.equals(new StatusError().getStatus())) {
            status += new Integer(digit).toString();
        }

        if (status.length() > combination.length) {
            status = new StatusError().getStatus();
            return;
        }

        for (int i = 0; i < combination.length; i++) {

            try {
                if (Integer.parseInt(String.valueOf(status.charAt(i))) != combination[i]) {
                    status = new StatusError().getStatus();
                    return;
                }

                if (i == combination.length - 1) {
                    status = new StatusOpen().getStatus();
                }

            }catch (StringIndexOutOfBoundsException e) {

            }
        }


    }
}

class StatusLocked {

    private String status;

    public StatusLocked() {
        status = "LOCKED";
    }

    public String getStatus() {
        return status;
    }
}

class StatusOpen {

    private String status;

    public StatusOpen() {
        status = "OPEN";
    }

    public String getStatus() {
        return status;
    }
}

class  StatusError {

    private String status;

    public StatusError() {
        status = "ERROR";
    }

    public String getStatus() {
        return status;
    }
}

class Demo {

    public static void main(String[] args) {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        System.out.println(cl.status);
        cl.enterDigit(1);
        System.out.println(cl.status);
        cl.enterDigit(2);
        System.out.println(cl.status);
        cl.enterDigit(3);
        System.out.println(cl.status);
        cl.enterDigit(4);
        System.out.println(cl.status);
    }
}