package it.edoardo.springdataaccess.controller.rest.order;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/orders/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductInOrderController {

}
