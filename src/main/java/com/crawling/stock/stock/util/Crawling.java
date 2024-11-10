package com.crawling.stock.stock.util;

import com.crawling.stock.stock.controller.stockCrawling.dto.StockCrawlingResponseDto;
import com.crawling.stock.stock.exception.exception.StockCrawlingException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Crawling {

    public StockCrawlingResponseDto getStockInfo(String stockCode) {

        try {
            String url = "https://finance.naver.com/item/main.nhn?code=" + stockCode;
            Document doc = Jsoup.connect(url).get();
            System.out.println("doc = " + doc);
            System.out.println("doc = " + doc.toString());
            System.out.println("doc = " + doc.stream().toArray());

            return new StockCrawlingResponseDto(doc.toString(), null);
        } catch (Exception e) {
            log.error(e.getMessage());

            throw new StockCrawlingException("error");
        }
    }
}
