document.addEventListener("DOMContentLoaded", function() {
    const priceInput = document.getElementById("price");
    const priceUpButton = document.getElementById("price-up");
    const priceDownButton = document.getElementById("price-down");
    const productImageInput = document.getElementById("productImageInput");
    const productImagePreview = document.getElementById("productImagePreview");

    // 초기값 형식화
    priceInput.value = formatNumber(1000);

    // 값 변경 이벤트 처리
    priceInput.addEventListener("input", function() {
        this.value = this.value.replace(/[^0-9]/g, ""); // 숫자만 입력 가능
        this.value = formatNumber(this.value); // 숫자 형식화
    });

    // 버튼 클릭 이벤트 처리
    priceUpButton.addEventListener("click", function() {
        let price = parseInt(priceInput.value.replace(/,/g, "")) + 100;
        priceInput.value = formatNumber(price);
    });

    priceDownButton.addEventListener("click", function() {
        let price = parseInt(priceInput.value.replace(/,/g, ""));
        if (price >= 100) {
            price -= 100;
        }
        priceInput.value = formatNumber(price);
    });

    // 숫자 형식화 함수
    function formatNumber(value) {
        return Number(value).toLocaleString(); // 세자리마다 반점 추가
    }

    // 이미지 미리보기 기능
    productImageInput.addEventListener("change", function(event) {
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = function(e) {
                productImagePreview.src = e.target.result;
                productImagePreview.style.display = "block"; // 이미지 표시
            };
            reader.readAsDataURL(file);
        } else {
            productImagePreview.style.display = "none"; // 이미지 숨기기
        }
    });
});
