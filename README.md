# seleniumPageObject
<p style="padding-left: 40px; text-align: justify;"><strong>Запуск тестов и отчетов</strong></p>
<p>local</p>
<pre>mvn <span class="pl-c1">test</span> -P web-execution -D testng.dtd.http=true<br /><br /></pre>
<p>parallel</p>
<pre>mvn test -P web-execution -D suite=parallel -Dtestng.dtd.http=true </pre>
<p>Generate allure report;</p><pre>allure serve target/allure-results</pre></p>
<p>Стек:&nbsp; <strong>Java, Selenium, Alure, TestNG, </strong>log4j,&nbsp;<strong>Maven.</strong></p>
<p>основная архитектура тестового проекта- </p>
<p>В конструкторе класса MyApp вызываются все тестовые классы (LoginPage, ImageBroken and etc), &nbsp;в классе PageBaseTest&nbsp; в методе setUp(@BeforeMethod) создается только объект <strong>MyApp</strong> из которого и достаются нужные классы и методы.&nbsp;</p>
<p>Example</p>
<pre>@BeforeMethod<br />public void setUp(@Optional("chrome") String browser) {<br />    WebDriver driver = new TargetFactory().createInstance(browser);<br />    DriverManager.setDriver(driver);<br />    DriverManager.getDriver().get(configuration().url());<br />       myApp = new MyApp();<br />}</pre>
<pre>@Test (priority=4,testName=<span style="color: #339966;">"Download file"</span>,description="",alwaysRun = true)<br />public void testDownload() throws Exception {<br />    <span style="color: #ff00ff;">myApp</span>.downLoad.goPage();<br />    <span style="color: #ff00ff;">myApp</span>.downLoad.clickDownload();<br />    <span style="color: #ff00ff;">myApp</span>.downLoad.isFileDownloaded(<span style="color: #339966;">"/home/ivan/Downloads", "some-file.txt"</span>);<br />}</pre>
<p>&nbsp;</p>
<p><strong>WebDriver and browser:</strong><br />java/project/browser/<strong>BrowserFactory.java</strong> - класс enum с перечислением Browser type;<br />java/project/browser/<strong>Configuration.java</strong> - Owner отличная библиотека для работы с properties;<br />java/project/browser/<strong>ConfigurationManager.java</strong> - Позволяет объекту <strong>Config</strong> из библиотеки Owner получать доступ к содержимому полей класса Configuration.java для выполнения последующих операций;<br />java/project/browser/<strong>DriverManager.java</strong> - здесь определены методы getDriver, setDriver;<br />java/project/browser/<strong>TargetFactory.java</strong> - с помощью операторов switch and case определяем LOCAL or REMOTE цель запуска тестового проекта;</p>
