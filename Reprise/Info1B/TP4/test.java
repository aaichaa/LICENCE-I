public class test{
public static void main(String[] args) {
    
        int n;
    
        do{
            System.out.println("Donner n");
        n = Lire.i();
        System.out.println("Veuillez entrer un entier strictement positif et superieur a 0.");

        }while(n<=0);
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                for(int j = 1; j <= i; j++){
                    if(j%2==0){
                        System.out.print("2");
                    }else System.out.print("1");
                }
            }else {for(int j = 1; j <= i; j++){
                System.out.print("0");

            }

            }
        }

}
}
