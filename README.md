# 🦖 26기 안드로이드 파트 과제 🦖

## 1주차 세미나

### 회원가입, 로그인 구현

#### Todo

- 로그인뷰에서 회원가입뷰로 이동 가능
- 회원가입 완료 시 로그인뷰로 돌아옴
- 회원가입뷰에서 입력했던 아이디와 비밀번호가 로그인뷰에 나타남
- constraintDimensionRatio를 사용하여 이미지 크기를 1:1 비율로 나타내기

#### How

- SignInActivity에서 SignUpActivity로 이동 시 startActivity로 실행
- SignUpActivity에서 putExtra로 이메일과 비밀번호 값을 전달
- onActivityResult 함수를 override하여 SignUpActivity에서 받은 data를 처리
- xml에서 layout_constraintDimensionRatio 속성을 사용하여 비율로 이미지 크기 조정 가능
- 속성 값으로는 "가로비율:세로비율" 또는 "h(height) or w(width), 가로비율:세로비율" 두 가지 포맷 사용
- "h or w, 가로비율:세로비율" 형식은 가로, 세로를 모두 0dp로 설정 후 h 또는 w로 변경될 사이드를 지정하여 사용


## 2주차 세미나

### Bottom Navigation, View Pager, Recycler View 구현

#### Todo

- 눌러서 이동할 수 있는 하단 탭바 구현 
- 스와이프로 탭 이동 가능
- 스와이프로 탭 이동시 하단탭바 아이콘 변경
- 리싸이클러뷰로 리스트 띄우기

#### How

- BottomNavigationView로 하단탭바 레이아웃 구현
- ViewPager로 스와이프로 이동 가능한 뷰 구현
- PagerAdapter에서 getItem 함수를 override하여 파라미터로 전달된 position에 해당하는 fragment를 생성
- Activity에서 BottomNavigationView에 setOnNavigationItemSelectedListener를 달아 선택한 탭 아이콘에 따라 위에 페이지를 변경하도록 구현
- Activity에서 ViewPager에 addOnPageChangeListener를 달아 onPageSelected 함수를 override하여 스와이프로 페이지 변경 시 페이지에 해당하는 아이콘이 선택되도록 구현 
