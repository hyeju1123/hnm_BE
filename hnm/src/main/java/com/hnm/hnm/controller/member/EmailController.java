package com.hnm.hnm.controller.member;

import com.hnm.hnm.entity.token.EmailToken;
import com.hnm.hnm.entity.token.EmailTokenRequestDto;
import com.hnm.hnm.service.member.EmailService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
public class EmailController {

    final EmailService emailService;
    @Value("${mailHost}") String host;

    @GetMapping("/send")
    public void sendEmail(@RequestBody EmailTokenRequestDto emailTokenRequestDto) throws MessagingException {
        emailService.sendEmail(emailTokenRequestDto);
    }

    @GetMapping("/certified")
    public void certifiedEmailCheck(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam String email,
                                    @RequestParam String emailToken) throws IOException, ServletException {

        EmailTokenRequestDto requestDto = EmailTokenRequestDto.builder()
                .email(email)
                .emailToken(emailToken)
                .build();
        try {
            // 해당 이메일 토큰이 저장되어 있었다면 삭제
            emailService.certifiedEmailCheck(requestDto);
            response.sendRedirect("http://" + host + ":8080/auth/mail/success");
        } catch (IllegalArgumentException ex) {
            // 해당 이메일 토큰이 만료되거나 존재하지 않으면 재생성
            EmailToken updatedEmailToken = emailService.updateEmailToken(requestDto);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/mail/failed");
            request.setAttribute("eToken", updatedEmailToken.getValue());
            request.setAttribute("email", updatedEmailToken.getKey());
            dispatcher.forward(request, response);
        }
    }


}
