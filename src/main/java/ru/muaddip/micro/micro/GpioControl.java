package ru.muaddip.micro.micro;


import com.pi4j.io.gpio.*;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/gpio/")
@Api(tags = {"Gpio control"})
public class GpioControl {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private final GpioController gpioController = GpioFactory.getInstance();


    @RequestMapping(value = "/{gpio}/{command}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void sendTestMessage(@PathVariable("gpio") Gpio gpio, @PathVariable("command") GpioCommand command) throws InterruptedException {

        Pin pin = OrangePiPin.getPinByName(gpio.name());

        switch (command) {
            case ON:
                gpioController.provisionDigitalOutputPin(pin, PinState.HIGH);
            case OFF:
                gpioController.provisionDigitalOutputPin(pin, PinState.LOW);
        }

    }
}
