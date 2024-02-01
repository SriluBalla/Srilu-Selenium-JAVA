**Before you download the repo** – 
1.	Download JAVA - https://www.oracle.com/java/technologies/downloads/
    a.	Select the version of JDK
    b.	Select – Linux / macOS / Windows 
    c.	Download ARM64 DMG Installer (for Mac)
    d.	Double-click on the download  The folder opens with the DMG
    e.	Double-click on the PKG  Installer starts
    f.	Follow the steps and install the package
2.	Download selenium - https://www.selenium.dev/downloads/
    a.	Select JAVA stable version
    b.	Go to the location of the zip install and unzip it
3.	Install IntelliJ - https://www.jetbrains.com/edu-products/download/download-thanks.html?platform=macM1
4.	Download Selenium Drivers (chrome & IE is typical, firefox and safari are available by default)
    a.	https://googlechromelabs.github.io/chrome-for-testing/
    b.	Select a stable suitable chromedriver that matches the chrome you have installed (go to chrome > Help > about Chrome to get the correct version)
5.	Download the **REPO** now
    a.	Go to File > Project Structure  Project Settings opens.
    b.	Go to Modules > Dependencies > 
    c.	Click on Module Source
    d.	Click on button PLUS > select JARs or Directories
        i.	Locate the selenium download and add all the JAR files (only)
        ii.	Locate the lib and add all the JAR files.
6.	Set Browser driver - 
    a.	Add the browser drivers to folder – src/_macDrivers or src/_winDrivers
    b.	Update the file helpers/browser path for chrome.
<img width="567" alt="path" src="https://github.com/SriluBalla/Srilu-Selenium-JAVA/assets/106475342/fdec8841-cc5e-4957-9696-a5ec82fe6abc">

________________________________________________________________
**BEFORE you RUN the TEST**
1.	Go to file helpers/browser and update the default browser
<img width="531" alt="selectBrowser" src="https://github.com/SriluBalla/Srilu-Selenium-JAVA/assets/106475342/ae8ac98e-8aba-4409-abab-7811bdfe54ea">     

3.	Go to file helpers/constants and update the update the location of the filePath.
    a.	The screenshots folder will add a folder for the current date and log the images in them. Images will be overwritten.
<img width="849" alt="Screenshots" src="https://github.com/SriluBalla/Srilu-Selenium-JAVA/assets/106475342/efd729fe-d4be-4476-aeb4-5385a7da887e">
   
**gSearch**
1.	Selected browser open and go to Google.com and verifies the title
2.	Searches with the key work provided.
3.	And goes to every link on the page.
    a.	Prints the URL
    b.	Prints the title
    c.	Saves the screenshot of the page with the title of the page.
4.	 Closes the browser.

**useArrays**
1.	Update the number  string in helpers/constants
2.	Run the file  Prints the numbers as per the functions

