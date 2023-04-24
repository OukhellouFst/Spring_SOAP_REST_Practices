package ma.dsbd.banqueservice;

import ma.dsbd.banqueservice.web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@Configuration
public class MyConfig {
    //@Bean
    public ResourceConfig resourceConfig() {
        ResourceConfig jersyServlet = new ResourceConfig();
        jersyServlet.register(CompteRestJaxRSAPI.class);
        return jersyServlet;
    }

    @Bean
    SimpleJaxWsServiceExporter serviceExporter() {
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8888/");
        return serviceExporter;
    }
}
