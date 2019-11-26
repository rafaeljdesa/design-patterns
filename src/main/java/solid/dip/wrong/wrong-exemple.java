package solid.dip.wrong;

class HTMLBody {}

class MailService {

    public String sender;
    public String to;
    public HTMLBody htmlBody;

    public MailService(String sender, String to, HTMLBody htmlBody) {
        this.sender = sender;
        this.to = to;
        this.htmlBody = htmlBody;
    }

    public void sendMail() {/*...*/}
}