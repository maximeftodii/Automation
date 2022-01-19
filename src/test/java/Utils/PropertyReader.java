package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private final Properties properties;

    public PropertyReader() {
        BufferedReader reader;
        String propertyFilePath = "src/main/resources/property.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("property.properties not found at " + propertyFilePath);
        }
    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) return driverPath;
        else throw new RuntimeException("driverPath not specified in the property.properties file.");
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the property.properties file");
    }

    public String getUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("URL not specified in the property.properties file.");
    }

    public String getAuthUrl() {
        String authUrl = properties.getProperty("authUrl");
        if (authUrl != null) return authUrl;
        else throw new RuntimeException("Authentication URL not specified in the property.properties file.");
    }

    public String getLogin() {
        String login = properties.getProperty("login");
        if (login != null) return login;
        else throw new RuntimeException("Login not specified in the property.properties file");
    }

    public String getRegUrl() {
        String regUrl = properties.getProperty("regUrl");
        if (regUrl != null) return regUrl;
        else throw new RuntimeException("Register URL not specified in the property.properties file");
    }

    public String getMyAccountUrl() {
        String myAcc = properties.getProperty("myAcc");
        if (myAcc != null) return myAcc;
        else throw new RuntimeException("Account URL not specified in the property.properties file");
    }

    public String getCartUrl() {
        String cartUrl = properties.getProperty("cartUrl");
        if (cartUrl != null) return cartUrl;
        else throw new RuntimeException("Cart URL not specified in the property.properties file");
    }

    public String getAddressReview() {
        String addressReview = properties.getProperty("addressReview");
        if (addressReview != null) return addressReview;
        else throw new RuntimeException("Address review URL not specified in the property.properties file");
    }

    public String getPaymentUrl() {
        String paymentUrl = properties.getProperty("paymentUrl");
        if (paymentUrl != null) return paymentUrl;
        else throw new RuntimeException("Payment URL not specified in the property.properties file");
    }

    public String getConfirmOrderUrl() {
        String confirmOrderUrl = properties.getProperty("confirmOrderUrl");
        if (confirmOrderUrl != null) return confirmOrderUrl;
        else throw new RuntimeException("Order confirm URL si not specified in the property.properties file");
    }
}
