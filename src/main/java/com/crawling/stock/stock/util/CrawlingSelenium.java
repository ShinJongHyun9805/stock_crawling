package com.crawling.stock.stock.util;


import com.crawling.stock.stock.controller.stockCrawling.dto.StockCrawlingResponseDto;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Slf4j
@Component
public class CrawlingSelenium {

    public StockCrawlingResponseDto getStockInfo() throws Exception {

        WebDriver driver = new ChromeDriver();

        try {
            // WebDriverManager로 ChromeDriver 자동 설정
            WebDriverManager.chromedriver().setup();

            driver.get("https://finance.naver.com/item/fchart.naver?code=005930");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // 이동평균선 데이터가 있는 특정 요소를 기다림 (CSS 선택자 수정 필요)
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".stx-holder")));

            // 이동평균선 데이터가 있는 요소들 찾기
            List<WebElement> movingAverageElements = driver.findElements(By.cssSelector(".stx-holder .stx-subholder .stx-panel-control"));

            // 데이터 출력
            for (WebElement element : movingAverageElements) {
                System.out.println("=====================" + element.toString()); // 필요시 텍스트가 아닌 다른 속성 추출
            }

        } catch (Exception e) {
            log.error(e.getMessage());

            throw new Exception(e.getMessage());
        } finally {
            driver.quit();
        }

        return null;
    }
}
