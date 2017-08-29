package com.lab.controllers;


import com.lab.persistence.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lab.persistence.service.TestService;
import java.util.List;


@Controller
public class Test
{

  @Autowired
  TestService iService;


  @ResponseBody
  @RequestMapping(value = "/test", //Nombre controlador
                  method = RequestMethod.POST, //Tipo POST
                  produces = MediaType.APPLICATION_JSON_VALUE) //Vamos a trabajar con JSON
  public List<TestModel> test(@RequestBody TestModel obj) throws Exception //Para recibir @RequestBody y siempre recibo un modelo,
          // es decir un objeto de tipo TestModel
  {
      
    System.out.println(obj.getPropiedad());
    System.out.println(obj.getTable());
    List<TestModel> x = iService.testService(obj);

    return x;
  }

}
