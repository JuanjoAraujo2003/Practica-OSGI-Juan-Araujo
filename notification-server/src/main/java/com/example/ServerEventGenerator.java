package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class ServerEventGenerator {
    private NotificationService notificationService;
    private int alertCount = 0;
    private final int maxAlerts = 7;

    public ServerEventGenerator(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void start() {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (alertCount < maxAlerts) {
                    notificationService.sendNotification("Evento de servidor en proceso!");
                    alertCount++;
                } else {
                    timer.cancel();
                }
            }
        }, 0, 5000); // Genera un evento cada 5 segundos
    }
}
