[한국어](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.md) | [For English](https://github.com/JunyHarang-Open-Source-project/Data-Aes-Secret/blob/master/README.en.md)

# data-aes-secret
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
    implementation 'com.github.JunyHarang-Open-Source-project:Data-Aes-Secret:1.0.0b'
    ...
}
```

#### How to Use
```java
public void test() {
    String encryptionContent=DataAesSecret.aesSecret(algorithmLength,encryptionKey,plainText,1);
    String decryptionBoardContent=DataAesSecret.aesSecret(algorithmLength,encryptionKey,encryptionContent,2);
}
```

If you want more and detail please visit here [data-aes-secret Used Manual](https://junyharang.tistory.com/364)
Thank you and enjoy hack 😀