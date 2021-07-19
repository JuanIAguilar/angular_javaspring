
package com.fleni.backend;

import com.fleni.backend.model.Address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fleni.backend.model.Employee;
import com.fleni.backend.repository.EmployeeRepository;
import java.util.Arrays;
import java.util.GregorianCalendar;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  public CommandLineRunner initDatabase(EmployeeRepository repository) {

    return args -> {
        
        Employee employee = new Employee("Carlos", "Garcia", "carlos.garcia@gmail.com", "541145632210", new GregorianCalendar(2013,1,28), new Long(30000), new Long(10));
        Employee employee2 = new Employee("Carlos", "Solari", "carlos.solar@gmail.com", "541154891122", new GregorianCalendar(2010,7,30), new Long(60000), new Long(20));
        Employee employee3 = new Employee("Ricardo", "Mollo", "ricardo.mollo@gmail.com", "541155554488", new GregorianCalendar(2016,10,05), new Long(30000), new Long(15));
        Employee employee4 = new Employee("Atahualpa", "Yupanqui", "ata.yupanqui@gmail.com", "1122233115", new GregorianCalendar(2000,0,01), new Long(55000), new Long(20));
        
        Address address1 =  new Address("Rivadavia 123", "1408", "CABA", "Capital Federal", "Argentina");
        Address address2 =  new Address("San Martin 455", "1406", "CABA", "Capital Federal", "Argentina");
        Address address3 =  new Address("Irigoyen 123", "1205", "Avellaneda", "Buenos Aires", "Argentina");
        Address address4 =  new Address("Guemes 4877", "1001", "Cordoba", "Cordoba", "Argentina");
        
        employee.setAddresses(Arrays.asList(address1));
        employee2.setAddresses(Arrays.asList(address2, address3));
        employee3.setAddresses(Arrays.asList(address4));
        
        repository.save(employee);
        repository.save(employee2);
        repository.save(employee3);
        repository.save(employee4);

    };
  }
}