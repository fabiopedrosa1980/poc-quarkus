package br.com.pedrosa.resource;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Random;

import static java.util.concurrent.TimeUnit.SECONDS;

@Path("/fault")
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name="Tolerancia a Falhas")
public class ToleranciaFalhaResource {

    @Timeout(1000) //indicado para client de outros ms
    @Fallback(fallbackMethod = "fallback")
    @GET
    @Path("timeout")
    @Produces({MediaType.TEXT_PLAIN})
    public String timeout() throws InterruptedException {
        SECONDS.sleep(2l);
        return "timeout";
    }

    @Retry(maxRetries = 2) //indicado para client de outros ms
    @Fallback(fallbackMethod = "fallback")
    @GET
    @Path("retry")
    @Produces({MediaType.TEXT_PLAIN})
    public String retry() {
        if(new Random().nextBoolean()){
            throw new RuntimeException("Ops deu ruim");
        }
        return "retry";
    }

    @CircuitBreaker(requestVolumeThreshold = 4,
            failureRatio = 0.1,
            delay = 10000,
            successThreshold = 10)//indicado para client de outros ms
    @Fallback(fallbackMethod = "fallback")
    @GET
    @Path("circuit")
    @Produces({MediaType.TEXT_PLAIN})
    // 3 estados Fechado | Meio Aberto | Aberto
    public String circuitBreak() {
        if(new Random().nextInt(3) >= 2){
            throw new RuntimeException("Ops deu ruim");
        }
        return "circuit";
    }

    public String fallback() {
        return "failback";
    }

}
