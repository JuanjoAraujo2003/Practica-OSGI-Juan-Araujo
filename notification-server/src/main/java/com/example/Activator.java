package com.example;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
    private ServiceRegistration<NotificationService> registration;
    private ServerEventGenerator eventGenerator;


    public void start(BundleContext context) throws Exception {
        NotificationService service = new NotificationServiceImpl();
        registration = context.registerService(NotificationService.class, service, null);
        eventGenerator = new ServerEventGenerator(service);
        eventGenerator.start();
        System.out.println("Notificacion registrada correctamente");
    }


    public void stop(BundleContext context) throws Exception {
        registration.unregister();
        System.out.println("Notificación no registrada.");
    }
}
