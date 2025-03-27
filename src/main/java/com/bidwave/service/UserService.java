package com.bidwave.service;

import com.bidwave.dao.UserDao;
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

    private final UserDao userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    // 회원가입 처리
    public void registerUser(UserDTO user) {
        if (isEmailExists(user.getEmail())) {
            throw new DuplicateKeyException("이미 사용 중인 이메일 주소입니다.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.registerUser(user);
    }

    // 이메일로 사용자가 있는지 조회하기
    public UserDTO findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    // 이메일 중복 여부 확인 메서드 추가
    public boolean isEmailExists(String email) {
        return userDAO.existsByEmail(email); // DAO 호출로 데이터베이스에서 이메일 존재 여부 확인
    }

    // loadUserByUsername() 사용자 정보를 가져오고 인증하는 작업을 Security 자동으로 처리한다고 함 메모..
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO user = findByEmail(username);
        if (user != null) {
            return new User(user.getEmail(), user.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException("User not found with username: " + username);
    }

    // 이메일로 userId를 조회하는 메서드 추가
    public long getUserIdByEmail(String email) {
        UserDTO user = findByEmail(email);
        if (user != null) {
            return user.getUserId();
        }
        throw new IllegalArgumentException("사용자를 찾을 수 없습니다: " + email);
    }

    public List<BidDTO> getBidListByUserEmail(String email) {
        return userDAO.getBidListByUserEmail(email);
    }

    public boolean existsByUserId(Long userId) {
        int count = userDAO.existsByUserId(userId);
        return count > 0; // count가 0보다 크면 존재하는 것으로 처리
    }

    // 사용자 ID로 사용자 정보 조회
    public UserDTO findById(Long userId) {
        return userDAO.fetchUserById(userId); // 이미 존재하는 fetchUserById 메소드 사용
    }

    public List<UserDTO> getAllUsers() {
        return userDAO.fetchAllUsers(); // DAO 메서드를 호출하여 모든 사용자 정보 가져오기
    }


}



