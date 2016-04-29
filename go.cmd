rem java org.testng.TestNG -suitethreadpoolsize 2 testng_medline_single_chrome.xml testng_medline_single_firefox.xml

cd C:\MAVEN\MedlineTestProject\

java -cp C:\MAVEN\MedlineTestProject\lib\*; org.testng.TestNG C:\MAVEN\MedlineTestProject\src\test\resources\testng.xml

pause