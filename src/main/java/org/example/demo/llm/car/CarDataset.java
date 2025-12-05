package org.example.demo.llm.car;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDataset {

    private static final Logger log = LoggerFactory.getLogger(CarDataset.class);

    private final ObjectMapper mapper = new ObjectMapper();
    private List<Car> cars = new ArrayList<>();

    @PostConstruct
    public void load() throws Exception {
        cars = mapper.readValue(
                CarDataset.class.getResourceAsStream("/cars.json"),
                new TypeReference<>() {}
        );
        log.info("Loaded cars: {}", cars.size());
    }

    public List<Car> getCars() {
        return cars;
    }
}

