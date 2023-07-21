import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 1. Visit the URL Konga
   a. Maximise the browser
 2. Sign in to Konga Successfully
   a. Click on sign in button
 3. From the Categories, click on the “Computers and Accessories”
 4. Click on the Laptop SubCategory
 5. Click on the Apple MacBooks
 6. Add an item to the cart
 7. Select Address
 8. Continue to make payment
 9. Select a Card Payment Method
 10.Input invalid card details
 11. Print Out the error message: Invalid card number
 12. Close the iFrame that displays the input card Modal
 13. Quit the browser.
 14. That’s all
 *
 */




    public class PlaceOrderTest {

            private WebDriver driver;
             // Import the selenium webdriver
            @BeforeTest
            public void start() throws InterruptedException {
            System.setProperty("webriver.chrome.driver", "resources/chromediver.exe");
            //Locate browser

            driver = new ChromeDriver();
            //Open chrome browser

            driver.get("https://www.konga.com/");
            //Input the url

            //Verify the user input the correct url and he/she is on the right webpage
            if(driver.getCurrentUrl().contains("https://www.konga.com/"))
            //passed
                    System.out.println("User Input the correct url and the user is on the right webpage");
            else
               //failed
                        System.out.println("User Input the wrong Url and the user is on the wrong webpage");

            driver.manage().window().maximize();
            //Maximise the browser
            Thread.sleep(5000);
            //Wait for few seconds

            }

            @Test (priority = 0)
            public void signin() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
            //Click on Login/Signup button
            Thread.sleep(3000);

            driver.findElement(By.name("username")).sendKeys("las2made@gmail.com");
            //Input the username

            driver.findElement(By.name("password")).sendKeys("Dele@4128");
            //Input password

            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            //Click on login button
            Thread.sleep(15000);
            //Wait for few seconds
            }

            @Test (priority = 1)
            public void AddItem() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
            //Click on Computers and Accessories
            Thread.sleep(6000);

            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).click();
            //Click on Laptops
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
            //Click on the Apple macbooks
            Thread.sleep(6000);

            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[4]/div/div/div[2]/form/div[3]/button")).click();
            //Add an item to cart
            Thread.sleep(5000);
            }

            @Test (priority = 2)
            public void checkoutCart() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
            //Click on my cart

            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
            //Click on checkout
            Thread.sleep(10000);
            }

            @Test (priority = 3)
            public void selectAddress() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
            //Change Address
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
            //Click on add new delivery Address
            Thread.sleep(5000);

            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[2]/form/button")).click();
            //Select one  of the available address
            Thread.sleep(6000);

            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div")).click();
            //Click on use this Address
            Thread.sleep(10000);

            }

            @Test (priority = 4)
            public void Payment() throws InterruptedException {
            driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span")).click();
            //Select Pay now as payment method
            Thread.sleep(3000);

            driver.findElement(By.name("placeOrder")).click();
            //Click continue to payment
            Thread.sleep(20000);

            // Switch to iframe  //*[@id="kpg-frame-component"]
            By locIframe = By.xpath("//*[@id=\"kpg-frame-component\"]");
            driver.switchTo().frame(driver.findElement(locIframe));

            driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();
            //Select Card as payment option
            Thread.sleep(5000);

            driver.findElement(By.id("card-number")).sendKeys("5594324038666704");
            //Input card number

            driver.findElement(By.id("expiry")).sendKeys("0324");
            //Input card expiry date

            driver.findElement(By.id("cvv")).sendKeys("341");
            //Input cvv number

            driver.findElement(By.id("card-pin-new")).sendKeys("0630");
            //Input card pin

            driver.findElement(By.id("validateCardForm")).click();
            //Click on pay now
            Thread.sleep(4000);

            //Verify that the user input valid card details
            if (driver.findElement(By.id("card-number_unhappy")).isDisplayed())
            System.out.println("Invalid card details");
            //To print invalid card

            else System.out.println("Valid details supplied");
            driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();
            //Close the iFrame that displays the input card Modal
            }

            @AfterTest
            public void close(){
            driver.quit();
            //Quit browser

            }

    }



