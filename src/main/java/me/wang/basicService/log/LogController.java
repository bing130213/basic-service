package me.wang.basicService.log;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbing
 * @date 2021/1/7
 */
@RestController
@Slf4j
public class LogController {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @GetMapping("/index")
    public Object index() {
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        log.debug("slf4j debug");
        return "success";
    }
}
