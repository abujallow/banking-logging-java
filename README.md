# Banking Logging System (Java)

## Overview
This project demonstrates a Java-based banking simulation that integrates structured logging using `java.util.logging`.

The goal of this project was to understand how applications handle logging, debugging, and configuration without modifying source code.

---

## Key Features
- Logging across multiple levels (FINEST → SEVERE)
- External configuration using `logging.properties`
- File-based logging output
- XML log formatting
- Log file appending vs overwriting control

---

## Technologies Used
- Java
- java.util.logging
- IntelliJ IDEA

---

## What I Learned
- How to configure logging behavior using external `.properties` files
- Differences between logging levels and when to use them
- How logging is used for debugging and monitoring real-world systems
- How to format logs (Simple vs XML)
- Importance of persistent logs for system tracking

---

## How to Run
1. Clone the repository
2. Open in IntelliJ
3. Run `LoggingExample.java`
4. Ensure VM options include:

## Example Output
Logs are written to:
Includes:
- INFO
- WARNING
- SEVERE
- and lower-level debug logs

---

## Why This Matters
Logging is critical in production systems for:
- Debugging issues
- Monitoring performance
- Tracking system behavior

This project reflects foundational backend engineering practices.
