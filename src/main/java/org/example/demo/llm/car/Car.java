package org.example.demo.llm.car;

public class Car {
    public String name;
    public String manufacturer;
    public int engine_power_hp;
    public double fuel_consumption_per_100km;
    public String body_type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEngine_power_hp() {
        return engine_power_hp;
    }

    public void setEngine_power_hp(int engine_power_hp) {
        this.engine_power_hp = engine_power_hp;
    }

    public double getFuel_consumption_per_100km() {
        return fuel_consumption_per_100km;
    }

    public void setFuel_consumption_per_100km(double fuel_consumption_per_100km) {
        this.fuel_consumption_per_100km = fuel_consumption_per_100km;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }
}
