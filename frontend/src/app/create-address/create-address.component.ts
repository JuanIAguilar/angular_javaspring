import { EmployeeService } from '../employee.service';
import { Address } from '../address';
import { Employee } from '../employee';
import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-address',
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.css']
})
export class CreateAddressComponent implements OnInit {

  address: Address = new Address();
  @Input() employee;
  @Output() addressChange = new EventEmitter();
  submitted = false;

  constructor(private employeeService: EmployeeService,
    private router: Router) { }

  ngOnInit() {
  }

  save() {
    this.employeeService
    .addAddress(this.employee.id, this.address).subscribe(data => {
      console.log(data)
      this.addressChange.emit();
    }, 
    error => console.log(error));
  }

  addressSubmit() {
    this.submitted = true;
    this.save();
  }
}