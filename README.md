Easier Environment Switching using the Java-Owner library

1. create separate .properties files for each test environment

2. pass the name of the environment in which your test is currently running into the suite runner (in this case, testng.xml)

3. create an 'Environment.java' interface to map values from the properties file for the specified environment to variables needed by the test

4. within your test, create a configFactory using the above Environment interface

5. for additional details:  http://www.testautomationguru.com/selenium-webdriver-how-to-execute-tests-in-multiple-environments/ 