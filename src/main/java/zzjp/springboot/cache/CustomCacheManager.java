package zzjp.springboot.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * Created by lukasz on 4/26/17.
 */
@Component
@ManagedResource(objectName = "custom.cache:type=CustomCacheManager")
public class CustomCacheManager {

    private Logger logger = LoggerFactory.
            getLogger(CustomCacheManager.class);

    @ManagedOperation(description = "clears all players cache. Use when refresh necessary")
    @CacheEvict(CacheConstants.PLAYERS_CACHE)
    public void clearPlayersCache() {
        logger.debug("clearing players cache....");
    }



}
