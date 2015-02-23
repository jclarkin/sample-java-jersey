package com.jrclarkin;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {

	// Base URI the server will listen on
    public static final String BASE_URI = "http://localhost:8084/myapp/";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers in a package
        final ResourceConfig resourceConfig = new ResourceConfig().packages("com.jrclarkin");

        // Instantiate the server
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig);
        
        // Register the server shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.shutdownNow();
            }
        }, "shutdownHook"));

		return server;
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HttpServer server = startServer();
        
        server.start();
        System.out.println(String.format("Jersey app started with WADL available at %sapplication.wadl", BASE_URI));
        
        Thread.currentThread().join();
    }
}

