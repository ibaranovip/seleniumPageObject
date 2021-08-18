package app.pages;

import app.browser.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DownLoad {

    By linkGoPage = By.linkText("File Download");
    By linkDownLoad = By.linkText("some-file.txt");
    String Input;
    String fileDown;



    public DownLoad goPage() {
        DriverManager.getDriver().findElement(linkGoPage).click();
        return new DownLoad( );
    }

    public void clickDownload() {
        DriverManager.getDriver().findElement(linkDownLoad).click();

    }


    public void isFileDownloaded(String fileDownloadpath, String fileName) throws Exception {


        this.Input = fileName;
        this.fileDown = fileDownloadpath;


        Path path = FileSystems.getDefault().getPath(fileDownloadpath);

        if (Files.exists(path) && Files.isDirectory(path)) {
            int maxDeptch = 1;
            try (Stream<Path> streamDirv = Files.find(path, maxDeptch, (p, a) -> String.valueOf(p).endsWith(fileName))) {
                Long counter = streamDirv
                        .map(String::valueOf)
                        .peek(System.out::println)
                        .count();
                System.out.println("Found:  " + counter);
                try {
                    File file = new File(fileDownloadpath, fileName);
                    file.delete(); //удаление  файла перед последующим запуском test
                    System.out.println(fileName+" delited");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("not delited");
                }


                // действия, если папка существует
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("such derectory not exist");
        }
    }
  }




