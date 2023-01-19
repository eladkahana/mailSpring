package com.example.mailspring;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class email {
    private final String from;
    private final String to;
    private final String sub;
    private final String content;

    public email(String to, String sub, String content) {

        this.from = "labibiliotica@gmail.com";
        this.to = to;
        this.sub = sub;
        this.content = content;
    }

    public void SendEmail() {
        Properties p = new Properties();
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");

        Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("labibiliotica@gmail.com", "gorthvgwezibmcqn");
            }
        });
        try {


            String path = "C:\\Users\\כהנא אלעד\\Pictures\\" + "WeBuyNet-logos.jpeg";

            MimeMessage m = new MimeMessage(s);
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(sub);

            MimeBodyPart ConPart = new MimeBodyPart();
            ConPart.setContent(content, "text/html; charset=utf-8");

            MimeBodyPart FilePart = new MimeBodyPart();
            FilePart.attachFile(new File(path));

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(ConPart);
            multipart.addBodyPart(FilePart);

            m.setContent(multipart);

            Transport.send(m);

            System.out.println("Success...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
