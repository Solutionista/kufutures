package online.sterz.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class TickerResponse {

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("topic")
    private String topic;

    @JsonProperty("data")
    private Data data;


    public String getSubject() {
        return subject;
    }

    public String getTopic() {
        return topic;
    }

    public Data getData() {
        return data;
    }

    public static class Data {

        @JsonProperty("symbol")
        private String symbol;

        @JsonProperty("bestBidSize")
        private int bestBidSize;

        @JsonProperty("bestBidPrice")
        private BigDecimal bestBidPrice;

        @JsonProperty("bestAskPrice")
        private BigDecimal bestAskPrice;

        @JsonProperty("bestAskSize")
        private int bestAskSize;

        @JsonProperty("ts")
        private long ts;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public BigDecimal getBestBidPrice() {
            return bestBidPrice;
        }
        public int getBestBidSize() {
            return bestBidSize;
        }

        public void setBestBidSize(int bestBidSize) {
            this.bestBidSize = bestBidSize;
        }

        public void setBestBidPrice(BigDecimal bestBidPrice) {
            this.bestBidPrice = bestBidPrice;
        }

        public BigDecimal getBestAskPrice() {
            return bestAskPrice;
        }

        public void setBestAskPrice(BigDecimal bestAskPrice) {
            this.bestAskPrice = bestAskPrice;
        }

        public int getBestAskSize() {
            return bestAskSize;
        }

        public void setBestAskSize(int bestAskSize) {
            this.bestAskSize = bestAskSize;
        }

        public long getTs() {
            return ts;
        }

        public void setTs(long ts) {
            this.ts = ts;
        }

        // getters and setters
    }
}