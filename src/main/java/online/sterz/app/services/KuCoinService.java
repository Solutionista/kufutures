package online.sterz.app.services;

import com.kucoin.futures.core.KucoinFuturesClientBuilder;
import com.kucoin.futures.core.KucoinFuturesPrivateWSClient;
import com.kucoin.futures.core.KucoinFuturesPublicWSClient;
import com.kucoin.futures.core.KucoinFuturesRestClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Properties;

@Service
public class KuCoinService {

//    @Value(value = "${auth.kukey}")
    private String api; // = environment.getProperty("auth.kukey");

//    @Value(value = "${auth.kusecret}")
    private String secret; // = environment.getProperty("auth.kusecret");

//    @Value(value = "${auth.passphrase}")
    private String pass; // = environment.getProperty("auth.passphrase");

    public KucoinFuturesRestClient kucoinFuturesRestClient;
    public KucoinFuturesPrivateWSClient kucoinFuturesPrivateWSClient;
    public KucoinFuturesPublicWSClient kucoinFuturesPublicWSClient;

    public KuCoinService() {

        setVariables();
        KucoinFuturesClientBuilder builder = new KucoinFuturesClientBuilder()
                .withBaseUrl("https://api-futures.kucoin.com")
                .withApiKey(api, secret, pass, "v2");
        kucoinFuturesRestClient = builder.buildRestClient();
        try {
            kucoinFuturesPrivateWSClient = builder.buildPrivateWSClient();
            kucoinFuturesPublicWSClient = builder.buildPublicWSClient();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        }

    private void setVariables() {
        Resource resource = new ClassPathResource("/application.properties");
        Properties props = null;
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        api = props.getProperty("auth.kukey");
        secret = props.getProperty("auth.kusecret");
        pass = props.getProperty("auth.passphrase");
    }

}

