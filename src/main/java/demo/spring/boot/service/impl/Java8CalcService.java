package demo.spring.boot.service.impl;

import demo.spring.boot.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
@ConditionalOnProperty(name = "service.calc", havingValue = "java8")
public class Java8CalcService implements CalcService {

    @Override
    public int sum(int... values) {
        log.info("Java8 calculate service!");
        return Arrays.stream(values).reduce(0, Integer::sum);
    }

    @Override
    public String version() {
        return "java8";
    }
}
