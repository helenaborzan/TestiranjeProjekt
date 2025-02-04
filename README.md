# TestiranjeProjekt - Automated Web Testing

This project is a Maven-based automated testing framework built using **Java**, **Selenium WebDriver**, **TestNG**, and **Page Object Model (POM)** design pattern. It includes test cases for interacting with popular websites like Google, YouTube, and Netflix.

---

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies and Concepts Used](#technologies-used)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Test Cases and Results](#test-cases)

---

## Project Overview

This project demonstrates automated web testing using Selenium WebDriver and TestNG. It includes:
- **Page Classes**: Encapsulate the behavior of web pages (e.g., `GoogleHomePage`, `YouTubeHomePage`, `NetflixHomePage`).
- **Base Test Class**: Serves as the foundation for test cases by providing setup and teardown methods. This allows for code reusability and maintains a single source of truth for test initialization and cleanup.
- **Test Classes**: Contain individual test cases that extend the BaseTest class, following the principles of inheritance in OOP.

---

## Technologies and Concepts Used

- **Java**: Programming language for writing test scripts.
- **Selenium WebDriver**: Browser automation tool.
- **TestNG**: Testing framework for organizing and running tests.
- **Maven**: Build automation and dependency management.
- **ChromeDriver**: WebDriver for the Chrome browser.
- **WebDriverManager**: Automates the management of WebDriver binaries.
- **Page Object Model (POM)** – Implemented for better test structure, maintainability, and reusability of web elements.
- **Object-Oriented Programming (OOP)** – Applied principles such as encapsulation and inheritance to structure the test framework effectively.
- **Wait commands in Selenium WebDriver** – Used for handling dynamic elements and ensuring proper synchronization in test execution.

---

## Installation

Follow these steps to set up the project locally:

1. **Install Chrome Browser**:
   - Download and install the latest version of [Google Chrome](https://www.google.com/chrome/).

2. **Install Java JDK**:
   - Download and install the latest version of [Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html).

3. **Install IntelliJ IDEA**:
   - Download and install [IntelliJ IDEA](https://www.jetbrains.com/idea/).

4. **Download ChromeDriver**:
   - Download the latest version of [ChromeDriver](https://sites.google.com/chromium.org/driver/).
   - Alternatively, use **WebDriverManager** (included in the project) to automatically manage the ChromeDriver binary.

5. **Clone the Repository**:
   ```bash
   git clone https://github.com/helenaborzan/TestiranjeProjekt.git
   cd TestiranjeProjekt

6. **Import the Project into IntelliJ**:
- Open IntelliJ IDEA.
- Select **File > Open** and navigate to the cloned project directory.
- Wait for Maven to download dependencies automatically.

---
## Project Structure

The project follows the **Page Object Model (POM)** design pattern:

- `pages/` – Contains Page Object Model classes.
- `pom.xml` – Manages dependencies and build configurations.

## Test Cases and Results

The project includes automated test cases for validating the functionality of Google, YouTube, and Netflix. Each test case extends `BaseTest.java` to ensure consistent setup and teardown processes.

### Test Case1: Google Search Validation

This test verifies that a Google search for "Selenium" returns relevant results.

#### Steps:

1. Maximize the browser window.  
2. Create an instance of `GoogleHomePage` and accept cookies using the `acceptCookies()` method.  
3. Search for the term `"Selenium"` using the `searchFor("Selenium")` method.  
4. Verify that the search result contains the term `"Selenium"` using the `isResultDisplayed("Selenium")` method.  
5. Assert that the result is displayed.

#### RESULT: PASS

### Test Case2: Merlin Platform Access

This test checks if searching for "Merlin 24/25" on Google leads to the correct Moodle login page and verifies the page content.

#### Steps:

1. Maximize the browser window.  
2. Create an instance of `GoogleHomePage` and accept cookies using the `acceptCookies()` method.  
3. Search for the term `"Merlin 24/25"` using the `searchFor("Merlin 24/25")` method.  
4. Wait for the first search result to be clickable using a WebDriverWait.  
5. Click on the first search result to navigate to the desired page.  
6. Wait until the URL matches `"https://moodle.srce.hr/2024-2025/auth/simplesaml/login.php"`.  
7. Get the title of the current page.  
8. Verify that the page title contains `"Merlin 24/25"` or the page source contains `"Merlin 24/25"`.  
9. Assert that the new page should contain `"Merlin 24/25"`

#### RESULT: PASS

### Test Case3: Netflix Sign-In Verification

This test verifies that searching for "Netflix" on Google leads to the correct Netflix homepage and ensures that the sign-in page is accessible.

#### Steps:
1. Open Google in a maximized browser window.  
2. Accept cookies on the Google homepage.  
3. Search for `"Netflix"`.  
4. Click on the first search result.  
5. Wait until the page URL matches `"https://www.netflix.com/hr/"`.  
6. Click on the "Sign In" button.  
7. Verify that the URL contains `"login"`, indicating the sign-in page is displayed.  

#### RESULT: PASS

### Test Case4: YouTube Search and Video Playback

This test verifies that searching for "YouTube" on Google leads to the correct YouTube homepage and ensures that a video can be searched and played.

#### Steps:

1. Maximize the browser window.  
2. Navigate to the Google homepage by going to `"https://www.google.com"`.  
3. Accept cookies on the Google homepage using the `acceptCookies()` method.  
4. Search for the term `"YouTube"` using the `searchFor("YouTube")` method.  
5. Wait for the first search result to be clickable using a WebDriverWait.  
6. Click on the first search result to navigate to the YouTube homepage.  
7. Wait until the URL matches `"https://www.youtube.com/"`.  
8. Accept cookies on the YouTube homepage using the `acceptCookies()` method.  
9. Search for the term `"tutorial"` on YouTube using the `searchFor("tutorial")` method.  
10. Click on the first video from the search results using the `clickFirstVideo()` method.  
11. Wait until the URL contains `"/watch"`, confirming that a video is playing.  
12. Verify that the current URL contains `"/watch"`, confirming that the video is being played on YouTube.

#### RESULT: PASS

### Test Case5: YouTube Shorts Navigation

This test verifies that searching for "YouTube" on Google leads to the correct YouTube homepage and ensures that the Shorts section can be accessed.

#### Steps:
1. Open Google in a maximized browser window.
2. Accept cookies on the Google homepage.
3. Search for "YouTube."
4. Click on the first search result.
5. Wait until the page URL matches "https://www.youtube.com/".
6. Accept cookies on the YouTube homepage.
7. Navigate to the Shorts section.
8. Verify that the URL contains "/shorts/," indicating the Shorts page is displayed.

#### RESULT: PASS
