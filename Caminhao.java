/*
 * Caminhao.java
 * 
 * 
 * 
 * 
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Caminhao extends Vehicle {

	public Caminhao(Vehicle x){
		super();
		try{
			setPlaca(x.getPlaca());
			setMarca(x.getMarca());
			setModelo(x.getModelo());
			setAno(x.getAno());
			setKilometragem(x.getKilometragem());
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

    @Override
    public  boolean gravaNoArquivo () {
		
		try {
			
			FileWriter fw = new FileWriter ( getDados(), true );
			
				BufferedWriter bw = new BufferedWriter ( fw );
				
					bw.write ( getPlaca() );
					bw.write ( getSeparador() );
					bw.write ( getMarca() );
					bw.write ( getSeparador() );
					bw.write ( getModelo() );
					bw.write ( getSeparador() );
					bw.write ( ""+getAno() );
					bw.write ( getSeparador() );
					bw.write ( ""+getKilometragem() );
                    bw.write ( getSeparador() );
					bw.write ( "Caminhao" );
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

