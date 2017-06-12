# Push Service using PushBullet

## Description
This is a Java based basic push notification service that sends the pushes using the [PushBullet](https://www.pushbullet.com/). This provides three REST API endpoints:

* RegisterUser
* ListUsers
* SendMessage

## Pre-requisites
This requires a Push Bullet accessToken. For this Visit [here](https://www.pushbullet.com/)

1. Sign up
2. Go to Devices
3. Install Pushbullet to a device of your choice (be it a phone or a web browser)
4. Go to Settings, Account
5. Select Create Access Token
6. Note down the generated access token somewhere safe

This also requires J2SE 1.8 or above and Maven 4.0

## How to deploy the API

* Download the sources to a folder, say "c:/PushDemo".
* Open Eclipse IDE and open the .project file from the above folder
* Open the build.xml and update the wsgen.exe path.
* Open the PushDemo class and on line 34 update the accessToken value obtained above 
* Now run the ant build and then run the PushService
* The above mentioned API methods will be available for use


## Invoking the methods

### RegisterUser:

* This endPoint takes the userName as input and returns these values:

<pre>
"username": 
"accessToken": 
“creationTime”:
“numOfNotificationsPushed”:
</pre>