import { Address } from './address';

export class Employee {
    id: number;
    firstName: string;
    lastName: string;
    email: string;
    phoneNumber: string;
    hireDate: Date;
    salary: number;
    commissionPct: number;
    addresses?: Address[];
}