# Filmz
Search for films from IMDB, gather film data(rating, length, cast…) and save them in a Room database.

Filmz is a native android application written in kotlin that illustrates Android development best practices with Android Jetpack, MVVM pattern and Kotlin Coroutines.



ScreenShots
--------------
<div style="display:flex;">
<img alt="App image" src="screens/1.jpg" width="16%">
<img alt="App image" src="screens/2.jpg" width="16%">
<img alt="App image" src="screens/3.jpg" width="16%">
<img alt="App image" src="screens/4.jpg" width="16%">
<img alt="App image" src="screens/5.jpg" width="16%">
<img alt="App image" src="screens/6.jpg" width="16%">
</div>


Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Data Binding][11] - Declaratively bind observable data to UI elements.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][13] - Build data objects that notify views when the underlying database changes.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
* Third party and miscellaneous libraries
  * [Glide][90] for image loading
  * [Retrofit][92] for api calls
  * [moshi][94] Convert JSON
  * [SimpleSearchView][93] Search view based on MaterialDesign guidlines
  * [Kotlin Coroutines][91] for managing background threads with simplified code and reducing needs for callbacks

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[91]: https://kotlinlang.org/docs/reference/coroutines-overview.html


[92]: https://square.github.io/retrofit/
[93]: https://github.com/Ferfalk/SimpleSearchView
[94]: https://github.com/square/moshi
