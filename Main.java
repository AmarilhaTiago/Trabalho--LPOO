import java.util.Scanner;

public class Main {
    final static ArmaMago[] armaMago = {new Transmutacao(), new Psikappa()};
    final static ArmaPaladino[] armaPaladino = {new Espada(), new Lanca()};
    final static ArmaClerigo[] armaClerigo = {new Martelo(), new Maca()};
    public static void main(String[] args) {
        Personagem[] personagem = new Personagem[2];
        Scanner scan = new Scanner(System.in);

        personagem[0] = criaPersonagem(scan);
        personagem[1] = criaPersonagem(scan);

        while(true){
            personagem[0].printStatus();
            personagem[1].printStatus();

            int a = scan.nextInt();
            if(a > 2 || a < 1){
                break;
            }
            int b = scan.nextInt();
            if(b > 2 || b < 1){
                break;
            }
            personagem[a - 1].atacar(personagem[b - 1]);
        }
    }

    public static Personagem criaPersonagem(Scanner scan){
        int nomeTipo = scan.nextInt();
        double saude = scan.nextDouble();
        double forca = scan.nextDouble();
        double destreza = scan.nextDouble();
        int armaTipo = scan.nextInt();

        switch(nomeTipo){
            case 1:
                return new Mago(saude, forca, destreza, armaMago[armaTipo - 1]);
            case 2:
                return new Paladino(saude, forca, destreza, armaPaladino[armaTipo - 1]);
            case 3:
                return new Clerigo(saude, forca, destreza, armaClerigo[armaTipo - 1]);
            default:
                return null;
        }
    }
}
