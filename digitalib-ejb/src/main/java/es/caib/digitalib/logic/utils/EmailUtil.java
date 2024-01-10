package es.caib.digitalib.logic.utils;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.mail.Transport;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.fundaciobit.genapp.common.filesystem.FileSystemManager;

import es.caib.digitalib.commons.utils.Constants;
import es.caib.digitalib.model.entity.Fitxer;

/**
 * 
 * @author anadal
 * 
 */
public class EmailUtil {

 /**
   * Envia un email a un {@link List} de emails
   * 
   * @param subject
   *          Asunto del Mensaje
   * @param message
   *          Contenido a enviar
   * @param from
   *          Indica la procedencia del mensaje
   * @param type
   *          Indica el con que de que tipo es el destinatario, Copia, Copia
   *          Oculta, etc
   * @param isHtml
   *          Decide si el contenido del mensaje a de ser visualizado en html o
   *          no
   * @param recipients
   *          Conjunto de emails para los que va dirigido el mensaje
   * @throws Exception
   */
  public static void postMail(String subject, String message, boolean isHtml,
      String from, String ... recipients) throws Exception {
    
    

    Context ctx = new InitialContext();
    Session session = (javax.mail.Session) ctx.lookup(Constants.MAIL_SERVICE);

    // Creamos el mensaje
    MimeMessage msg = new MimeMessage(session);

    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    // Indicamos los destinatarios
    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++) {
      addressTo[i] = new InternetAddress(recipients[i]);
    }
    
    final RecipientType type = RecipientType.TO;

    msg.setRecipients(type, addressTo);

    // Configuramos el asunto
    msg.setSubject(subject, "UTF-8");
    msg.setSentDate(new Date());

    // Configuramos el contenido
    if (isHtml) {
      msg.setHeader("Content-Type", "text/html;charset=utf-8");
      /*
      URL urlToAdd = new URL(url);
      msg.setDataHandler(new DataHandler(urlToAdd));
      */
      msg.setContent(message, "text/html;charset=utf-8");
    } else {
      msg.setContent(message, "text/plain" /*; charset=UTF-8"*/);
    }

    // Mandamos el mail
    Transport.send(msg);

  }
  
  public static void postMail(String subject, String message, boolean isHtml, String from,
          Fitxer fitxer, String... recipients) throws Exception {

        Context ctx = new InitialContext();
        Session session = (javax.mail.Session) ctx.lookup(Constants.MAIL_SERVICE);

        // Creamos el mensaje
        MimeMessage msg = new MimeMessage(session);

        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        // Indicamos los destinatarios
        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
          addressTo[i] = new InternetAddress(recipients[i]);
        }

        final RecipientType type = RecipientType.TO;

        msg.setRecipients(type, addressTo);

        Multipart multipart = new MimeMultipart();

        // MISSATGE
        {
          MimeBodyPart messageBodyPart = new MimeBodyPart();

          if (isHtml) {
            msg.setHeader("Content-Type", "text/html;charset=utf-8");
            messageBodyPart.setContent(message, "text/html;charset=utf-8");
          } else {
            messageBodyPart.setContent(message, "text/plain");
          }

          multipart.addBodyPart(messageBodyPart);

        }

        // FITXER
        if (fitxer != null) {

          
          File attach = FileSystemManager.getFile(fitxer.getFitxerID());
          
          
          DataSource source = new FileDataSource(attach);

          MimeBodyPart messageBodyPart = new MimeBodyPart();
          messageBodyPart.setDataHandler(new DataHandler(source));
          messageBodyPart.setFileName(fitxer.getNom());

          multipart.addBodyPart(messageBodyPart);

        }

        if (isHtml) {

          msg.setContent(multipart, "text/html;charset=utf-8");
        } else {
          msg.setContent(multipart, "text/plain");
        }

        // Configuramos el asunto
        msg.setSubject(subject, "UTF-8");
        msg.setSentDate(new Date());

        // Configuramos el contenido
        /*
         * if (isHtml) { msg.setHeader("Content-Type", "text/html;charset=utf-8");
         * msg.setContent(message, "text/html;charset=utf-8"); } else { msg.setContent(message,
         * "text/plain"); }
         */

        // Mandamos el mail
        Transport.send(msg);

      }


}