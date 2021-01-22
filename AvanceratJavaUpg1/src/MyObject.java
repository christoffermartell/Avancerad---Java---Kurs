import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyObject {

	private Boolean bool;
	private  int value;
	private String name;
	
	
	public MyObject(boolean bool, int value, String name) {
		
		this.bool = bool;
		this.value = value;
		this.name = name;
		
		
	}
	

	public Boolean getBool() {
		return bool;
	}


	public void setBool(Boolean bool) {
		this.bool = bool;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name + " " + this.value + " " + this.bool;
		
	}
	
	
	public static void main(String[] args) {
		
		MyObject instance [] = new MyObject[50];
		
		for (int i = 0; i < instance.length; i++) {
			
			instance[i] = new MyObject(ranBool(),ranNr(1, 50),ranString());
		}
		for (int i = 0; i < instance.length; i++){
		
		}
        for (int i = 0; i < instance.length; i++){
		
        }
		// del 3 upg 1
    //    List<MyObject> valueAbove20 = Arrays.asList(instance);
     
        System.out.println("Del 3 Uppgift 1 :  Objects with value higher than 20 -->");
        System.out.println(Arrays.stream(instance).filter(x-> x.getValue()> 20).collect(Collectors.toList()));
        
        // del 3 uppgift 2
        System.out.println("-----------------------------------------------------------");
        System.out.println("Del 3 uppgift 2: The average of all values combined is : " + Arrays.stream(instance).mapToInt(x->x.getValue()).average().getAsDouble());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Del 3 uppgift 3: --> ");
        List<MyObject> MyArray = Arrays.asList(instance);
        List<MyObject> thisIsTrue = MyArray.stream().filter(MyObject::getBool).peek(x->x.setName("This is True")).collect(Collectors.toList());
        System.out.println(thisIsTrue);
        
        
	}
	
	

	public static String ranString() {
	    int myInt = 2;
		String ranSigns = "CHRISTOFFERANDREASMARTELL";
		Random ran = new Random ();
		StringBuilder x = new StringBuilder();
		
		for (int i = 0; i< myInt; i++) {
			int n = ran.nextInt(ranSigns.length());
			char randomChar = ranSigns.charAt(n);
			x.append(randomChar);
			
		}
		
		return x.toString();
	}
	
	public static int ranNr(int minValue, int maxValue) {
        return (int) (Math.random() * (maxValue - minValue + 1) + minValue);
    }
	
	
	public static boolean ranBool() {
		
		Random ran = new Random();
		
		return ran.nextBoolean();
		
	}

	
	
}
