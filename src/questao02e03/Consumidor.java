package questao02e03;

public class Consumidor extends Thread{
	private int id;
    private Deposito deposito;
    private int tempo;

    public Consumidor(int id, Deposito deposito, int tempo){
        this.id = id;
        this.deposito = deposito;
        this.tempo = tempo;
    }

    public void run() {
    	int caixas = 0;
    	
        for(int i = 0; i < 20; i++) {
        	if (!deposito.retirar()) {
                System.out.println("O consumidor " + id + " não conseguiu consumir a caixa. Nova tentativa em 0.5s.");
                try {
            		sleep(500);
            	} catch (InterruptedException e) {
            		e.printStackTrace();
            	}
                
                if (!deposito.retirar()) {
                    System.out.println("O consumidor " + id + " ainda não conseguiu consumir a caixa. Pulando para a próxima caixa!");
                    try {
                		sleep(tempo);
                	} catch (InterruptedException e) {
                		e.printStackTrace();
                	}
                    continue;
                }
            }
        	
        	caixas++;
        	try {
        		sleep(tempo);
        	} catch (InterruptedException e) {
        		e.printStackTrace();
				System.out.println("Consumidor " + id + " - Consumo interrompido!");
        	}
        }
        System.out.println("O consumidor " + id + " finalizou o consumo de " + caixas + " caixas.");
    }
}
