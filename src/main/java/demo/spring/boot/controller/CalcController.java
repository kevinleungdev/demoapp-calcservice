package demo.spring.boot.controller;

import demo.spring.boot.service.CalcService;
import demo.spring.boot.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @Autowired
    CalcService calcService;

    @GetMapping("/sum")
    public Map<String, String> sum(@RequestParam String params) {
        Objects.requireNonNull(params, "params must be not null");

        Map<String, String> results = new LinkedHashMap<>();
        results.put("service host", Util.getHostname());
        results.put("service address", Util.getHostAddress());
        results.put("service version", calcService.version());
        results.put("result", String.valueOf(calcService.sum(Arrays.stream(params.split(",")).mapToInt(Integer::parseInt).toArray())));

        return results;
    }
}
