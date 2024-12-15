Amit Final Project

Project Overview

This project is a test automation framework designed to ensure the functionality and reliability of a web application. 
It utilizes Selenium WebDriver for browser automation, TestNG for test execution, and Allure for reporting.
The project is hosted on GitHub for version control and includes essential components like a demo video, execution reports, and a detailed README.

Features
Test Automation: Automated test cases covering critical functionalities of the application.

Allure Reporting: Detailed and interactive test execution reports.

Git Integration: Version control using Git and GitHub.

Demo Video: A recorded video showcasing the execution of the tests.


Test cases

Sign up 
Login 
Add two products 
Check out 

Project Structure
Amit final project
├── .git                 # Git version control directory
├── .gitignore           # Files to ignore in Git
├── .idea                # IntelliJ IDEA settings
├── allure-report        # Allure HTML reports
├── allure-results       # Allure raw results
├── Demo                 # Demo video showing test execution
├── img_1.png            # Sample image 1
├── img_2.png            # Sample image 2
├── pom.xml              # Maven configuration file
├── src                  # Source code for tests
├── target               # Compiled test files and output

Tools and Technologies

Java: Programming language used for test scripts.

Selenium WebDriver: Browser automation framework.

TestNG: Test execution and management framework.

Allure: Reporting tool for detailed and interactive test reports.

Maven: Build and dependency management tool.

Git: Version control system.

Setup and Installation

Clone the repository:

git clone <repository_url>

Navigate to the project directory:

cd Amit-final-project

Install dependencies using Maven:

mvn clean install

Ensure the browser driver (e.g., ChromeDriver) is available and configured.

Running the Tests

To execute the tests, use:

mvn test

To generate the Allure report:

allure serve allure-results

Contents Included

Demo Video: Located in the Demo directory, showcasing the execution of the tests.

Allure Report: Available in the allure-report directory after execution.

Source Code: All test cases and utilities are located in the src directory.

Contributing

Fork the repository.

Create a feature branch:

git checkout -b feature/your-feature

Commit your changes:

git commit -m "Add your feature"

Push to the branch:

git push origin feature/your-feature

Open a pull request.
