package com.crawling.stock.stock.controller.stockCrawling;

import com.crawling.stock.stock.controller.stockCrawling.dto.StockCrawlingResponseDto;
import com.crawling.stock.stock.controller.stockCrawling.service.StockCrawlingService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/crawling")
@RequiredArgsConstructor
public class StockCrawlingController {

    private final StockCrawlingService stockCrawlingService;

    @GetMapping("/jsoup/stock/{stockCode}")
    public ResponseEntity<StockCrawlingResponseDto> getStockInfo(@PathVariable String stockCode) {
        return Optional.ofNullable(stockCrawlingService.getStockInfo(stockCode))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
    }

    @GetMapping("/selenum/stock/{stockCode}")
    public ResponseEntity<StockCrawlingResponseDto> getStockInfoBySelenium(@PathVariable String stockCode) throws Exception {
        return Optional.ofNullable(stockCrawlingService.getStockInfoBySelenium(stockCode))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build());

    }
}
