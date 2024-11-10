package com.crawling.stock.stock.exception.handler;

import com.crawling.stock.stock.exception.exception.StockCrawlingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        log.error("Internal server error: {}", e.getMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("시스템 에러 발생");
    }

    @ExceptionHandler(StockCrawlingException.class)
    public ResponseEntity<String> handleStockCrawlingException(StockCrawlingException sce) {
        log.error("Stock Crawling error : {}", sce.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body("크롤링 실패");
    }
}
