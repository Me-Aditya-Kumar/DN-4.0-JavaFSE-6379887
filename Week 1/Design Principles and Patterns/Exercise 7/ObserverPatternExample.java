import java.util.*;

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update(String stockName, double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}

class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(appName + " - Stock Update: " + stockName + " is now ₹" + price);
    }
}

class WebApp implements Observer {
    private String websiteName;

    public WebApp(String websiteName) {
        this.websiteName = websiteName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(websiteName + " - Stock Update: " + stockName + " is now ₹" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();
        Observer mobileObserver = new MobileApp("StocksNow Mobile");
        Observer webObserver = new WebApp("MarketWatch Web");
        market.registerObserver(mobileObserver);
        market.registerObserver(webObserver);
        System.out.println("\nUpdating stock prices...\n");
        market.setStock("TCS", 3675.50);
        market.setStock("INFY", 1499.00);
        market.removeObserver(webObserver);
        System.out.println("\nWeb app unsubscribed...\n");
        market.setStock("WIPRO", 462.75);
    }
}
