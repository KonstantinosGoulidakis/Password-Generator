import java.util.Random;
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Generator {

    public static void main(String[] args) {
	System.out.println("This is a random password generator.\n You will be asked to enter the password lenght\n as well as the number of capitals, numbers and special characters that will be included in your password.");
	Scanner input = new Scanner(System.in);		
	int x;
        String c;
        
        do {
            
            do {System.out.println("Enter the desired length of your randomly generated password.\n(Max password length: 127 characters)");
            x = input.nextInt();}
            
            while (x > 127 || x < 1); 
           
            System.out.println("The desired password length is "+x+". Do you wish to continue? (Y/N)");
            c = new String(input.next());
            
            while (!c.equals("N") && !c.equals("Y"))
            {
                System.out.println("You MUST select between Y/N (Y for yes | N for no)");
                c = new String(input.next());
            }
            
        }        
        while (c.equals("N"));
        
        int caps=0;  
        int inte=0; 
        int spec=0; 
        int sum;
        int sum1;
        int sum2=0;
        int pos;
        int pos1;
        int pos2;
        int pos3;
        int counter=0;
        
        System.out.println("For the creation of your password you have to choose the number\nof capital letters, integers and special characters that your password will consist of.\nKeep in mind that any undeclared space will be generated with non capital letters");
        
        do
        {
            System.out.println("Number of capital letters: ");
            caps = input.nextInt();
            sum = x - caps;
            if (sum<0){System.out.println("You have exceeded your available positions");}
            else{System.out.println("You have "+sum+" positions available");}
        }
        while (sum<0);
        
        if (sum != 0)
        {
            do{
                System.out.println("Number of integers: ");
                inte = input.nextInt();
                sum1 = sum - inte;
                if (sum1<0){System.out.println("You have exceeded your available positions");}
                else {System.out.println("You have "+sum1+" positions available");}
            }
            while (sum1<0);
            
            if (sum1 != 0)
            {   
                do{
                    System.out.println("Number of special characters: ");
                    spec = input.nextInt();
                    sum2 = sum1 - spec;
                    if (sum2<0){System.out.println("You have exceeded your available positions");}
                    else {System.out.println("You have "+sum2+" positions available");}
                }
                while (sum2<0);
            }

            else {System.out.println("You have 0 available positions for special characters in your password lenght");}
        }
        
        else {System.out.println("You have 0 available positions for integers in your password length");}
        
        String[] integers = new String[inte];
        String[] capitals = new String[caps];
        String[] noncapitals = new String[sum2];
        String[] special = new String[spec];
        String[] allintegers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] allcapitals = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] allnoncapitals = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] allspecial = {"!", "@", "#", "$", "%", "^", "&", "*", "?"};        
        
        Random rnd = new Random();
        String[] pass = new String[x];
        
        for (int i = 0; i < caps; i++)
        {   
            pos = rnd.nextInt(allcapitals.length);
            capitals[i] = allcapitals[pos];
        }
        
        for (int j = 0; j < inte; j++)
        {
            pos1 = rnd.nextInt(allintegers.length);
            integers[j] = allintegers[pos1];          
        }        
        
        for (int k = 0; k < spec; k++)
        {
            pos2 = rnd.nextInt(allspecial.length);
            special[k] = allspecial[pos2];           
        }        
        
        for (int l = 0; l < sum2; l++)
        {
            pos3 = rnd.nextInt(allnoncapitals.length);
            noncapitals[l] = allnoncapitals[pos3];           
        }
        
        for (int f = 0; f < caps; f++)
        {
            pass[f] = capitals[f];
            counter++;
        }
        
        for (int d = 0; d < inte; d++)
        {
            pass[counter++] = integers[d]; 
        }
        
        for (int v = 0; v < spec; v++)
        {
            pass[counter++] = special[v]; 
        }
        
        for (int w = 0; w < sum2; w++)
        {
            pass[counter++] = noncapitals[w]; 
        }

        List<String> randomlist = Arrays.asList(pass);
        Collections.shuffle(randomlist);
        randomlist.toArray(pass);
        
        System.out.print("Your randomly generated password is: ");
        
        for (int q=0; q<x; q++)
        {
            System.out.print(pass[q]);
        }
    }
}
