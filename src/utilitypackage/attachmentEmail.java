package utilitypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class attachmentEmail {
    public static void main(String[] args) {
    	
    	
    	
    	/////Zipping the file
    	
    	String zipFile = "D:\\zip folder\\testng-xslt.zip";
		String srcDir = "D:\\ReportGeneration\\testng-xslt";
		
		try {
			
			// create byte buffer
			byte[] buffer = new byte[1024];
			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);
			File dir = new File(srcDir);
			File[] files = dir.listFiles();

			for (int i = 0; i < files.length; i++) {
				
				System.out.println("Adding file: " + files[i].getName());

				FileInputStream fis = new FileInputStream(files[i]);

				// begin writing a new ZIP entry, positions the stream to the start of the entry data
				zos.putNextEntry(new ZipEntry(files[i].getName()));
				
				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}

				zos.closeEntry();

				// close the InputStream
				fis.close();
			}

			// close the ZipOutputStream
			zos.close();
			
		}
		catch (IOException ioe) {
			System.out.println("Error creating zip file" + ioe);
		}
    	
    	/////////////////////////
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sauravtbsl@gmail.com","jiajuri@123");
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sauravtbsl@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("saurav.ghosh@timesgroup.com"));
            message.setSubject("Sample Mail with Attachment");
            BodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            File file = new File("D:\\zip folder\\testng-xslt.zip");
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            String filename = "ReportZipFile.zip";
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);
            BodyPart messageBodyPart2 = new MimeBodyPart();
            messageBodyPart2.setText("Hello User"+"\n\n"+"Automation Report"+
                    "\n\n"+ "NB: Please don't reply to this mail. It is a system generated message.");
            multipart.addBodyPart(messageBodyPart2);
            message.setContent(multipart);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}