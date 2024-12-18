package com.crawling.stock.stock.controller.stockCrawling.service;

import com.crawling.stock.stock.controller.stockCrawling.dto.StockCrawlingResponseDto;
import com.crawling.stock.stock.util.Crawling;
import com.crawling.stock.stock.util.CrawlingSelenium;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockCrawlingService {

    private final Crawling crawling;

    private final CrawlingSelenium crawlingSelenium;

    public StockCrawlingResponseDto getStockInfo(String stockCode) {
        return crawling.getStockInfo(stockCode);
    }

    public StockCrawlingResponseDto getStockInfoBySelenium(String stockCode) throws Exception {
        return crawlingSelenium.getStockInfo();
    }

}
