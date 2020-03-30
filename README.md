# FunFace
FunFace is an Android mobile application that allows user to create and store custom Whatsapp Stickers into the app, and import them into Whatsapp.
FunFace is completely free to use as well.

The application provides learning oppurtunities for new developers who're into creating mobile applications, with the following functions being used:
- Completely written in Kotlin, the official language for Android.
- MVVM architecture, separate responsibilities concern by inserting View Models.
- Single Activity application, as recommended by Google, the application only uses one single activity and uses fragments to display.
- Room Database, complete access of SQL Lite database but easier to use.
- Coroutine, the concurrency design patterns that allows code to execute asynchronously.
- Entirely uses Navigation Graph, instead of navigating using intents to navigated, which has higher maintainability and easily changed.
- Content Provider usages, learn how to call and wake another applications and exchange information.
- Creating and storing local files
- Image processing ability, such as editing, compression, format conversion to webp
- Material design, which makes the application interface lively


# Progress
The app is currently under development
Check points:
[x] Create foundation structures (StickerPackDataBase, Database Access Object, Repository)
[x] Create foundation structures (Sticker, StickerPack)
[x] Create type converter for StickerPack and Database
[x] Create navigation graph
[x] Create collection view (fragment, recycler view, adaptor)
[x] Create collection view's view model
[x] Create new collection view to add new StickerPack
[x] Create feature to remove a StickerPack
[x] Create StickerPack detail view (fragment, recycler view, adaptor)
[x] Create StickerPack detail view's view model
[x] Create connection to navigate to the unique stickerPack that has been tapped on in collection view
[x] Create feature to add new sticker into a selected stickerPack
[x] Create feature to remove a sticker from a selected StickerPack
[] Create feature to create new directory for individual stickerPacks to store the stickers in app specific space
[] Create feature to call the default Android gallery
[] Create feature to select a photo and return it to FunFace app
[] Create tools to compress a given photo into a given size
[] Create cropping view (fragment)
[] Create cropping view's view model to crop a photo
[] Create edit view (fragment)
[] Create tools to process the image (erase, draw, add text, change tool's pixel size)
[] Create tools to save the processed image into StickerPack file directory
[] Create animated splash screen
[] Refactor the code and design to match Android's material design guideline
