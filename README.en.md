[한국어](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.md) | [For English](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.en.md)

# data-aes-secret
[![](https://jitpack.io/v/JunyHarang-Open-Source-project/Data-Aes-Secret.svg)](https://jitpack.io/#JunyHarang-Open-Source-project/Data-Aes-Secret)
- - -

### what's this for
* Major Data Encryption used by AES Algorithm
* Major Data Decryption used by AES Algorithm
* Available AES Length 128, 192, 256


#### How to Import
* 1️⃣ Add the JitPack repository to your build (build.gradle) file
```groovy
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

* 2️⃣ Add the dependency
```groovy
dependencies {
    ...
    implementation 'com.github.JunyHarang-Open-Source-project:Data-Aes-Secret:1.1.0b'
    ...
}
```

#### How to Use
* 1️⃣ Create a key (encryption key) using a random value
```java
    String encryptionKeyValue = RandomValue.createRandomValue();
    String encryptionKey = DataAesSecret.base64Encoder(encryptionKeyValue);
```

* 2️⃣ Cancer/decryption progression
```java
public void test() {
        String encryptionValue = DataAesSecret.aesSecret(algorithmLength, encryptionKey, plainText, 1);
        String decryptionValue = DataAesSecret.aesSecret(algorithmLength, encryptionKey, encryptionContent, 2);
}
```

If you want more and detail please visit here [data-aes-secret Used Manual](https://junyharang.tistory.com/364)
Thank you and enjoy hack 😀