# Factor Calculator Project

## Table of Contents
1. [Project Description](#project-description)
2. [Example Input](#example-input)
3. [Example Output](#example-output)
4. [System Diagram](#system-diagram)
5. [Prototype Code](#prototype-code)

---

## Project Description
The Factor Calculator is a program designed to process a CSV file containing integers in its first row. For each integer, the program computes its factors and generates an output CSV file where each integer's factors are placed in the rows below each input integer.

### Factors Explained
A factor of a number is an integer that divides the number exactly (without leaving a remainder). For example, the factors of 12 are 1, 2, 3, 4, 6, and 12.

Given an integer \(n\), the factors can be determined by finding all integers \(i\) where \(i \times k = n\) for some integer \(k\).

---

## Example Input
The program takes as input a CSV file where each column represents an integer.

The first row of the CSV file contains integers for which the program will compute factors.

| Input (Integers) | Output (Factors) |
|------------------|------------------|
| 12               |                  |
| 15               |                  |
| 18               |                  |
| 28               |                  |

[Example CSV File For Input](https://docs.google.com/spreadsheets/d/1rDqXKVRXAhz5F5OCtLXWUbLdiGTCDBQ5Cz1LHpbdwRQ/edit?usp=sharing)

---

## Example Output
The program generates an output CSV file in which each column corresponds to the factors computed for the respective integer in the input file.

The factors are placed in the rows below the corresponding input integer.

| Input (Integers) | Output (Factors)         |
|------------------|--------------------------|
| 12               | 1, 2, 3, 4, 6, 12        |
| 15               | 1, 3, 5, 15              |
| 18               | 1, 2, 3, 6, 9, 18        |
| 28               | 1, 2, 4, 7, 14, 28       |

[Example CSV File of Output](https://docs.google.com/spreadsheets/d/1FCXybJVHUn5OvEs4fKmvVpMGPA5vC50okEQDZ5FtUwo/edit?usp=sharing)

---

## System Diagram
photo in progress
