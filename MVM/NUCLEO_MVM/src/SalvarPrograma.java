
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SalvarPrograma {

	private static File program = new File("C:\\Users\\Rodrigo\\Desktop\\teste.txt");
	private static String auxiliar;
	private static short aux2;
	private static String tabelaRealocacao;

	public static File getProgram() {
		return program;
	}

	public static void setProgram(final File program) {
		SalvarPrograma.program = program;
	}

	public static String getAux() {
		return auxiliar;
	}

	public static void setAux(final String aux) {
		SalvarPrograma.auxiliar = aux;
	}

	public static short getAux2() {
		return aux2;
	}

	public static void setAux2(final short aux2) {
		SalvarPrograma.aux2 = aux2;
	}

	public static String getTabelaRealocacao() {
		return tabelaRealocacao;
	}

	public static void setTabelaRealocacao(final String tabelaRealocacao) {
		SalvarPrograma.tabelaRealocacao = tabelaRealocacao;
	}

	public static void salvar(final int inicio, final int fim, final short mem[]) throws IOException {
		if (getProgram() == null) {
			setProgram(new File("C:\\Users\\Rodrigo\\Desktop\\teste.txt"));
		}
		final FileWriter fw = new FileWriter(getProgram(), false);
		final BufferedWriter bw = new BufferedWriter(fw);
		final int start = inicio;
		int next = inicio;
		tabelaRealocacao = "";
		while (next <= fim) {
			setAux2(mem[next]);
			// Instrução de 2 bytes com posição de memória
			if (getAux2() == 5 || getAux2() == 6 || getAux2() == 7 || getAux2() == 8 || getAux2() == 9
					|| getAux2() == 10 || getAux2() == 25 || getAux2() == 26 || getAux2() == 27 || getAux2() == 42
					|| getAux2() == 43 || getAux2() == 45 || getAux2() == 52) {
				bw.write(getAux2() + "\n");
				next++;
				bw.write(mem[next] + "\n");
				tabelaRealocacao += (next - start) + "\n";
			} else // instruções de 2 bytes com chaves
			{
				if (getAux2() == 44) {
					bw.write(getAux2() + "\n");
					next++;
					bw.write(mem[next] + "\n");
				} else {
					// Instrução de 1 byte
					bw.write(getAux2() + "\n");
				}
			}
			next++;
		}
		// Adiciona a tabela de realocação ao final do programa separado por
		// "|"
		bw.write("|\n" + tabelaRealocacao);
		bw.close();
		fw.close();

	}

	public static void ler(final short mem[], int posicao) throws FileNotFoundException, IOException {
		final FileReader fr = new FileReader(getProgram());
		final BufferedReader br = new BufferedReader(fr);
		final int posicaoIni = posicao;
		boolean terminouPrograma = false;
		while (br.ready()) {
			auxiliar = br.readLine();
			if (auxiliar.equals("")) {
			} else if (auxiliar.equals("|")) {
				terminouPrograma = true;
			} else if (!terminouPrograma) {
				mem[posicao] = Short.parseShort(auxiliar);
				posicao++;
			} else {
				mem[Integer.parseInt(auxiliar) + posicaoIni] += posicaoIni;
			}
		}
		br.close();
		fr.close();
	}

	public static void carregaArquivo(final short mem[], int posicao) throws FileNotFoundException, IOException {
		final FileReader fileReader = new FileReader(getProgram());
		final BufferedReader bufferedReader = new BufferedReader(fileReader);

		final int inicial = posicao;
		boolean terminou = false;

		while (bufferedReader.ready()) {
			auxiliar = bufferedReader.readLine();
			terminou = auxiliar.isEmpty();

			if (!terminou) {
				final Short[] reverso = MVM.reverso(auxiliar);
				if (reverso != null) {
					if (reverso.length > 1) {
						mem[posicao] = reverso[0];
						mem[++posicao] = reverso[1];
					} else {
						mem[posicao] = reverso[0];
					}
					posicao++;
				}
			} else {
				mem[Integer.parseInt(auxiliar) + inicial] += inicial;
			}
		}
		bufferedReader.close();
		fileReader.close();
	}
}
