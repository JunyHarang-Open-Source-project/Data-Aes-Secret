[한국어](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.md) | [For English](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.en.md)

# data-aes-secret
[![](https://jitpack.io/v/JunyHarang-Open-Source-project/Data-Aes-Secret.svg)](https://jitpack.io/#JunyHarang-Open-Source-project/Data-Aes-Secret)
- - -

### 무엇을 할 수 있나요?
* AES 알고리즘을 이용한 주요 Data 암호화
* AES 알고리즘을 이용한 주요 Data 복호화
* 사용할 수 있는 AES 알고리즘 길이 128, 192, 256


#### 어떻게 사용할 수 있나요?
* 1️⃣ 최초 build.gradle에 JitPack Repository에 의존성을 추가합니다.
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

* 2️⃣ 해당 Repository 주소를 의존성에 추가해 줍니다.
```groovy
dependencies {
    ...
    implementation 'com.github.JunyHarang-Open-Source-project:Data-Aes-Secret:1.1.0b'
    ...
}
```

#### 어떻게 사용하나요?
* 1️⃣ 난수값을 이용하여 Key(encryptionKey) 만들기
```java
    String encryptionKeyValue = RandomValue.createRandomValue();
    String encryptionKey = DataAesSecret.base64Encoder(encryptionKeyValue);
```

* 2️⃣ 암/복호화 진행
```java
public void test() {
    String encryptionValue = DataAesSecret.aesSecret(algorithmLength, encryptionKey, plainText, 1);
    String decryptionValue = DataAesSecret.aesSecret(algorithmLength, encryptionKey, encryptionContent, 2);
}
```

해당 Library에 대한 보다 자세한 내용을 알고 싶으시다면 [이 곳](https://junyharang.tistory.com/364)
으로 방문해 주세요. 😀