import java.util.Scanner;

class ProductDetails
{
    String drinkName;
    double price, quantity,totalPrice,allPrice;
    double totalChange,totalQuantity,noItems;
    
    ProductDetails(String drinkName, double price, double quantity, double totalPrice)
    {
        this.drinkName = drinkName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    public void productDisplay(String itemCode) 
    {       
        System.out.println("Item Code :" +itemCode); 
    }
}

class hardDrink extends ProductDetails
{
	
	hardDrink(String drinkName, double price, double quantity, double totalPrice) 
	{
		super(drinkName, price, quantity, totalPrice);	
	}
	 public void productDisplay(double allPrice)
	{
	        
		 	System.out.printf("Total Price: %.2f",allPrice);
	}
}

class softDrink extends hardDrink
{

	softDrink(String drinkName, double price, double quantity, double totalPrice) 
	{
		super(drinkName, price, quantity, totalPrice);
	}
	 public void productDisplay(double noItems, double totalChange,double vatSales,double vat, double totalQuantity) 
	{
	    	System.out.println();
	    	System.out.printf("No. of items: %.0f\n" ,noItems);
	        System.out.printf("Total Change: %.2f\n" ,totalChange);
	        System.out.printf("Total Vat Sales: %.2f\n" ,vatSales);
	        System.out.printf("Total Vat: %.2f\n",vat);
	        System.out.printf("Total Quantity: %.0f\n",totalQuantity);    
	}
}

class Main {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String drinkName,choice, itemCode;
		double noItems, noItemsCounter = 0, price, quantity,totalPrice,cash,totalChange = 0,allPrice = 0,vatSales, vat,totalQuantity = 0;      
        do{
            System.out.print("Enter Your Drink: ");
            drinkName = sc.nextLine();
            System.out.print("Enter Item Code: ");
            itemCode =  sc.nextLine();
            System.out.print("Enter price drinks: ");
    		price = sc.nextDouble();
    		System.out.print("Enter your quantity: ");
	    	quantity = sc.nextDouble();
	    	sc.nextLine();
	    	noItemsCounter++;
	    	noItems = noItemsCounter;
            totalPrice = price * quantity; 
            totalQuantity = totalQuantity + quantity;
	        allPrice = allPrice + totalPrice;  
	        softDrink sd = new softDrink(drinkName,price,quantity,totalPrice);
	        sd.productDisplay(itemCode);
	        sd.productDisplay(allPrice);
	        System.out.println();
	        System.out.println();
	        System.out.print("Do you want to another transaction?: ");
            choice = sc.nextLine();
      
        }while(choice.equalsIgnoreCase("yes"));
             System.out.print("Enter cash: ");
    		 cash = sc.nextDouble();
    		 totalChange = cash - allPrice;
    		 vatSales = totalPrice / 1.12;
    		 vat = vatSales * 0.12;
    		
    		 softDrink sd = new softDrink(drinkName,price,quantity,totalPrice);
    		 sd.productDisplay(noItems,totalChange,vatSales,vat,totalQuantity);	
    }
}
