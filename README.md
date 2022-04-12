# GUI
Это универские примеры JavaFX, не мной написаны

Вот пример задачи этой недели 
In Task 2 your work will mirror many of the things you will need to do for your exam project in SOFT3202. You will be creating a GUI application that targets a web API to provide certain features.

Your task is to create a local, GUI application that provides users access to the API provided by SpaceTraders. You should read up on the SpaceTraders server and its API through the following links:

https://spacetraders.io/ (Links to an external site.)

https://api.spacetraders.io/ (Links to an external site.)

You are being given significant freedom to decide exactly what your application will look like. Unlike other assessments you have control over the build.gradle file that is used and (within some specific limits) can add in libraries to assist in your work. Your first library decision will likely be the GUI framework you use. JavaFX and Swing/AWT are likely to be the most common, but you are not limited to these.

The key limitation on what libraries you can include (which you will experience in your exam work as well) is that you cannot include any API specific libraries. This means none of the libraries included here https://github.com/SpaceTradersAPI/awesome-spacetraders (Links to an external site.) or anything that does something similar, you must code the way your application accesses the API yourself. You can bring in an http client library if you choose to, or use the native Java httpclient.

An issue with targeting a web API is that you have introduced an external dependency into your work, which will make testing in isolation more difficult (note that you do not need to do programmatic testing in this task, but running it on your own to see if it works, and your marker doing the same, are all forms of system testing). This has 3 main issues – first, the API could be down, whether due to a bug or maintenance. Second, the API has built in rate limit protections, which your marker may reach when marking leading to subsequent students’ applications failing to work. Third, the API has timings included that will make testing difficult. To resolve this, you will need to abstract access to the API – I would strongly suggest applying the façade pattern here.

You will then need to create a ‘dummy’ version of the SpaceTraders API that acts locally, and yields enough data/dynamic responses to successfully demonstrate the features of your application, selectable through the command line parameters to be detailed later. This does not need to be fully featured (consider it similar to a mock) – it is just there to show your lists, dialogues, etc display with information in them correctly.

This dummy version is often misunderstood – it is not complex, and you are not trying to reimplement the server behaviour. Behaviour like JSONPlaceholder with no change of state and purely static data is expected. Even simpler – you do not need to come up with complex dummy data. Just enough that your GUI runs and displays the way it is supposed to is plenty. It does not need to be operating as a web server – it can and should be accessed as a Java object only.

Features

In order for your application to be considered a success it must allow the following:

The user can see whether the server is currently active
A new user can obtain and store credentials (these can just be stored in RAM, no need for saving to disk, but the user should be able to copy their access token to the clipboard)
An existing user can enter and store their existing credentials
The user can see their info
The user can list available loans and their details
The user can obtain a loan
The user can list active loans
The user can list available ships and their details
The user can purchase a ship
The user can list their ships and their details
The user can purchase ship fuel
The user can view the marketplace details for a given location
The user can purchase goods from the marketplace
The user can list nearby locations and their details
The user can create a flight plan and journey to a nearby location
The user can view their current flight plan (this does not need to automatically refresh, manual is ok)
The user can sell goods to the marketplace
These features should be available ‘statelessly’ – that is, if a user closes the application and re-opens it, they should be able to pick up where they left off. This must be based on the server state, not any locally saved data.
Note that this feature set maps closely to the initial tutorial outlined at https://spacetraders.io/docs/guide (Links to an external site.)

At first glance this list of features may seem daunting – remember, the code to handle these features already exists on the web server. All you are doing is providing a front-end to these commands. It is possible to re-use significant amounts of code between features. This also applies to your exam work – it is anticipated that significant amounts of your code from this Task will be re-usable in your exam work, even though it will target different APIs. For this reason, while your design is only assessed through its effect on the user, it will be useful to you to consider your design as you go.

You should include some protections for user input. This comes in 2 categories:

Client-side checks. These checks should be limited to the very obvious problems – if numeric input is required, your code should refuse to accept strings that do not parse to numbers. If the user has to select from a list, you should refuse input that is not present in that list.
You do not need to mirror the API logic in these defensive checks – for example, if the user attempts to buy more than they can afford, you should let them try, do not try to anticipate these errors.
Server-side checks. These checks occur automatically on the server, and include issues like the purchase error described above. You do not need to pre-empt these errors, but you do need to detect them from the server response and react accordingly – i.e., tell the user what the error was and ensure the UI view does not update incorrectly.
GUI Requirements

Your GUI must meet some requirements for each feature to be considered ‘working’.

No raw JSON should be visible at any point in the application. That is, all JSON must be parsed into a human-readable form based on its contents. The Gson library is recommended to assist with this.
If the user must select from a list, then they must be able to do this by selecting an element in the GUI somehow, not typing some identifier. For example, a radio button, double-clicking on an element, etc.
Information should not require horizontal scrolling – vertical scrolling is ok.
Errors (whether due to user input error, or network connection errors) must notify the user in the GUI, not just on standard out/err.
Running the application

Your application should provide a main method access point through a class named SpaceTraderApp, which you should include in your build.gradle file using the application plugin detailed here: https://docs.gradle.org/current/userguide/application_plugin.html (Links to an external site.). This main method should take in a single keyword argument that is either ‘online’ or ‘offline’, indicating whether the true web API is used, or your dummy version. An example command line execution will look like

gradle run --args="offline"

Marking Guide

5/5 – Your code compiles and runs successfully. Each of the required features is available and works properly. You have successfully dummied the API so it can be run without hitting the real web API. There is sufficient error handling that a user entering incorrect data does not cause the application to break or crash.

2.5/5 – Your code compiles and runs successfully. A user can make it through to at least purchasing a ship successfully. You have successfully dummied the API so it can be run without hitting the real web API up to at least purchasing a ship successfully. There is sufficient error handling that any breaking behaviour or crashes are rare.

0/5 – Your code does not compile or run. You do not meet either the 5/5 or 2.5/5 requirements.

Your code is not being marked on internal design – just overt features. However, you should do your best to follow model-view separation and design your code well. If you are successful in this, then you will find a lot of reusability between this code and your major exam project. If you are not, then you will likely have to start from scratch.

Submission

Your work should be submitted through https://github.sydney.edu.au in your repository named SCD2_2022, with all the usual collaborators, inside the folder ‘task2’. Your submission should be in the form of a gradle project that can be built and run from the command line – that is, if a shell session’s current working directory is <cloneofyourrepository>/task2, then the command ‘gradle run --args="online"’ should successfully run your application.

Include a readme file indicating to your marker how to access each of the required features your submission provides, even if you believe your UI is simple to understand.
