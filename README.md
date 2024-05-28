# Student Grading App

This project for the CSE337s: Software Testing course at Ain Shams University involves developing a JAVA application to manage student grading, calculate GPA, and assign grades. The focus is on thorough software testing.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Input Format](#input-format)
- [Output Format](#output-format)
- [Grading Criteria](#grading-criteria)
- [Testing](#testing)
- [License](#license)

## Features

- Reads student grading data from a file.
- Validates input data according to predefined rules.
- Calculates GPA and assigns grades based on the provided marks.
- Outputs the results in a formatted file.

## Requirements

- Java Development Kit (JDK) 11 or higher
- [JUnit](https://junit.org/junit5/) for testing

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Abdulrahman295/Student-Grading-App.git
   cd Student-Grading-App

2. Compile the Java program:
     ```bash
     javac -d bin src/*.java
     
3. Run the application
   ```bash
   java -cp bin StudentGradingApp

## Input Format
The application reads data from a file where each line is a comma-separated string. The format is as follows:
- First Line: Subject Name,Subject Code,Full Mark
- Subsequent Lines: Student Name,Student Number,Student Activities Mark,Oral/Practical Mark,Midterm Exam Mark,Final Exam Mark
### Example Input File
    Mathematics,MATH101,100
    John Doe,12345678,8,9,18,55
    Jane Smith,87654321,9,8,17,60

## Output Format
The output file contains:
- First Line: Subject Name: <subject-name> Max Mark: <full-mark>
- Second Line: Student Name Student Number GPA Grade
- Subsequent Lines: Each student's name, number, GPA, and grade, separated by spaces.
### Example Output File
    Subject Name: Mathematics Max Mark: 100
    Student Name Student Number GPA Grade
    John Doe 12345678 3.4 B+
    Jane Smith 87654321 4.0 A+

## Grading Criteria
The GPA and grade are calculated based on the following table:
| Mark Range          | GPA | Grade |
|---------------------|-----|-------|
| >= 97 and <= 100    | 4.0 | A+    |
| >= 93 and < 97      | 4.0 | A     |
| >= 89 and < 93      | 3.7 | A-    |
| >= 84 and < 89      | 3.3 | B+    |
| >= 80 and < 84      | 3.0 | B     |
| >= 76 and < 80      | 2.7 | B-    |
| >= 73 and < 76      | 2.3 | C+    |
| >= 70 and < 73      | 2.0 | C     |
| >= 67 and < 70      | 1.7 | C-    |
| >= 64 and < 67      | 1.3 | D+    |
| >= 60 and < 64      | 1.0 | D     |
| < 60                | 0.0 | F     |

## Testing
- Unit tests are implemented using JUnit.
- Black box testing is conducted to validate the functionality of the application without peering into its internal structures or workings.
- Integration testing is performed to ensure all components work together.
### Test Coverage
*Branch Coverage*

![Branch Coverage](https://github.com/Abdulrahman295/Student-Grading-App/assets/89452130/f734d886-721e-4771-95f0-d42f52e139b5)



*Statement Coverage*

![Statement Coverage](https://github.com/Abdulrahman295/Student-Grading-App/assets/89452130/da40dc99-5954-41a7-b9a4-debb338d3075)

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
