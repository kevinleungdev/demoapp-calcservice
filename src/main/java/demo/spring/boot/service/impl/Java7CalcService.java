package demo.spring.boot.service.impl;

import demo.spring.boot.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ConditionalOnProperty(name = "service.calc", havingValue = "java7")
public class Java7CalcService implements CalcService {

    @Override
    public int sum(int... values) {
        log.info("Java7 calculate service!");

        int sum = 0;
        for (Integer v: values) {
            sum += v;
        }
        
        return sum;
    }

    @Override
    public String version() {
        return "java7";
    }
}
