# Speedrun (by Oriol Villaret)
External libs
- Retrofit - https://square.github.io/retrofit/
- EventBus - https://github.com/greenrobot/EventBus
- Butterknife - https://jakewharton.github.io/butterknife/
- Picasso - http://square.github.io/picasso/

Arquitecture

This project has VIPER Arquitecture
- View - corresponds to an Activity or Fragment in the app. A goal is to make the View as dumb as possible, so that it only takes care of showing the UI.
- Interactor - Takes care of performing any action, when the Presenter says to.
- Presenter - acts as a “Head-of-Department”. In other words, it commands any action making use of the Interactor, tells the View to display content, and orders the navigation to other screens using the Router.
- Entity - represents the app data. In short, it acts likes the Model in the MVP architecture pattern.
- Router - The Router handles navigating to other screens during the app lifecycle. In this case we are using the new Android Navigation Architecture Component (https://developer.android.com/topic/libraries/architecture/navigation/)

Min Android Studio Version 3.2 to use Android Navigation Architecture Component
