/*
 Principal
 */
import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) {
		Scanner scS = new Scanner(System.in);
		Scanner scN = new Scanner(System.in);
		
		System.out.println("Registre seu veiculo: \n");
		
		Vehicle carro = new Vehicle();
		
		String placa, modelo, marca;
		int ano = 0;
		double kilometragem = 0;

		try {
			System.out.print("Digite a placa do veiculo: ");
			placa = scS.nextLine();
			carro.setPlaca(placa);
			

			System.out.print("Digite a marca do veiculo: ");
			marca = scS.nextLine();
			carro.setMarca(marca);
			
			System.out.print("Digite o modelo do veiculo: ");
			modelo = scS.nextLine().trim();
			carro.setModelo(modelo);
			
			System.out.print("Digite o ano do veiculo: ");
			ano = scN.nextInt();
			carro.setAno(ano);

			System.out.print("Digite a kilometragem do veiculo: ");
			kilometragem = scN.nextDouble();
			carro.setKilometragem(kilometragem);

		} catch (PlacaInvalidaException e) {
			System.out.println(e.getMessage());
		} catch (MarcaInvalidaException e){
			System.out.println(e.getMessage());
		} catch(ModeloInvalidaException e){
			System.out.println(e.getMessage());
		} catch(AnoInvalidoException e){
			System.out.println(e.getMessage());
		} catch(KminvalidaException e){
			System.out.println(e.getMessage());
		}
		
	}
}

