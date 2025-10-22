package questao01;

public class RacerRunnable implements Runnable{
	private int id;
	private char item;
	
	public RacerRunnable(int id, char item) {
        this.id = id;
        this.item = item;
    }
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public void run() {
		if (item == 'b' || item == 'c') {
            while (true) {
                System.out.println("Racer " + id + " - imprimindo");
            }
        }

        if (item == 'd' || item == 'e') {
            while (true) {
                try {
                    System.out.println("Racer " + id + " - imprimindo");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                	System.out.println("Thread interrompida.");
                }
            }
        }
        
        if(item == 'f') {
        	for(int i = 0; i < 1000; i++){
                System.out.println("Racer " + id + " - imprimindo");
            }
        }
    }
}
