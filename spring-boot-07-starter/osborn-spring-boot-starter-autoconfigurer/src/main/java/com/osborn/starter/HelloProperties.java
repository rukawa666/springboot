package com.osborn.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hanqh
 * @version 1.0
 * @createdate 2018-11-13 23:41
 */
@ConfigurationProperties(prefix = "osborn.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
