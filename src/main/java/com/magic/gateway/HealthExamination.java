package com.magic.gateway;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author Magic
 * @version V1.0.0
 * @Description:
 * @date 2021/3/14 22:39
 */
public class HealthExamination implements IPing {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public boolean isAlive(Server server) {
        String url = "http://" + server.getId() + "/actuator/health";
        try
        {
            ResponseEntity<String> heath = restTemplate.getForEntity(url, String.class);
            if (heath.getStatusCode() == HttpStatus.OK)
            {
                System.out.println("ping " + url + " success and response is " + heath.getBody());
                return true;
            }
            System.out.println("ping " + url + " error and response is " + heath.getBody());
            return false;
        }
        catch (Exception e)
        {
            System.out.println("ping " + url + " failed");
            return false;
        }
    }
}
