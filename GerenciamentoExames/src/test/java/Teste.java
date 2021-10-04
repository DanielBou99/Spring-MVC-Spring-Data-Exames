import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste {

	public static void main(String[] args){
		
	try {
		SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date dataUsuario = dataFormat.parse("03/10/2021".replace('/', '-'));
		Date dataAtual = new Date();

		System.out.println(dataUsuario);
		System.out.println(dataAtual);
		
		if (dataUsuario.before(dataAtual)) {
			System.out.println("Data do usuário menor que a data de hoje.");
		} else {
			System.out.println("Data maior que a data de hoje.");
		}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
	}

}
