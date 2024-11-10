package com.crawling.stock.stock.controller.stockCrawling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockCrawlingRequestDto {

    private String stockName;

    private String currentPrice;
}
