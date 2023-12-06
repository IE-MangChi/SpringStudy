package study.practice.service.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.practice.controller.login.LoginForm;
import study.practice.domain.member.Member;
import study.practice.repository.member.MemberRepository;
import study.practice.service.member.MemberService;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository repository;

    public Member login(LoginForm loginParam) {
        return repository.findByLoginId(loginParam.getLoginId())
                .filter(v -> v.getPassword().equals(loginParam.getPassword()))
                .orElse(null);
    }

}
