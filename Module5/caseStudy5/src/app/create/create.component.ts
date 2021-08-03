import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../model/customer';
import {CustomerType} from '../model/customer-type';
import {CustomerService} from '../service/customer.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.scss']
})
export class CreateComponent implements OnInit {
  customer: Customer;
  customerTypes: CustomerType[];
  createForm: FormGroup = new FormGroup({
    name: new FormControl('', Validators.required),
    birthday: new FormControl('', Validators.required),
    gender: new FormControl('', Validators.required),
    email: new FormControl('', [Validators.required, Validators.email]),
    customerType: new FormControl('', Validators.required)
  });
  msg = {
    customerType: [
      {type: 'required', msg: 'Please Input'}
    ],
    name: [
      {type: 'required', msg: 'Please Input'},
      {type: 'minLength', msg: 'Please Input >5 letter'}
    ],
    birthday: [
      {type: 'required', msg: 'Please Input'}
    ],

    email: [
      {type: 'required', msg: 'Please Input'},
      {type: 'email', msg: 'Please Input invalid'},
    ],
  };


  constructor(private sv: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  getAllCustomerType() {
    this.sv.getAllCustomerType().subscribe(ct => {
      this.customerTypes = ct;
    });
  }

  create() {
    this.customer = this.createForm.value;
    this.sv.save(this.customer).subscribe(() => {
      this.router.navigateByUrl('customer');
      alert('Create success');
    });
  }

  getValidateCreate(attribute: string, valid): boolean {
    return this.createForm.get(attribute)?.hasError(valid.type) &&
      (this.createForm.get(attribute)?.touched || this.createForm.get(attribute)?.dirty);
  }
}
