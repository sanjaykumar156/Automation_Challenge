# 🧪 Selenium Automation Framework (E-Commerce Flow)

This framework automates the order placement process on an e-commerce website using Java, Selenium WebDriver, and TestNG.

---

## 🚀 Features

- ✅ Page Object Model (POM) structure
- ✅ Base class with reusable methods
- ✅ Data-driven testing via `properties` file
- ✅ Extent Reports with screenshots on failure
- ✅ Explicit waits to handle dynamic elements
- ✅ Clean and scalable folder architecture

---

## 📂 Folder Structure

📁 AutomationFramework/
│
├── 📁 src/
│   ├── 📁 main/
│   │   ├── 📁 java/
│   │   │   ├── 📁 baseclass/
│   │   │   │   ├── BaseClass.java
│   │   │   │   ├── BasePage.java
│   │   │   │   ├── ConfigReader.java
│   │   │   │
│   │   │   ├── 📁 utilities/
│   │   │   │   ├── ExtentReportManager.java
│   │   │   │   ├── TestUtility.java
│   │
│   ├── 📁 test/
│   │   ├── 📁 java/
│   │   │   ├── 📁 pages/
│   │   │   │   ├── HomePage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │
│   │   │   ├── 📁 testcases/
│   │   │   │   ├── PlaceOrderTest.java
│   │   │   │
│   │   │   ├── 📁 testdata/
│   │   │       ├── testdata.properties
│
├── 📁 TestReports/
│   ├── ExtentReport.html
│   ├── ExtentReport_2025_04_07.html
│
├── 📁 Screenshots/
│   ├── failure_screenshot_1.png
│   ├── failure_screenshot_2.png
│
├── 📄 pom.xml
├── 📄 testng.xml
