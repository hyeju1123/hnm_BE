package com.hnm.hnm.service.member;

import com.hnm.hnm.entity.token.EmailToken;
import com.hnm.hnm.exception.email.NotFoundEmailTokenException;
import com.hnm.hnm.jwtSecurity.TokenProvider;
import com.hnm.hnm.repository.member.EmailTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;
    private final TokenProvider tokenProvider;
    private final EmailTokenRepository emailTokenRepository;
    @Value("${mailHost}") String host;

    public void sendEmail(String email) throws MessagingException {

        EmailToken emailToken = emailTokenRepository.findByKey(email)
                .orElseThrow(NotFoundEmailTokenException::new);

        String emailContents = getEmailContents(emailToken.getKey(), emailToken.getValue());
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setFrom("hongAndMan");
        helper.setTo(emailToken.getKey());
        helper.setSubject("[홍만중국어 이메일 인증]");
        helper.setText(emailContents, true);

        javaMailSender.send(mimeMessage);
    }

    public String getEmailContents(String email, String emailToken) {

        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                " <div" +
                "	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #D14124; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">" +
                "	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">" +
                "		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">홍만중국어</span><br />" +
                "		<span style=\"color: #D14124\">메일인증</span> 안내입니다." +
                "	</h1>\n" +
                "	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">" +
                email +
                "		님 안녕하세요.<br />" +
                "		홍만중국어에 가입해 주셔서 진심으로 감사드립니다.<br />" +
                "		아래 <b style=\"color: #D14124\">'메일 인증'</b> 버튼을 클릭하여 회원가입을 완료해 주세요.<br />" +
                "		감사합니다." +
                "	</p>" +
                "	<a style=\"color: #FFF; text-decoration: none; text-align: center;\"" +
                "	href=\"http://" + host + ":8080/mail/certified?email=" + email + "&emailToken=" + emailToken + "\">" +
                "		<p" +
                "			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #D14124; line-height: 45px; vertical-align: middle; font-size: 16px;\">" +
                "			메일 인증</p>" +
                "	</a>" +
                "	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>" +
                " </div>" +
                "</body>" +
                "</html>";

    }

    @Transactional
    public void certifiedEmailCheck(String email, String emailToken) {
        // 해당 토큰이 저장되어 있는지 확인
        EmailToken notCertifiedEmail = emailTokenRepository.findByKeyAndValue(email, emailToken)
                .orElseThrow(NotFoundEmailTokenException::new);

        emailTokenRepository.delete(notCertifiedEmail);
    }

    @Transactional
    public EmailToken updateEmailToken(String email) {
        String newEmailToken = tokenProvider.generateEmailToken(email);
        EmailToken emailToken = EmailToken.builder()
                .key(email)
                .value(newEmailToken)
                .build();

        return emailTokenRepository.save(emailToken);
    }

}
