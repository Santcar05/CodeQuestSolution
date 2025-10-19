package org.javeriana.codequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodequestApplication {


    public static void main(String[] args) {
        SpringApplication.run(CodequestApplication.class, args);
    }

}

//el backend solo devuelve clientSecret. Nunca envíar sk_... al frontend.


/*
 Colocar antes de ejecutar la api key de stripe:
 $env:STRIPE_API_KEY="código de la api key"
 Verificar 
 echo $env:STRIPE_API_KEY

 ejecutar
 */

