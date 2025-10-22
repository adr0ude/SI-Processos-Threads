package questao02e03;

public class Produtor extends Thread{
	private int id;
    private Deposito deposito;
    private int tempo;

    public Produtor(int id, Deposito deposito, int tempo){
        this.id = id;
        this.deposito = deposito;
        this.tempo = tempo;
    }

    public void run() {
        for(int i = 0; i < 100; i++) {
            deposito.colocar();
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
            	e.printStackTrace();
				System.out.println("Produção interrompida!");
            }
        }
        
        System.out.println("O produtor " + id + " finalizou a produção de 100 caixas.");
    }
}
