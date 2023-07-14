import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
   Flow of the task
    1. Open your chrome browser
    2.Input the url
    3.Maximise the browser
    4.Click on signup page
    5.Input Username in the username input field
    6.Input Mail address in email input field
    7.Input password
    8.Click the signup button
    9.Click User1 item on the list
    10.Confirm selenium with python is present
    11.Logout

    Test cases
    1.Verify that the user input the correct url and the user is on the right webpage
    2.Verify that the user is directed to the signup page upon clicking the signup button
    3.Verify that the user cannot signup with username less than three characters
    4.Verify that the user cannot signup with an invalid email
    5.Verify that the user cannot signup with password less than or equal to one character
    6.Verify that the user cannot signup with either/all of the input fields blank
    7.Verify that the user can signup successfully with valid details
    8.Verify that the item list page url is correct
    9.Verify that the item searched for on the meaghan's page is present
    10.Verify that the user is directed to the home page when he/she logout
 */




public class SeleniumWebSignupTest {
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate webdriver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        //Open your chrome browser
        driver = new ChromeDriver();
        //Input the url
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test.1.Verify that the user input the correct url and the user is on the right webpage
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //passed
            System.out.println("User input the correct url and is on the right webpage");
        else
            //Failed
            System.out.println("User input wrong url and is on the wrong webpage");
        Thread.sleep(5000);
        //Maximise the browser
        driver.manage().window().maximize();
        // 4.Click on signup page
        Thread.sleep(5000);
        }

        @Test (priority = 0)
        public void positivesignup() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            //Test.2 Verify that the user is directed to the signup page upon clicking the signup button
            Thread.sleep(5000);
            // 5.Input Username in the username input field
            driver.findElement(By.id("user_username")).sendKeys("sunma011");
            //6.Input Mail address in email input field
            driver.findElement(By.id("user_email")).sendKeys("la001mad@mailinator.com");
            //7.Input password
            driver.findElement(By.id("user_password")).sendKeys("admin");
            //8.Click the signup button
            driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
            //Test.7.Verify that the user can signup successfully with valid details
            Thread.sleep(5000);
        }



        @Test (priority = 1)
        public void clickUser1item() throws InterruptedException {
            //9.Click User1 item
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
            //Test 8.Verify that the item list page url is correct
            String expectedurl = "https://selenium-blog.herokuapp.com/users/1";
            String actualurl = driver.getCurrentUrl();
            if(actualurl.contains("https://selenium-blog.herokuapp.com/users/1"))
                //Passed
                System.out.println("Correct webpage");
            else
                //Failed
                System.out.println("wrong webpage");
            Thread.sleep(5000);
        }

        @Test (priority = 2)
        public void verifyitem() throws InterruptedException {
            //11.Confirm selenium with python is present
            driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
            //Test 9.Verify that the item searched for on the meaghan's page is present
            Thread.sleep(5000);
        }

        @Test (priority = 3)
        public void logout1() throws InterruptedException {
            //12.Log out
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]")).click();
            //Test.10.Verify that the user is directed to the home page when he/she logout
            String expectedtitle = "AlphaBlog";
            String actualtitle = driver.getTitle();
            if(actualtitle.contains("AlphaBlog"))
                //Passed
                System.out.println("Correct webpage");
            else
                //Failed
                System.out.println("wrong webpage");
            Thread.sleep(5000);
        }

        @Test (priority = 4)
         public void negativesignupPassword() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            // 5.Input Username in the username input field
            driver.findElement(By.id("user_username")).sendKeys("sou170");
            driver.findElement(By.id("user_email")).sendKeys("las059mde@mailinator.com");
            //7.Input password
            driver.findElement(By.id("user_password")).sendKeys("1");
            //Test 5.Verify that the user cannot signup with password less than or equal to one character
            //8.Click the signup button
            driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
            Thread.sleep(5000);
            }

            @Test (priority = 5)
            public void logout2() throws InterruptedException {
             //12.Log out
            driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]")).click();
            Thread.sleep(5000);
            }

        @Test (priority = 6)
        public void negativesignupUsername() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
            Thread.sleep(5000);
            // 5.Input Username in the username input field
             driver.findElement(By.id("user_username")).sendKeys("sb");
            // Test 3.Verify that the user cannot signup with username less than three characters

             //6.Input Mail address in email input field
            driver.findElement(By.id("user_email")).sendKeys("las0040mad@gmail.com");
             //7.Input password
             driver.findElement(By.id("user_password")).sendKeys("admin");
            //8.Click the signup button
             driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
            Thread.sleep(5000);
        }

    @Test (priority = 7)
    public void negativesignupemail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // 5.Input Username in the username input field
        driver.findElement(By.id("user_username")).sendKeys("soun050");
        //6.Input Mail address in email input field
        driver.findElement(By.id("user_email")).sendKeys("las0601made");
        //7.Input password
        driver.findElement(By.id("user_password")).sendKeys("admin");
        //8.Click the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //
        Thread.sleep(5000);
    }

    @Test (priority = 8)
    public void negativesignupBlankname() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // 5.Input Username in the username input field
        driver.findElement(By.id("user_username")).sendKeys("");
        //6.Input Mail address in email input field
        driver.findElement(By.id("user_email")).sendKeys("dele0340@mailinator.com");
        //7.Input password
        driver.findElement(By.id("user_password")).sendKeys("2222");
        //8.Click the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //6.Verify that the user cannot signup with either/all of the input fields blank
        Thread.sleep(5000);
    }

    @Test (priority = 9)
    public void negativesignupBlankemail() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // 5.Input Username in the username input field
        driver.findElement(By.id("user_username")).sendKeys("Gab02");
        //6.Input Mail address in email input field
        driver.findElement(By.id("user_email")).sendKeys("");
        //7.Input password
        driver.findElement(By.id("user_password")).sendKeys("2222");
        //8.Click the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //6.Verify that the user cannot signup with either/all of the input fields blank
        Thread.sleep(5000);
    }

    @Test (priority = 10)
    public void negativesignupBlankPassword() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        // 5.Input Username in the username input field
        driver.findElement(By.id("user_username")).sendKeys("Moses012");
        //6.Input Mail address in email input field
        driver.findElement(By.id("user_email")).sendKeys("de109@mailinator.com");
        //7.Input password
        driver.findElement(By.id("user_password")).sendKeys("");
        //8.Click the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        //6.Verify that the user cannot signup with either/all of the input fields blank
        Thread.sleep(5000);
    }
    @AfterTest
        public void close() {
            //quit the browser
            driver.quit();
        }
    }



