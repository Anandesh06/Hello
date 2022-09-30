import java.util.Scanner;
public class PizzaOrder {
        static String name;
        static String address;
        static long phoneno;
        static String email;
        static float garlicbreadbill=0;
        static float beveragesbill=0;
        static float pizzabill=0;
        static int noofgarlicbread;
        static  int noofbeverages;
        static  int noofpizzas;
        static int pizzasize;
        public static void getcustomerDetails() {
                Scanner cd=new Scanner(System.in);
                System.out.print("Enter Name of the Customer : ");
                name=cd.next();
                System.out.print("Enter Email of the Customer : ");
                email=cd.next();
                System.out.print("Enter Contact no of the Customer : ");
                phoneno=cd.nextLong();
                System.out.print("Enter Address of the Customer : ");
                address=cd.next();
        }
        public static void DisplayCustomerDetails(){
                System.out.println("Customer Details");
                System.out.println("-----------------");
                System.out.println("Name of the Customer       : "+name);
                System.out.println("Email of the Customer      : "+email);
                System.out.println("Contact no of the Customer : "+phoneno);
                System.out.println("Address of the Customer    : "+address);
                System.out.println("-------------------------------------------------");
        }
        public static void DisplayMenu() {
                System.out.println("Select item to order");
                System.out.println("Sl No  Item  Category");
                System.out.println("----------------------");
                System.out.println("1) Pizza");
                System.out.println("    Price of one Regular Pizza : $9.99");
                System.out.println("    Price of one Medium Pizza : $11.99");
                System.out.println("    Price of one Large Pizza : $13.99");
                System.out.println("2) Garlic Bread");
                System.out.println("    Price of one Gralic Bread : $5.99");
                System.out.println("3) Beverages");
                System.out.println("    Price of one Beverages : $1.99");

        }
        public static float getPriceofPizzaBasedOnSize(int pizzasize) {
                float priceofPizza = 0f;
                if (pizzasize == 1) {
                        priceofPizza = 9.99f;
                }
                else if (pizzasize==2) {
                        priceofPizza=11.99f;
                } else if (pizzasize==3) {
                        priceofPizza=13.99f;
                }
                else {
                        System.out.println("Enter Valid number 1 or 2 or 3 ");
                }
                return priceofPizza;
        }
        public static float getpriceofgarlicbread() {
                return 5.99f;
        }
        public static  float getpriceofbeverages() {
                return 1.99f;
        }
        public static float calculatePriceOfPizza(int noOfPizza)
        {
                return noOfPizza*getPriceofPizzaBasedOnSize(pizzasize);
        }
        public static float calculatePriceOfGarlicBread(int noOfGarlicBread)
        {
                return noOfGarlicBread*getpriceofgarlicbread();
        }
        public static float calculatePriceOfBeverages(int noOfBeverages)
        {
                return noOfBeverages*getpriceofbeverages();
        }
        public static void getorderdetails() {
                Scanner od = new Scanner(System.in);
                int temp, option;
                do {
                        System.out.println("Enter 1 for Pizza,2 for Gralic Bread and 3 for Beverages");
                        option = od.nextInt();
                        switch (option) {
                                case 1:
                                        System.out.print("Enter the Number of pizza you want to Order :");
                                        noofpizzas += od.nextInt();
                                        System.out.print("Please enter the size of pizza you want to order(For regular type 1,for medium type 2 and for large type 3) : ");
                                        pizzasize = od.nextInt();
                                        pizzabill += calculatePriceOfPizza(noofpizzas);
                                        break;
                                case 2:
                                        System.out.println("Enter the number of Garlic Bread you want to Order : ");
                                        noofgarlicbread += od.nextInt();
                                        garlicbreadbill += calculatePriceOfGarlicBread(noofgarlicbread);
                                        break;
                                case 3:
                                        System.out.println("Enter the Number of Beverages you want to Order : ");
                                        noofbeverages += od.nextInt();
                                        beveragesbill += calculatePriceOfBeverages(noofbeverages);
                                        break;
                                default:
                                        System.out.println("Enter a valid option");


                        }
                        System.out.println("Do you want to place another order  then enter 1 or for exit enter 0");
                        temp = od.nextInt();
                } while (temp != 0);

        }
        public static float totalbill(float pizzabill,float beveragesbill,float garlicbreadbill) {
                return pizzabill+beveragesbill+garlicbreadbill;
        }
        public static float discount(float totalamt) {
                float discountamt=totalamt;
                if(totalamt>=50) {
                        discountamt=totalamt/100*90;
                }
                return discountamt;
        }
        public static void OrederDetails(float totalamount,float discountedprice){
        System.out.println("Order Details");
        System.out.println("--------------");
        System.out.println("The Number of Pizzes Ordered        : "+noofpizzas);
        System.out.println(("The Number of Garlic Bread Ordered : "+noofgarlicbread));
        System.out.println("The Number of Beverages Ordered     : "+noofbeverages);
        System.out.println("-----------------------------------------------------");
        System.out.println("The Total Bill Amount is      : $"+totalamount);
        System.out.println("The Discounted Bill Amount is : $"+discountedprice);
        }
        public static void main(String[] args) {
                DisplayMenu();
                getcustomerDetails();
                getorderdetails();
                float totalamount=totalbill(pizzabill,beveragesbill,garlicbreadbill);
                float discountedprice=discount(totalamount);
                DisplayCustomerDetails();
                OrederDetails(totalamount,discountedprice);
        }
}

