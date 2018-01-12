# 개발 환경
- java 1.8
- spring-boot : 1.5.9

# IDE
1. IntellJ
  * `gradle` 설정 시 `Create seperate module per source set` 옵션을 반드시 off 해준다. 
2. Checkstype Plugin
  * `Preferences -> Editor -> Code Style -> Scheme 설정 버튼 -> Import Scheme -> IntelliJ IDEA code style XML -> (Project ROot)div-intellij-codestyle.xml 선택`
# 빌드
## gradlew
* gradle wrapper 사용
```bash
./gradlew build
```

# 실행
## 방법
```bash
./gradlew bootRun 
```
