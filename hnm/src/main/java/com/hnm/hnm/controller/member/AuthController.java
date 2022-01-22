package com.hnm.hnm.controller.member;

import com.hnm.hnm.entity.member.MemberRequestDto;
import com.hnm.hnm.entity.member.MemberResponseDto;
import com.hnm.hnm.entity.token.TokenRequestDto;
import com.hnm.hnm.entity.token.TokenDto;
import com.hnm.hnm.service.member.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public ResponseEntity<MemberResponseDto> signUp(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signUp(memberRequestDto));
    }

    @PostMapping("/signIn")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

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
