# Lab 6 - Logging

----------------------

**Author**: Justin Del Vecchio

**Edited by**: Jon Mrowczynski

---------------------

You might find:
- [Logger](https://docs.oracle.com/en/java/javase/21/docs/api/java.logging/java/util/logging/Logger.html)
- [FileHandler](https://docs.oracle.com/en/java/javase/21/docs/api/java.logging/java/util/logging/FileHandler.html)

helpful references during this lab.

----------------------

## Part 1 - Intro to Logging

Many banks and financial institutions implement logging as part of their security and compliance measures. This is 
especially important for regulatory compliance requirements such as the Sarbanes-Oxley Act (SOX) and the Payment Card 
Industry Data Security Standard (PCI DSS). These regulations require financial institutions to implement strict 
controls over their systems and data, including logging and monitoring of all system activity. The logs can be used to 
track and investigate security incidents, as well as to provide evidence of compliance during audits.

A program that simulates a simple banking application can be structured as shown in the `banking` package: 

`BankAccount` represents a customer's bank account and stores their name, account number, and balance. It also contains 
the logic for depositing and withdrawing money from the account, which updates the account's balance and logs the 
transaction in a file with a name that matches the account number. 

`Transaction` represents a single transaction that cen either deposit or withdraw money from a `BankAccount`. It 
contains a reference to the `BankAccount` on which the transaction will be performed and the amount of money that 
will be deposited or withdrawn. It also contains methods to perform the deposit or withdrawal, which calls the 
appropriate method on the `BankAccount` object.

`BankDriver` creates two `BankAccount` objects and performs some transactions on them. The program uses logging files 
to keep track of all transactions that occur on each bank account. The log files will contain information about the 
time, type of transaction, the amount, and the new balance after each transaction.

1. Run `BankDriver`.
2. Notice two errors are logged to the terminal rather than to a file. 

### Q1: What problem was encountered when running `BankDriver`?

[Answer Here]

### Task 1: Correcting Log File Creation

1. Take a look inside `BankAccount`.
2. Complete the `TODO` inside its constructor.
   - It might help to take a look at `config.LoggingExample`to see how to programmatically create a directory.
   - Use this idea to programmatically create the directory in which `BankAccount` is attempting to create its log 
     files.
3. Rerun `BankDriver` to ensure your fix works.

`double`s are used to represent transaction amounts.

### Q2 (2pts.): What would be a better data type to use in place of `double` and why?
**Hint**: Think back to when we used `BigInteger` to represent an arbitrary precision integer.

[Answer Here]

### (Extra Credit) - Task 2 (5pts.): Change the code to utilize this data type when logging.

- Ensure to rerun `BankDriver` to ensure that your modification works!

--------------------------------

## Part 2 - Using `logging.properties`

1. Run `LoggingExample` in the `config`. package
   - You may have noticed a `logging.properties` file in the same package as `LoggingExample`. This isn't used yet.
2. Review the output and compare the number of logging messages defined in the `main()` method with those shown in the 
   console.

### Q1 (2pts.): Why are there a different number of messages in the `main()` method compared to what is printed to the console?

[Answer Here]

### Task 1: Copy and paste the Java command that was used to run the application.

- Review the console output after running `LoggingExample. It will be the first line of output in the console (above 
  the read text). Simple copy and paste that entire line below.

```text
[Answer Here]
```

### Task 2: Run the code using the `logging.properties` file

To register the `logging.properties` file with the application we have to instruct the JVM to use it as a 
configuration file when it runs. This can be done by instructing the VM to use the file via a VM option by:

1. Right-clicking on `LoggingExample` then go to `More Run/Debug -> Modify Run Configurations...`

![Figure 1](./images/Figure%201.png)

3. Click on `Modify options -> Add VM options`.

![Figure 2](./images/Figure%202.png)

4. Your `Edit Run Configuration` window should now look similar to this:

![Figure 3](./images/Figure%203.png)

5. You need to copy and paste the below line into the VM options box:

```text
-Djava.util.logging.config.file=/home/jon-mrowczynski/Desktop/CSC213Lab6/src/config/logging.properties
```

6. However! **Change the path** to the location of the`logging.properties` file to where it is located on your machine 
   since the above line is set up to work on your instructor's machine. 
    - Note that there are no spaces in the path. Spaces can be problematic sometimes...Avoid them when possible.
    - the `-D` VM option allows us to define a system property at the JVM startup.
7. Hit `OK` in the bottom right of the window to save the changes.
8. Run `LoggingExample` with this updated configuration.

### Task 3: Copy and paste the Java command that was used to run the application just like in [Task 1](#task-1-copy-and-paste-the-java-command-that-was-used-to-run-the-application).

```text
[Answer Here]
```

You should notice your system property has now been added when you run `LoggingExample`! Look at the console output.

### Q2: How does the output differ from what you saw in Q1 (aside from the added system property)?

[Answer Here]

### Q3: Where is the console output being written?

[Answer Here]

### Q4: Go to where the console output is being redirected and look at the file contents. Are all the messages recorded? (Y/N)

[Answer Here]

Run `LoggingExample` again 3 times and take another look at the log file's contents.

### Q5: Is the logging content appended to the log file or is the file written new each time?

[Answer Here]

A configuration file allows you to change the behavior of an application without recompiling the code. The lab kept 
on stressing that not all the logging messages in `main()` are logged to the console or the logging file.

### Task 3: Change `logging.properties` to log all messages of all logging levels to the log file.

- You will know that you succeeded when **all** messages are outputted to the file.

### Task 4: Change `logging.properties` so that output is in an XML format instead of the simple format currently used.

### Task 5: Change `logging.properties` to ensure that output is appended to the log file rather than overwritten.

---------------------------

## Part 3 - Submit to D2L:

Your zipped `src` folder with your `README.md` copy and pasted into the `src` folder such that the structure of the zip 
file is exactly:

```text
src
├── banking
│   ├── BankAccount.java
│   ├── BankDriver.java
│   └── Transaction.java
├── config
│   ├── LoggingExample.java
│   └── logging.properties
└── README.md
```
