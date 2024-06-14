public abstract class Personagem{
    private String nomeTipo;
    private double saude;
    private double forca;
    private double destreza;
    private Arma arma;

    public Personagem(String nomeTipo, double saude, double forca, double destreza, Arma arma) {
        this.nomeTipo = nomeTipo;
        this.saude = saude;
        this.forca = forca;
        this.destreza = destreza;
        this.arma = arma;
    }
    
    public void printStatus(){
        if(this.estaMorto()){
            System.out.printf("%s [Morreu, Forca: %.1f, Destreza: %.1f, %s]\n", this.nomeTipo, this.forca, this.destreza, this.arma.getNome());
        }else{
            System.out.printf("%s [Saude: %.1f, Forca: %.1f, Destreza: %.1f, %s]\n", this.nomeTipo, this.saude, this.forca, this.destreza, this.arma.getNome());
        }
    }

    public void atacar(Personagem b){
        if(this.estaMorto()){
            System.out.printf("O %s não consegue atacar, pois está morto.\n", this.nomeTipo);
            return;
        }
        System.out.printf("O %s ataca o %s com %s.\n", this.nomeTipo, b.nomeTipo, this.arma.getNome());
        if(b.estaMorto()){
            System.out.printf("Pare! O %s já está morto!\n", b.nomeTipo);
            return;
        }
        if(this.destreza > b.destreza){
            double dano = this.calculaDano();
            b.recebeDano(dano);
            System.out.printf("O ataque foi efetivo com %.1f pontos de dano!\n", dano);
        }else if(this.destreza < b.destreza){
            double dano = b.calculaDano();
            this.recebeDano(dano);
            System.out.printf("O ataque foi inefetivo e revidado com %.1f pontos de dano!\n", dano);
        }else{
            System.out.println("O ataque foi defendido, ninguem se machucou!");
        }
    }

    private double calculaDano(){
        return this.forca * this.arma.getModificadorDano();
    }

    private void recebeDano(double pontosDano){
        this.saude -= pontosDano;
    }

    private boolean estaMorto(){
        if(this.saude < 1){
            return true;
        }
        return false;
    }

}

