import java.util.HashMap;
public class HashMapExample{
public static void main(String[] args){
  HashMap<String, Integer> map = new HashMap<>();
  map.put("Apple", 1);
  map.put("Banana", 2);
  map.put("Cherry", 3);
  for(String Key : map.KeySet()){
    System.out.println(key + " : " + map.get(Key));
  }
  if(map.containsKey("Banana"){
    System.out.println("Banana exists in the map.");
  }
  map.remove("Cherry");
}
}
