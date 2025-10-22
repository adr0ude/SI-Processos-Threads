package questao01;
import java.util.Scanner;
import java.util.ArrayList;

public class Race {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcao = -1;
		
		do {
			System.out.println("QUESTÃO 01 - ITENS");
			 System.out.println("1 - Item B");
	         System.out.println("2 - Item C");
	         System.out.println("3 - Item D");
	         System.out.println("4 - Item E");
	         System.out.println("5 - Item F");
	         System.out.println("0 - Sair");
	         System.out.print("Escolha a opção: ");
	         opcao = sc.nextInt();
	         
	         ArrayList<RacerRunnable> racers = new ArrayList<>();
	         
	         switch(opcao) {
	         case 1:
	        	 RacerRunnable r1 = new RacerRunnable(1, 'b');
	        	 Thread t1 = new Thread(r1);
	        	 t1.start();
	        	 break;
	         case 2:
	        	 racers.clear();
	        	 for (int i = 1; i <= 10; i++) {
                     RacerRunnable r = new RacerRunnable(i, 'c');
                     Thread t = new Thread(r);
                     racers.add(r);
                     t.start();
                 }
	        	 break;
	         case 3:
	        	 racers.clear();
	        	 for (int i = 1; i <= 10; i++) {
                     RacerRunnable r = new RacerRunnable(i, 'd');
                     Thread t = new Thread(r);
                     racers.add(r);
                     t.start();
                 }
	        	 break;
	         case 4:
	        	 racers.clear();
	        	 for (int i = 1; i <= 10; i++) {
                     RacerRunnable r = new RacerRunnable(i, 'e');
                     Thread t = new Thread(r);
                     
                     if(i%2 == 0) {
                    	 t.setPriority(Thread.MIN_PRIORITY);
                     } else if (i == 5 || i == 1) {
                    	 t.setPriority(Thread.MAX_PRIORITY);
                     }
                     
                     racers.add(r);
                     t.start();
                 }
	        	 break;
	         case 5:
	        	 racers.clear();
	        	 ArrayList<Thread> imparesThreads = new ArrayList<>();
	        	    for(int i = 1; i <= 10; i += 2) {
	        	        RacerRunnable r = new RacerRunnable(i, 'f');
	        	        Thread t = new Thread(r);
	        	        t.start();
	        	        imparesThreads.add(t);
	        	    }

	        	    for(Thread t : imparesThreads) {
	        	        try {
	        	            t.join();
	        	        } catch (InterruptedException e) {
	        	            throw new RuntimeException(e);
	        	        }
	        	    }

	        	    for(int i = 2; i <= 10; i += 2) {
	        	        RacerRunnable r = new RacerRunnable(i, 'f');
	        	        Thread t = new Thread(r);
	        	        t.start();
	        	    }
	        	    break;
	         }
		} while (opcao != 0);
		
		sc.close();
	}
}
