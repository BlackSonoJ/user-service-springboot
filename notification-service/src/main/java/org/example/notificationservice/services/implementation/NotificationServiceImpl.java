package org.example.notificationservice.services.implementation;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.notificationservice.api.dto.MessageDto;
import org.example.notificationservice.services.NotificationService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final JavaMailSender mailSender;

    /// тут очень плохо, но времени не осталось, прошу, не бейте

    @Override
    public void sendMessage(MessageDto messageDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        helper.setFrom("BlackSon.1@yandex.ru");
        helper.setTo(messageDto.email());
        helper.setSubject("Test Subject");
        helper.setText("Test Message", false);

        mailSender.send(message);
    }

    public void sendCreateMessage(MessageDto messageDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        helper.setFrom("BlackSon.1@yandex.ru");
        helper.setTo(messageDto.email());
        helper.setSubject("Create");
        helper.setText("Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.", false);

        mailSender.send(message);
    }

    public void sendDeleteMessage(MessageDto messageDto) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

        helper.setFrom("BlackSon.1@yandex.ru");
        helper.setTo(messageDto.email());
        helper.setSubject("Delete");
        helper.setText("Здравствуйте! Ваш аккаунт был удалён", false);

        mailSender.send(message);
    }
}
