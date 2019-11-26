package solid.dip.right;

interface IMail {
    void send();
}

class Mail {
    public String sender;
    public String to;
}

class MailHTML extends Mail implements IMail {

    @Override
    public void send() {/*...*/}
}

class MailText extends Mail implements IMail {

    @Override
    public void send() {/*...*/}
}

class MailService {

    IMail mail;

    public MailService(IMail mail) {
        this.mail = mail;
    }

    public void sendMail() {
        mail.send();
    }
}