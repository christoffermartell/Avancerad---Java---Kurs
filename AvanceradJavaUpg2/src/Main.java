import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
     // Räknare för att kolla Hur många gånger någon skrivs ut i consol.
	static int counter = 0;                                                     
	

	public static void main(String[] args) throws FileNotFoundException {
	// Hämtar och läser in text filen
	File data = new File("text.txt");
	Scanner fileScan = new Scanner(data);
		// räknare för att kolla vilken rad datan befinner sig på.
		int row = 0;
		String line = " ";
		String pattern = "if[\\s]?[(]|for[\\s]?[(]";
				
	// While loop för att läsa igenom varje rad för sig.
		while(fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			row++;
			// kallar på method
			finder(line,pattern,row);
			
		}
		
    // 1 : pattern [Aa][Bb][Cc][Dd][Ee][Ff][Gg][Hh][Ii][Jj][Kk][Ll][Mm][Nn][Oo][Pp][Qq][Rr][Ss][Tt][Uu][Vv][Xx][Yy][Zz] found "abcdefghijklmnopqrstuvwxyz" at row 531.
	// 2 : pattern 	[Oo][Ll][Aa] found match at row 9,16,239,330,469,618,620,639.
	// 3 : pattern 	[Aa]{3,5}] found aaaa] at row 334.
	// 4 : pattern 	[\\W]{2,} found strings with non alphanumeric on every row above 388 and often more than once at each row..
	// 5 : pattern 	[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3} found 5 Email,
		// Row : 452 : B7n5RRmhOpGhthoreSkogman@tjohopphej.sey
		// Row : 475 : _mick.jagger@stones.se
		// Row : 503 : 2DHMarie_Fredriksson@roxette.se
		// Row : 600 : 4eXUJXZLasseStefans@dansband.wtf
	    // Row : 692 : 0hlsty8dvS2doRjcalphaville@80tal.com
	// 6 : pattern 0[0-9]{1,3}[\\s/-]?[0-9]{5,}	found :
		// Row 126 : 020123456
		// Row 201 : 010910002
		// Row 557 : 021-334567
		// Row 586 : 0223/91334
		// Row 590 : 0184345339
		// Row 673 : 08123456
		// Row 674 : 08/99999444
		// Row 694 : 08-6628407
	// 7 : pattern : ([A-Za-z])\\1{3,3} found that at 5 different occasions there are fours letters of the same type.
	// 8 : pattern : [A-Za-z]{3}[/_][0-9]{3} found 	fvS_422 (row 96), abc/656 (row 230), LeE_114 (row 645).
	// 9 : pattern : [(][A-Za-z]+[)]|[(][0-9]+[)]|[(][\s]+[)] found (Hej) at row 272.
	// 10: pattern : if[\\s]?[(]|for[\\s]?[(] found :
		// Row : 3 , if(
		// Row : 55 , for(
		// Row : 174 , if(
		// Row : 223 , if(
		// Row : 234 , for(
		// Row : 377 , for(
		// Row : 466 , for(
		// Row : 525 , if(
		// Row : 605 , if(
		// Row : 907 , if(
		
		
		
	}
	// Method för att "matcha" vad vi letar efter i textfilen, samt skriva ut våra svar.
	public static void finder (String myString, String pattern, int row)  {
		
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(myString);
		
		while(m.find()){
			if(m.group().length() !=0) {
				
				System.out.println(m.group());
				counter++;
			}
			
			System.out.println("Match found at Row: " + row + " " );
			System.out.println("Count : " + counter);
	
			
		}
		 
		
		}
	

	
}
		
		// hjälp från lektionen.
		
			
			// s för att hitta mellanslag 
		    // [A-Za-z0-9]+\\) ;  
			// [A-Z]\\(";   hittar storbokstav med parantes efter
			// [A-Z] hittar alla matchningar på stora bokstäver	
			// [] matchar något i "hakarna"
			// + - ger en eler flera 
			// ? finns eller inte 
			// 0[0-9]{1,4}[-/]?[1-9][0-9]+ ;    telefon nr 
			// . utläser vad som helst
	        // {n,m} mellan n och m stycken
			// \\w+           ord och siffror utan tecken 
			
			// | och eller