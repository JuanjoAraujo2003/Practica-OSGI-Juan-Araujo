package com.example;

public class NotificationServiceImpl implements NotificationService {

    public void sendNotification(String message) {
        System.out.println("Notificacion Enviada: " + message);
    }
}
