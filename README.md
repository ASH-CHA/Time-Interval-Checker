# Time Interval Checker

## Description

The **Time Interval Checker** is a Java Swing–based GUI application that allows users to compare two time intervals and determine whether a specific time falls within one or both of those intervals.

The program validates user input, handles invalid times gracefully using a custom exception, and uses **generics**, **interfaces**, and **object-oriented design** to model time intervals and comparisons accurately.

---

## How It Works

### User Interface

The application presents a graphical interface where the user can:

* Enter a **start and end time** for **two time intervals**
* Enter a **time to check**
* Click buttons to either **compare intervals** or **check a time**

All times must be entered in the format:

```
HH:MM AM/PM
```

---

### Core Functionality

#### 1. Comparing Intervals

When the **Compare Intervals** button is clicked:

* The program creates `Time` objects from the input fields
* Two `Interval<Time>` objects are created
* The program determines whether:

  * The intervals **overlap**
  * One interval is a **sub-interval** of the other
  * The intervals are **disjoint**
* The result is displayed in the output area

---

#### 2. Checking a Time

When the **Check Time** button is clicked:

* The entered time is compared against both intervals
* The program determines whether the time is:

  * In **both** intervals
  * In **only one** interval
  * In **neither** interval
* The result is displayed in the output area

---

### Error Handling

* Invalid time inputs (incorrect format, invalid hours/minutes, or invalid meridian) trigger a custom `InvalidTime` exception
* Error messages are displayed directly in the output area instead of crashing the program

---

## Program Structure

### `Project4.java`

* Main GUI application
* Builds the Swing interface
* Handles button actions
* Displays results to the user

### `Time.java`

* Represents a time with hours, minutes, and AM/PM
* Validates time values
* Implements `Comparable<Time>` for ordering
* Supports string-based time input

### `Interval.java`

* Generic class representing an interval
* Works with any `Comparable` type
* Provides methods for:

  * `within`
  * `subinterval`
  * `overlaps`

### `InvalidTime.java`

* Custom checked exception
* Used to handle invalid time inputs gracefully

---

## How to Run

1. Ensure all files are in the same directory:

   * `Project4.java`
   * `Time.java`
   * `Interval.java`
   * `InvalidTime.java`

2. Compile the program:

   ```bash
   javac Project4.java
   ```

3. Run the program:

   ```bash
   java Project4
   ```

4. Enter times in the required format and interact with the GUI.

---

## Example Output Messages

* `The intervals overlap`
* `Interval 1 is a sub-interval of interval 2`
* `Only interval 1 contains the time 09:30 AM`
* `Invalid time input: Invalid time format`

---

## Screenshots

1. **Initial GUI Window**

   <img width="381" height="288" alt="Screenshot 2025-12-16 125447" src="https://github.com/user-attachments/assets/201f2d6a-5764-4fbe-ae09-411a552a8b9e" />

2. **Filled Time Intervals**

   <img width="382" height="288" alt="Screenshot 2025-12-16 125735" src="https://github.com/user-attachments/assets/ed4900e3-295b-43f9-94f6-5a56e1ba6e5d" />

3. **Sub-Interval Case**

   <img width="383" height="290" alt="Screenshot 2025-12-16 130207" src="https://github.com/user-attachments/assets/9b7ee3a1-ec3e-4bb6-bae2-460874b21210" />

4. **Check Time Result**

   <img width="383" height="289" alt="Screenshot 2025-12-16 130428" src="https://github.com/user-attachments/assets/318bb76a-61de-4964-9ad6-f35cf6d32903" />

5. **Invalid Input Example**

   <img width="383" height="292" alt="Screenshot 2025-12-16 130617" src="https://github.com/user-attachments/assets/201284fc-8381-44de-ad1b-dcaad08e5822" />
