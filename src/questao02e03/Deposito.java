package questao02e03;

public class Deposito {
	private int itens = 0;
    private final int capacidade = 100;

    public int getNumItens(){
        return itens;
    }

    public boolean retirar() {
    	if(getNumItens() == 0) {
    		return false;
    	}
    	
        itens = getNumItens() - 1;
        return true;
    }

    public boolean colocar() {
        itens = getNumItens() + 1;
        return true;
    }

    public static void main(String[] args) {
        Deposito dep = new Deposito();
        Produtor p = new Produtor(1, dep, 50);
        Consumidor c1 = new Consumidor(1, dep, 150);
        Consumidor c2 = new Consumidor(2, dep, 100);
        Consumidor c3 = new Consumidor(3, dep, 150);
        Consumidor c4 = new Consumidor(4, dep, 100);
        Consumidor c5 = new Consumidor(5, dep, 150);

        //Startar o produtor
        p.start();

        //Startar os consumidores.
        c1.start(); 
        c2.start(); 
        c3.start();
        c4.start();
        c5.start();
        
        System.out.println("Execucao do main da classe Deposito terminada");
    }
}