# Factorial Calculator Project

## Table of Contents
1. [Project Description](#project-description)
2. [Example Input](#example-input)
3. [Example Output](#example-output)
4. [System Diagram](#system-diagram)
5. [Prototype Code](#prototype-code)

---

## Project Description
The Factorial Calculator is a program designed to process a CSV file containing integers in its first row. For each integer, the program computes its factorial and generates an output CSV file where each integer's factorial is placed in the row below each input integer.

### Factorial Explained
The factorial of a non-negative integer \(n\), denoted as \(n!\), is the product of all positive integers less than or equal to \(n\).

For example:
- \(3! = 1 \times 2 \times 3 = 6\)
- \(5! = 1 \times 2 \times 3 \times 4 \times 5 = 120\)

---

## Example Input
The program takes as input a CSV file where each column represents an integer.

The first row of the CSV file contains integers for which the program will compute factorials.

| Input (Integers) |
|------------------|
| 3                |
| 5                |
| 7                |
| 10               |

[Example CSV File For Input](https://docs.google.com/spreadsheets/d/1y0zyf3XYWDzkmndVelLVxirV273C3wbvwS_CSmKGVgU/edit?usp=sharing)

---

## Example Output
The program generates an output CSV file in which each column corresponds to the factorial computed for the respective integer in the input file.

| Input (Integers) | Output (Factorial) |
|------------------|--------------------|
| 3                | 6                  |
| 5                | 120                |
| 7                | 5040               |
| 10               | 3628800            |

[Example CSV File of Output](https://docs.google.com/spreadsheets/d/1LsOKnRCu7wJibaXTxzEOEVTNuq983HeZ3mPUbjJKsPE/edit?usp=sharing)

---

## System Diagram
!<img width="703" alt="image of SWE-RLJ project diagram" src="https://github.com/user-attachments/assets/3b2d03ca-37d5-4c76-9c30-163c99db0fb1"> 
