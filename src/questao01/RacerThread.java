package questao01;

public class RacerThread extends Thread{
	private int id;
	
	public RacerThread(int id, char item) {
        this.id = id;
    }
	
	@Override
	public void run(){
        while(true){
            System.out.println("Racer " + id + " - imprimindo");
        }
    }
}
