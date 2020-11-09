import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class portKiller {
   public static void main(String[] var0) {
     // String var3=var0[0];


for(int i=0;i<var0.length;i++)
{
      try {
         Process var2 = Runtime.getRuntime().exec("sudo lsof -n -i:" + var0[i]);
         BufferedReader var4 = new BufferedReader(new InputStreamReader(var2.getInputStream()));
         ArrayList var5 = new ArrayList();
         ArrayList var6 = new ArrayList();

         String var1;
         while((var1 = var4.readLine()) != null) {
            var5.add(var1);
         }

         String var7 = null;

         int var8;
         for(var8 = 1; var8 < var5.size(); ++var8) {
            var7 = (String)var5.get(var8);
            var7 = var7.substring(8, 13);
            var6.add(var7);
         }

         for(var8 = 0; var8 < var6.size(); ++var8) {
            var2 = Runtime.getRuntime().exec("sudo kill -9 " + (String)var6.get(var8));
            System.out.println("Killed process "+var0[i]);
         }
         var2.waitFor();
         var2.destroy();
      } catch (Exception var9) {
      }
}
   }
}
