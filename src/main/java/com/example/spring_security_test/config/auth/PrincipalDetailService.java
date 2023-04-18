package com.example.spring_security_test.config.auth;

import com.example.spring_security_test.data.entity.Users;
import com.example.spring_security_test.data.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users principal = usersRepository.findByUsername(username)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException(String.format("유저아이디 : %s 를 찾을 수 없습니다.", username));
                });
        PrincipalDetail principalDetail = new PrincipalDetail(principal);

        return principalDetail;
    }

}
