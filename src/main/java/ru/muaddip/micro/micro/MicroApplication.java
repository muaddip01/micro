package ru.muaddip.micro.micro;

import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroApplication {

    public static void main(String[] args) throws PlatformAlreadyAssignedException {
        SpringApplication.run(MicroApplication.class, args);
        PlatformManager.setPlatform(Platform.ORANGEPI);
    }
}
