package co.edu.umanizales.lde_leds.model;

import jakarta.xml.soap.Node;
import lombok.Data;
@Data
public class ListDELed {

    private Node head;
    private int Led;

    public void searchAndToggleLED() throws InterruptedException {
        Node slowPtr = head;
        Node fastPtr = head;
        boolean found = false;

        // Move fast pointer two steps at a time
        while (fastPtr != null && fastPtr.getNext() != null) {
            slowPtr = slowPtr.getNext();
            fastPtr = fastPtr.getNext().getNext();
        }

        // Check if middle node contains an LED
        if (slowPtr.getData() instanceof Led) {
            Led middleLED = (Led) slowPtr.getData();
            middleLED.turnOn();
            middleLED.setLastOnTime(System.currentTimeMillis());
            Thread.sleep(1000); // Wait one second
            middleLED.turnOff();
        }

        // Traverse list forwards from middle node
        Node current = slowPtr.getNext();
        while (current != null) {
            if (current.getData() instanceof Led) {
                Led led = (Led) current.getData();
                led.turnOn();
                led.setLastOnTime(System.currentTimeMillis());
                Thread.sleep(1000); // Wait one second
                led.turnOff();
            }
            current = current.getNext();
        }

        // Traverse list backwards from middle node
        current = slowPtr.getPrev();
        while (current != null) {
            if (current.getData() instanceof Led) {
                Led led = (Led) current.getData();
                led.turnOn();
                led.setLastOnTime(System.currentTimeMillis());
                Thread.sleep(1000); // Wait one second
                led.turnOff();
            }
            current = current.getPrev();
        }
    }

}
