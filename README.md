# 🦖 26기 안드로이드 파트 과제 🦖

## 1주차 세미나

### 회원가입, 로그인 구현, constraint layout 익숙해지기

#### 📌 Todo

  - 안내 멘트를 눌러서 로그인뷰에서 회원가입뷰로 이동 가능
  - 회원가입 완료 시 로그인뷰로 돌아옴
  - 회원가입뷰에서 입력했던 아이디와 비밀번호가 로그인뷰에 나타남

  - constraintDimensionRatio를 사용하여 이미지 크기를 1:1 비율로 나타내기

#### 💡 How

- SignInActivity에서 SignUpActivity로 이동 시 **startActivity**로 실행
- SignUpActivity에서 **putExtra**로 이메일과 비밀번호 값을 전달
- **onActivityResult** 함수를 override하여 SignUpActivity에서 받은 data를 처리

- xml에서 **layout_constraintDimensionRatio** 속성을 사용하여 비율로 이미지 크기 조정 가능
- 속성 값으로는 "가로비율:세로비율" 또는 "h(height) or w(width), 가로비율:세로비율" 두 가지 포맷 사용
- "h or w, 가로비율:세로비율" 형식은 가로, 세로를 모두 0dp로 설정 후 h 또는 w로 변경될 사이드를 지정하여 사용
```kotlin
<ImageView 
  android:layout_width="0dp"
  android:layout_height="0dp"
  app:layout_constraintDimensionRatio="H,16:9"
  app:layout_constraintBottom_toBottomOf="parent"
  app:layout_constraintTop_toTopOf="parent"/>
```


## 2주차 세미나

### Bottom Navigation, View Pager

#### 📌 Todo

- 눌러서 이동할 수 있는 하단 탭바 구현 
- 스와이프로 탭 이동 가능
- 스와이프로 탭 이동시 하단탭바 아이콘 변경

- 리싸이클러뷰로 리스트 띄우기

#### 💡 How

- **BottomNavigationView**로 하단탭바 레이아웃 구현
- **ViewPager**로 스와이프로 이동 가능한 뷰 구현
- PagerAdapter에서 getItem 함수를 override하여 파라미터로 전달된 position에 해당하는 fragment를 생성
- Activity에서 BottomNavigationView에 **setOnNavigationItemSelectedListener**를 달아 선택한 탭 아이콘에 따라 위에 페이지를 변경하도록 구현
- Activity에서 ViewPager에 **addOnPageChangeListener**를 달아 onPageSelected 함수를 override하여 스와이프로 페이지 변경 시 페이지에 해당하는 아이콘이 선택되도록 구현 

### Recycler View로 instagram 리스트 구현

#### 📌 Todo

- instagram 아이템 만들기
- Recycler View로 instagram 아이템 리스트 띄우기

#### 💡 How

- item의 프로필 이미지는 동그랗게 띄워야하므로 **CircleImageView** 라이브러리 사용
- 리스트를 띄우고 싶은 fragment에 recyclerView 추가
- RecyclerViewAdapter와 ViewHolder를 이용해 아이템을 리스트에 연결
- RecyclerView 내부의 **ItemDecoration**클래스를 상속받는 클래스를 만들어 아이템을 꾸밀 때 쓸 내용을 작성
- ItemDecoration클래스는 추상클래스이므로 원하는 함수를 override 하여 사용 가능
- **parent.getChildAdapterPosition(view)** 와 **state.itemCount**를 사용하여 첫번째, 마지막, 그 이외 아이템에 각기 다른 속성 적용 가능
```kotlin
class ItemDecorator(private val verticalSpacing: Int): RecyclerView.ItemDecoration(){

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemPosition = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        // 첫번째 아이템
        if (itemPosition == 0) {
            outRect.bottom = verticalSpacing
        }
        // 마지막 아이템
        else if (itemCount > 0 && itemPosition == itemCount - 1) {
            outRect.top = verticalSpacing
        }
        // 사이에 있는 모든 아이템
        else {
            outRect.top = verticalSpacing
            outRect.bottom = verticalSpacing
        }
    }
}
```
- 원하는 fragment 클래스에서 RecyclerView에 **addItemDecoration()**함수를 사용해 ItemDecoration 적용
```kotlin
fragHomeRv.addItemDecoration(ItemDecorator(5)) 
```
- 좀 더 자연스러운 리스트뷰 구현을 통해 **clipToPadding** 속성을 사용하면 스크롤 시 RecyclerView에 준 패딩 부분까지 리스트의 내용을 보여줄 있음
```kotlin
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/frag_home_rv"
        android:clipToPadding="false"
        android:paddingTop="10dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```
