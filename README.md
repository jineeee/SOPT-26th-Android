# 🦖 26기 안드로이드 파트 과제 🦖

## 1주차 세미나

### 회원가입, 로그인 구현

#### Todo

- 로그인뷰에서 회원가입뷰로 이동 가능
- 회원가입 완료 시 로그인뷰로 돌아옴
- 회원가입뷰에서 입력했던 아이디와 비밀번호가 로그인뷰에 나타남

#### How

- SignInActivity에서 SignUpActivity로 이동 시 startActivity로 실행
- SignUpActivity에서 putExtra로 이메일과 비밀번호 값을 전달
- onActivityResult 함수를 override하여 SignUpActivity에서 받은 data를 처리

