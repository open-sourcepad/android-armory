# Android Armory

## Preferred Libraries

* **Dependency Injection - Koin**
https://github.com/InsertKoinIO/koin
 ```groovy 
 koin_version = '2.1.0-alpha-1'

implementation "org.koin:koin-core:$koin_version"
implementation "org.koin:koin-android:$koin_version"
implementation "org.koin:koin-android-viewmodel:$koin_version"

 ```
 
* **Serialization**
 
Kotlinx Serialization
https://github.com/Kotlin/kotlinx.serialization
 ```groovy 
 //Project Level
 buildscript {
    ext.kotlin_version = '1.3.50'
    dependencies {
        classpath "org.jetbrains.kotlin:kotlin-serialization:$kotlin_version"
    }
}
//Module Level
apply plugin: 'kotlinx-serialization'


dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
    implementation "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0"
}
 ```

* **Webservice** 

 Http Logging https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor

 Retrofit https://square.github.io/retrofit/ 

```groovy 
implementation 'com.squareup.retrofit2:retrofit:2.6.1'
implementation 'com.squareup.okhttp3:logging-interceptor:4.2.1'

 ```
 
* **Database** 

Room https://developer.android.com/jetpack/androidx/releases/room

```groovy 
def room_version = "2.2.1"

implementation "androidx.room:room-runtime:$room_version"
kapt "androidx.room:room-compiler:$room_version" 
implementation "androidx.room:room-ktx:$room_version"
testImplementation "androidx.room:room-testing:$room_version"

 ```
 
 ## Development Guidelines
 
Layout Files

| Component       | Class Name             | Layout Name                   |
| --------------- | ---------------------- | ----------------------------- |
| Activity        | `LoginActivity`        | `activity_login.xml`          |
| Fragment        | `ProfileFragment`      | `fragment_profile.xml`        |
| Dialog          | `NoInternetDialog`     | `dialog_no_internet.xml`      |
| ViewHolder      | `ProductVH`            | `item_product.xml`            |


Views

| View            | ID                | 
| --------------- | ----------------- | 
| TextView        | `@+id/name_tv`    |
| EditText        | `@+id/name_et`    | 
| ImageView       | `@+id/avatar_iv`  | 
| Button          | `@+id/save_btn`   | 
| ImageButton     | `@+id/like_ib`    | 

Drawables

| Drawable        | ID              | 
| --------------- | --------------- | 
| Icon            | `ic_delete`     |
| Background      | `bg_rainbow`    | 
| Logo            | `logo_golf`     | 
| Selector        | `selector_fave` | 
| Shape           | `circle_orange` | 

Views as variables

| View            | Name         | 
| --------------- | ------------ | 
| TextView        | `nameTv`     |
| EditText        | `nameEt`     | 
| ImageView       | `avatarIv`   | 
| Button          | `saveBtn`    | 
| ImageButton     | `likeIb`     | 
| Recyclerview    | `productsRv` | 

Settings up different URLs for debug,staging,release builds
```groovy

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://\"")
        }
        staging {
            buildConfigField("String", "BASE_URL", "\"https://\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://\"")
            //....
        }
    }

```
```kotlin 
val baseUrl:String = BuildConfig.BASE_URL
```

Dynamic resources - ```<type> <name> <value>```
```groovy 
  buildTypes {
        debug {
            resValue "string" "app_name" "Android Armory Dev"
        }
        staging {
            resValue "string" "app_name" "Android Armory Staging"
        }
        release {
            resValue "string" "app_name" "Android Armory"
            //....
        }
    }
```
```R.string.app_name```
