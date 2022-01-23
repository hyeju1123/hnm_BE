package com.hnm.hnm.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/auth")
public class EmailResultController {

    @GetMapping("/mail/success")
    public String getEmailAuthSuccess() {
        return "successEmailAuth";
    }

    @GetMapping("/mail/failed")
    public String getEmailAuthFailed(HttpServletRequest request, Model model) {
        String newEmailToken = (String) request.getAttribute("eToken");
        String email = (String) request.getAttribute("email");

        model.addAttribute("email", email);
        model.addAttribute("emailToken", newEmailToken);

        return "failedEmailAuth";
    }
}
