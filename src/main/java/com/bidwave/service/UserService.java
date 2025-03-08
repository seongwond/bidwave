package com.bidwave.service;

import com.bidwave.dao.UserDAO;
import com.bidwave.dto.BidDTO;
import com.bidwave.dto.UserDTO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입 처리
   /* public void registerUser(UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.registerUser(user);
    }*/

    // 이메일로 사용자가 있는지 조회하기
    public UserDTO findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    // 이메일 중복 여부 확인 메서드 추가
    public boolean isEmailExists(String email) {
        return userDAO.existsByEmail(email); // DAO 호출로 데이터베이스에서 이메일 존재 여부 확인
    }

    // loadUserByUsername() 사용자 정보를 가져오고 인증하는 작업을 Security가 자동으로 처리한다고 함 메모..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = findByEmail(username);
        if (user != null) {
            return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    public void registerUser(UserDTO user) {
        if (isEmailExists(user.getEmail())) {
            throw new DuplicateKeyException("이미 사용 중인 이메일 주소입니다.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.registerUser(user);
    }

    public List<BidDTO> getBidListByUserEmail(String email) {
        return userDAO.getBidListByUserEmail(email);
    }
}
