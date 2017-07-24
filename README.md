# Chat Client: Android

## Introduction

This is a proof of concept about a simple chat application in Android.
It allows you to communicate with other apps or chat clients usign a websocket. 

___You can also download the server app [here](https://github.com/vAlmaraz/chat-socket-php).___

There are five hardcoded users. First screen displays four contacts: the contact list without the current user. 
Clicking on any of them starts a chat with that user. 

It has been developed using Master/Detail flow. So, if it is a Tablet, the contact list and chat is presented on the same screen. 
If not, both screens are independent.

## Architecture

The architecture modeled for this solution consists of a simplified version of Clean Architecture.
A Model - View - Presenter is used to interact with the user.

This architecture implements the model usign the repository pattern.
Repositories connect to the source of the data without applying any type of business logic. 

In this case, there is only one connection via websocket, but implementing a caching on disk or database without affecting the view is relatively simple.

The MVP View and Presenter interact with the Model through use cases. These are the ones that have the business logic.
In this example, ChatUseCase executes the initial connection and the user registration in the socket service.

The View is composed by activities, fragments, adapters and viewholders. ButterKnife has been used to inject widget layout.

## Best practices

This architecture allows you to separate components responsibilities. For example, an error when connecting to the server would be located and quickly fixed in Model layout.

In addition, it encourages different programmers to work in the same application being able to develop different tasks without creating conflicts.

The code style, variable names, and so on. in most cases follow the most commonly used standards and my own [style guide](https://github.com/vAlmaraz/code-style).

## Improvements

To ensure the quality and good operation of the project, it would be necessary to implement unit, functional and interface tests, verifying that functions, callbacks and navigation works as expected.

I recommend also adding dependency injection to avoid obvious lines of code into classes.

The design of the interface has not been taken into account. It needs:

List of users:
- Different images for each user.

Chat:
- A progress widget to indicate requests time.
- Improve message history by visually indicating who each message belongs to.
- Indicating the message confirmation.

The network security has not been taken into account. 
In production deployment you must securely connect to the websocket over SSL (wss). 

You should also implement Certificate Pinning and OCSP against the server to prevent Man In The Middle attacks.

In addition, the application code is not obfuscated. It is necessary to configure Proguard to obfuscate all possible classes making it difficult to decompile and understand.
