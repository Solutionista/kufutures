package online.sterz.app.services;

import com.bybit.api.client.config.BybitApiConfig;
import com.bybit.api.client.restApi.BybitApiTradeRestClient;
import com.bybit.api.client.service.BybitApiClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BybitService {

    @Value(value = "${auth.bybitkey}")
    private String key;

    @Value(value = "${auth.bybitsecret}")
    private String secret;

    public BybitService() {
        var client = BybitApiClientFactory.newInstance(key, secret, BybitApiConfig.MAINNET_DOMAIN).newUserRestClient();
    }


}
