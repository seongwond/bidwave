package com.bidwave.service;

import com.bidwave.dao.UserDao;
import com.bidwave.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;

    public void registerUser(UserDTO userDTO) {
        // 비밀번호 암호화 등의 로직 추가 가능
        userDao.insertUser(userDTO);
    }

    public boolean authenticateUser(String email, String password) {
        UserDTO user = userDao.getUserByEmail(email);
        if (user != null) {
            // 실제로는 암호화된 비밀번호를 비교해야 합니다.
            // 예: return passwordEncoder.matches(password, user.getPassword());
            return user.getPassword().equals(password);
        }
        return false;
    }
}
