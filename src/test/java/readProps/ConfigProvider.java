package readProps;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    String URL = readConfig().getString("url");

    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }
}
