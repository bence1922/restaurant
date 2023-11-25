import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Table } from 'src/app/generated-api/model/table';
import { ButtonModule } from 'primeng/button';
import { TableModule} from 'primeng/table';
import {  InputTextModule } from 'primeng/inputtext';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { DialogModule } from 'primeng/dialog';
import { DropdownModule } from 'primeng/dropdown';
import { TableService } from 'src/app/generated-api';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-tables',
  standalone: true,
  imports: [CommonModule, HeroComponent,TableModule, ButtonModule, InputTextModule, FormsModule, ReactiveFormsModule, DialogModule, DropdownModule],
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss'],
})
export class TablesComponent implements OnInit{
  newTableFormOpen: boolean = false
  tables!: Table[]
  newTableForm = new FormGroup({
    number: new FormControl(0, [Validators.required]),
    capacity: new FormControl(1, [Validators.required]),
  })
  tableStateOptions=[
    Table.StatusEnum.Booked,
    Table.StatusEnum.Free
  ]

  constructor(private tableService: TableService){}

  onSubmit(){
    var newTable: Table={
      number:this.newTableForm.value.number!,
      capacity: this.newTableForm.value.capacity!,
    }

    this.tableService.patchTable(newTable.number, newTable.capacity).subscribe(
      (result)=>{
        alert("Seccess!");
        this.newTableFormOpen=false
      }, (error: HttpErrorResponse)=>{
        alert(error.statusText)
      }
    )

  }

  ngOnInit(): void {
    this.tables = new Array<Table>()
    this.tableService.listTables().subscribe(
      (result)=>{
        this.tables = result;
      }, (error: HttpErrorResponse)=>{
        alert(error.statusText)
      }
    )
  }

  onRowEditInit(table: Table){

  }

  onRowEditSave(table: Table){
    this.tableService.patchTable(table.number, table.capacity).subscribe(
      (result)=>{
        alert("Seccess!");
        this.newTableFormOpen=false
      }, (error: HttpErrorResponse)=>{
        alert(error.error)
      }
    )
  }

  onRowEditCancel(table: Table, index: number){

  }

  newTableFormOpenBtnClick(){
    this.newTableFormOpen= true
  }

  deleteTable(table: Table){
    this.tableService.deleteTable(table.number).subscribe(
      (result)=>{}
      ,(error:HttpErrorResponse)=>{

      }
    )
  }
}
