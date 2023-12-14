/*
 Principal
 */
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main (String[] args) {
		Scanner scN = new Scanner(System.in);

		int a;
		do {
			System.out.print("0-sair\n1-registar carro\n2-registar moto\n3-registar caminhões\n4-Mostrar registros\n - ");
			a = 9;
			a = scN.nextInt();
			System.out.println();
			switch (a) {
				case 0:
					break;
				case 1:
					Registar("Carro");
					break;
				case 2:
					Registar("Moto");
					break;
				case 3:
					Registar("Caminhao");
					break;
				case 4:
					System.out.println("CARROS -");
					LerDados("Carro");
					System.out.println("MOTO -");
					LerDados("Moto");
					System.out.println("CAMINHAO -");
					LerDados("Caminhao");
					break;
				default:
					break;
			}
		} while(a != 0);
		scN.close();
	}
	private static void Registar(String tipo){
		Scanner scS = new Scanner(System.in);
		Scanner scN = new Scanner(System.in);

		System.out.println("Registrar veiculo("+tipo+"): \n");
		
		Vehicle vehicle = new Vehicle();
		
		String placa, modelo, marca;
		int ano = 0;
		double kilometragem = 0;

		try {
			System.out.print("Digite a placa do veiculo: ");
			placa = scS.nextLine();
			vehicle.setPlaca(placa);
			

			System.out.print("Digite a marca do veiculo: ");
			marca = scS.nextLine();
			vehicle.setMarca(marca);
			
			System.out.print("Digite o modelo do veiculo: ");
			modelo = scS.nextLine().trim();
			vehicle.setModelo(modelo);
			
			System.out.print("Digite o ano do veiculo: ");
			ano = scN.nextInt();
			vehicle.setAno(ano);

			System.out.print("Digite a kilometragem do veiculo: ");
			kilometragem = scN.nextDouble();
			vehicle.setKilometragem(kilometragem);


			if(tipo.equals("Carro")){
				vehicle = new Carro(vehicle);
				vehicle.gravaNoArquivo();
			}
			if(tipo.equals("Moto")){
				vehicle = new Moto(vehicle);
				vehicle.gravaNoArquivo();
			}
			if(tipo.equals("Caminhao")){
				vehicle = new Caminhao(vehicle);
				vehicle.gravaNoArquivo();
			}

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
	private static void LerDados(String tipo){
		
		try (BufferedReader reader = new BufferedReader(new FileReader(Vehicle.getDados()))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(Vehicle.getSeparador());
				if(partes[5].trim().equalsIgnoreCase(tipo)){
					Vehicle vehicle = new Vehicle();
					try{
						vehicle.setPlaca(partes[0].trim());
						vehicle.setMarca(partes[1].trim());
						vehicle.setModelo(partes[2].trim());
						vehicle.setAno(Integer.parseInt(partes[3].trim()));
						vehicle.setKilometragem(Double.valueOf(partes[4].trim()));
					}catch (PlacaInvalidaException e) {
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
					System.out.println(vehicle+"\n");
				}
			}
		}catch (IOException e) {
			System.out.println("ERRO NA LEITURA DOS DADOS");
		}
	}
} 