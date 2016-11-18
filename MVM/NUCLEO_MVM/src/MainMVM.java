
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MainMVM {

	public static void main(final String[] args) {
		final short mem[] = new short[1025];
		if (true) {
			Botao.main(args, mem);
		} else {
			int programa = Integer.parseInt(JOptionPane.showInputDialog("Escolha um Programa: "));
			// Botao.main(args, mem);
			final int enderecoDeCarga = 0;

			switch (programa) {
			case 1:
				mem[0 + enderecoDeCarga] = 0;
				mem[1 + enderecoDeCarga] = 44;
				mem[2 + enderecoDeCarga] = 3;
				mem[3 + enderecoDeCarga] = 19;
				mem[4 + enderecoDeCarga] = 9;
				mem[5 + enderecoDeCarga] = 2;
				mem[6 + enderecoDeCarga] = 40;
				break;
			default:
				programa = 0;
				break;
			}
			final String stringPrograma = MVM.decodificador(mem, programa, 0);
			try {
				final Path createFile = Files.createFile(Paths.get("teste.txt"));
				final PrintWriter printWriter = new PrintWriter(createFile.toFile());
				printWriter.print(stringPrograma);
				printWriter.close();

			} catch (final IOException ex) {
				Logger.getLogger(MainMVM.class.getName()).log(Level.SEVERE, null, ex);
			}

			try {
				final BufferedReader bufferedReader = new BufferedReader(new FileReader("teste.txt"));
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					System.out.println(MVM.reverso(line));
				}
			} catch (final IOException ex) {
				Logger.getLogger(MainMVM.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
