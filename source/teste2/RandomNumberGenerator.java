import java.util.concurrent.ThreadLocalRandom;
 
public class RandomNumberGenerator {

   static int usingThreadLocalClass(int maxValue) {
      int randomInt = ThreadLocalRandom.current().nextInt(0, maxValue-1);
      //System.out.println("Random number generated is : " + randomInt);
      return randomInt;
   }

}
