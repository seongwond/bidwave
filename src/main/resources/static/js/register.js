document.addEventListener("DOMContentLoaded", function () {
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");
    const confirmPasswordInput = document.getElementById("confirm-password");

    emailInput.addEventListener("blur", checkEmail); // 이메일 중복 체크 (포커스 아웃 시)
    passwordInput.addEventListener("input", checkPassword); // 비밀번호 입력 시 체크
    confirmPasswordInput.addEventListener("input", checkPassword); // 비밀번호 확인 입력 시 체크

    const form = document.querySelector(".register-form");
    form.onsubmit = async function (event) {
        const isValid = await validateForm(); // 전체 폼 유효성 검사
        if (!isValid) {
            event.preventDefault();
        }
    };
});

// 이메일 중복체크 + 형식검사
async function checkEmail() {
    const email = document.getElementById("email").value.trim();
    const emailStatus = document.getElementById("email-status");

    if (email === "") {
        emailStatus.textContent = "이메일을 입력해 주세요.";
        emailStatus.style.color = "red";
        return false;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        emailStatus.textContent = "올바른 이메일 형식을 입력하세요.";
        emailStatus.style.color = "red";
        return false;
    }

    try {
        const response = await fetch(`/check-email?email=${encodeURIComponent(email)}`);
        const data = await response.json();
        if (data.exists) {
            emailStatus.textContent = "이미 사용 중인 이메일입니다.";
            emailStatus.style.color = "red";
            return false;
        } else {
            emailStatus.textContent = "사용 가능한 이메일입니다.";
            emailStatus.style.color = "green";
            return true;
        }
    } catch (error) {
        emailStatus.textContent = "이메일 확인 중 오류 발생.";
        emailStatus.style.color = "red";
        return false;
    }
}

// 비밀번호 & 비밀번호 확인 체크
function checkPassword() {
    const password = document.getElementById("password").value.trim();
    const confirmPassword = document.getElementById("confirm-password").value.trim();
    const passwordError = document.getElementById("password-error");
    const confirmPasswordError = document.getElementById("confirm-password-error");

    if (password.length < 8) {
        passwordError.textContent = "비밀번호는 최소 8자 이상이어야 합니다.";
        passwordError.style.color = "red";
        return false;
    } else {
        passwordError.textContent = "";
    }

    if (confirmPassword !== "") {
        if (password !== confirmPassword) {
            confirmPasswordError.textContent = "비밀번호가 일치하지 않습니다.";
            confirmPasswordError.style.color = "red";
            return false;
        } else {
            confirmPasswordError.textContent = "비밀번호가 일치합니다.";
            confirmPasswordError.style.color = "green";
        }
    } else {
        confirmPasswordError.textContent = "";
    }

    return true;
}


// 전체 폼 검증
async function validateForm() {
    let isValid = true;

    const emailValid = await checkEmail();
    if (!emailValid) isValid = false;

    if (!checkPassword()) isValid = false;

    return isValid;
}
