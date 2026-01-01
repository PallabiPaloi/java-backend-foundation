import java.util.HashMap;
public class OrderManagement{
  private HashMap<Integer, String> orders;//created HashMap with Named
  public OrderManagement(){
    orders = new HashMap<>();
  }
  public void addOrder(int orderId, String customerName){
    orders.put(orderId, customerName);
  }
  public void display(){
    System.out.println("customers orders: ");
    for(int orderId: orders.keySet()){
      System.out.println("orderId: " + orderId + " customer Name: " + orders.get(orderId);
    }
  }
  public static void main(String[] args){
    OrderManagement orderManagement = new OrderManagement();
    orderManagement.addOrder(101, "Alice");
    orderManagement.addOrder(102, "Bob");
    orderManagement.display();
  }
}
