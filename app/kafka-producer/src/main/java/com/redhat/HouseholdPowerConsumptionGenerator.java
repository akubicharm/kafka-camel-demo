package com.redhat;


import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * https://github.com/tme-osx/TME-AIX/blob/main/smartgrid/data/household_power_consumption_with_anomalies.txt
 */
@Component("householdPower")
public class HouseholdPowerConsumptionGenerator {
    
    public String generateConsumption() {
        String datetime;
        double global_active_power; // 0 - 5
        double global_reactive_power; // 0 - 1
        double voltage; // 220-240
        double global_intensity; // 0 - 20
        double sub_metering_1; // 0 - 19
        double sub_metering_2; // 0 - 19
        double sub_metering_3; // 0 - 19

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        datetime = sdf.format(Calendar.getInstance().getTime());     // Calendar.getInstance().getTime().toString();
        global_active_power = Math.random() * 5;
        global_reactive_power = Math.random();
        voltage = 220 + Math.random() * 20;
        global_intensity = Math.random() * 20;
        sub_metering_1 = Math.random() * 19;
        sub_metering_2 = Math.random() * 19;
        sub_metering_3 = Math.random() * 19;

        StringBuffer sb = new StringBuffer();
        sb.append(datetime).append(",").append(global_active_power).append(",").append(global_reactive_power).append(",").append(voltage).append(",").append(global_intensity).append(",").append(sub_metering_1).append(",").append(sub_metering_2).append(",").append(sub_metering_3);

        return sb.toString();
    }    

    public static void main(String[] args) {
        HouseholdPowerConsumptionGenerator generator = new HouseholdPowerConsumptionGenerator();
        System.out.println(generator.generateConsumption());
    }
}
