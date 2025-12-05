package org.example.demo.llm.car;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Validated
public class CarTool {

    private static final Logger log = LoggerFactory.getLogger(CarTool.class);

    private final CarDataset carDataset;

    @Tool(
            name = "get_car_info",
            description = "با استفاده از نام فارسی ماشین، مشخصات آن را برمی‌گرداند."
    )
    public Map<String, Object> getCarInfo(GetCarInfoInput input) {

        return carDataset.getCars().stream()
                .filter(c -> c.name.equalsIgnoreCase(input.car_name()))
                .findFirst()
                .map(car -> {
                    Map<String, Object> result = new LinkedHashMap<>();
                    result.put("name", car.name);
                    result.put("manufacturer", car.manufacturer);
                    result.put("engine_power_hp", car.engine_power_hp);
                    result.put("fuel_consumption_per_100km", car.fuel_consumption_per_100km);
                    result.put("body_type", car.body_type);
                    log.info("get_car_info called for '{}'", input.car_name());
                    return result;
                })
                .orElse(Map.of("error", "Car not found: " + input.car_name()));
    }

    @Tool(
            name = "get_cars_by_manufacturer",
            description = "لیست نام ماشین‌هایی که توسط یک سازنده‌ی فارسی ساخته شده‌اند را برمی‌گرداند."
    )
    public List<String> getCarsByManufacturer(GetCarsByManufacturerInput input) {

        List<String> result = carDataset.getCars().stream()
                .filter(c -> c.manufacturer.equalsIgnoreCase(input.manufacturer()))
                .map(c -> c.name)
                .collect(Collectors.toList());

        log.info("get_cars_by_manufacturer called for '{}', found {}", input.manufacturer(), result.size());
        return result;
    }
}

