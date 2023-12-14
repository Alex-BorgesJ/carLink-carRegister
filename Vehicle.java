import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Vehicle {
	

    private String placa, marca, modelo;
    private int ano;
    private double kilometragem;
    private static String arquivo 	= "Marcas.txt",dados = "dados.txt",separador = ";";

    public Vehicle() {

    }

    public static String getSeparador() {
        return separador;
    }

    public static String getDados() {
        return dados;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) throws PlacaInvalidaException {
        if (validaPlaca(placa)) {
            this.placa = placa;
        } else {
            throw new PlacaInvalidaException("Erro de registro: Placa Invalida");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws MarcaInvalidaException {
        if (validaMarca(marca)) {
            this.marca = marca;
        } else {
            throw new MarcaInvalidaException ("Erro de registro: Marca Invalida");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) throws ModeloInvalidaException {
        if(validaModelo(modelo)){
			this.modelo = modelo;
		} else {
			throw new ModeloInvalidaException("Erro de registro: Modelo invalido");
		}
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) throws AnoInvalidoException {
        if(validaAno(ano)){
			this.ano = ano;
		} else {
			throw new AnoInvalidoException("Erro de registro: Ano invalido");
		}
    }

    public double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(double kilometragem) throws KminvalidaException{
        if(kilometragem >= 0){
			this.kilometragem = kilometragem;
		} else{
			throw new KminvalidaException("Erro de registro: Kilometragem invalida");
		}
    }

    private boolean validaPlaca(String placa) {
        // expressao regular para verificação de placa
        String regex = "^[A-Za-z]{3}\\d{1}[A-Za-z]{1}\\d{2}$|^[A-Za-z]{3}\\d{4}$";
        return placa.matches(regex);
    }

    private boolean validaMarca(String marca){
		List<String> marcasDisponiveis = leArquivoMarcasEGeraLista(arquivo, separador);

		if (marcasDisponiveis.contains(marca.toUpperCase())) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean validaModelo(String modelo){
		if(!modelo.equals("")){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validaAno(int ano){
		int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
		
		return (ano < 1900 || ano > anoAtual ? false : true); 
	}

    private List<String> leArquivoMarcasEGeraLista(String arquivo, String separador) {
        List<String> marcas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(separador);
                // Ajuste conforme necessário para obter a coluna correta das marcas
                // Por exemplo, se a marca estiver na primeira coluna, use partes[0]
                marcas.add(partes[1].trim());
            }
        } catch (IOException e) {
            return null;
        }

        return marcas;
    }
    
    public String toString(){
        return
        ("Placa: " + placa)+"\n"+
        ("Marca: " + marca)+"\n"+
        ("Modelo: " + modelo)+"\n"+
        ("Ano: " + ano)+"\n"+
        ("Kilometragem: " + kilometragem);
    }
    
    public  boolean gravaNoArquivo () {
		
		try {
			
			FileWriter fw = new FileWriter ( dados, true );
			
				BufferedWriter bw = new BufferedWriter ( fw );
				
					bw.write ( placa );
					bw.write ( separador );
					bw.write ( marca );
					bw.write ( separador );
					bw.write ( modelo );
					bw.write ( separador );
					bw.write ( ano );
					bw.write ( separador );
					bw.write ( ""+kilometragem );
					bw.newLine();
					
				bw.close();
				
			fw.close();
			
			return true;
			
		} catch ( IOException e ) {
			
			e.printStackTrace();
			
			return false;
		}
	}
}



