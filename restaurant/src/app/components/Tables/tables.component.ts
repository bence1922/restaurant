import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../Hero/hero.component';
import { Table } from 'src/app/generated-api/model/table';
import { ButtonModule } from 'primeng/button';
import { TableModule } from 'primeng/table';
import {  InputTextModule } from 'primeng/inputtext';

@Component({
  selector: 'app-tables',
  standalone: true,
  imports: [CommonModule, HeroComponent,TableModule, ButtonModule, InputTextModule],
  templateUrl: './tables.component.html',
  styleUrls: ['./tables.component.scss'],
})
export class TablesComponent implements OnInit{
  newTableFormOpen: boolean = false
  tables!: Table[]

  ngOnInit(): void {
    this.tables = new Array<Table>()
  }

  onRowEditInit(table: Table){

  }

  onRowEditSave(table: Table){}

  onRowEditCancel(table: Table, index: number){

  }

  newTableFormOpenBtnClick(){
    this.newTableFormOpen= !this.newTableFormOpen
  }
}
