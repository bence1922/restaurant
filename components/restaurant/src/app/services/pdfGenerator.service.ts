import * as pdfMake from 'pdfmake/build/pdfmake';
import * as pdfFonts from 'pdfmake/build/vfs_fonts';
import { DrinkOrderItem, Food, FoodOrderItem, Order } from '../generated-api';
import { DatePipe } from '@angular/common';

(pdfMake as any).vfs = pdfFonts.pdfMake.vfs;

export class PdfGeneratorService{
    
    generatePdf(order: Order){
        let docDefinition = {
            content: [{text: "Order for delivery", fontSize: 15},
                        "Date: "+ order.date!,
                        "\n",
                        this.listStringFood(order.foods),
                        this.listStringDrink(order.drinks),
                        "\n",
                        this.sum(order)]
        }

        pdfMake.createPdf(docDefinition).open();
    }

    listStringFood(list: Array<FoodOrderItem>){
        let str="";
        list.forEach(item=>{
            str+=item.food.name+"\t"+item.food.price+" x "+item.quantity+"\n"
        })
        return str;
    }

    listStringDrink(list: Array<DrinkOrderItem>){
        let str="";
        list.forEach(item=>{
            str+=item.drink.name+"\t"+item.drink.price+" x "+item.quantity+"\n"
        })
        return str;
    }

    sum(order: Order){
        let sum=0;
        order.drinks.forEach(item=>{
            sum+=item.drink.price*item.quantity
        })
        order.foods.forEach(item => {
            sum+=item.food.price*item.quantity
        });

        return "Sum: "+sum
    }

    dateString(date: Date){ // TODO
        let pipe= new DatePipe('en-US')
        return pipe.transform(date, 'yyyy-MM-dd');
    }
}