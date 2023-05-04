/**
 * @author Hassan Refaat <hassan.refaat.dev@gmail.com>
 * @Created 5/4/2023 8:24 AM
 */
package io.nerd.twitter.service;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import io.nerd.twitter.exception.EmailFailedToSendException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Service;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.ByteArrayOutputStream;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {
    private final Gmail gmail;

    public void sendEmail(String to, String subject, String content) throws Exception {
        Properties properties = new Properties();
        Session session = Session.getInstance(properties, null);
        MimeMessage email = new MimeMessage(session);
        try {
            email.setFrom(new InternetAddress("hsanrft@gmail.com"));
            email.addRecipient(javax.mail.Message.RecipientType.TO, new InternetAddress(to));
            email.setSubject(subject);
            email.setText(content);

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            email.writeTo(buffer);
            byte[] rawMessage = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(rawMessage);
            Message message = new Message();
            message.setRaw(encodedEmail);

            message = gmail.users().messages().send("me", message).execute();

        } catch (Exception e) {
           throw new EmailFailedToSendException();
        }
    }
}
