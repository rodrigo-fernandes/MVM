
import javax.swing.JOptionPane;

public class MVM {

	public static int botao = 0;

	public static String decodificador(final short mem[], final int programa, final int aux) {
		int ax = 0;
		int bx = 0;
		int cx = 0;
		int bp = 0;
		int sp = 0;
		int ip;
		int ri;

		boolean repetir = true;

		ip = 0 + aux;

		final StringBuffer stringBuffer = new StringBuffer();

		while (repetir) {
			System.out.println("Valor de IP: " + ip);
			if (botao == 1) {
				// "push ip"
				mem[sp] = (short) ip;
				sp--;

				// "push bp"
				mem[sp] = (short) bp;
				sp--;

				// "push ax"
				mem[sp] = (short) ax;
				sp--;

				// "push bx"
				mem[sp] = (short) bx;
				sp--;

				// "push cx"
				mem[sp] = (short) cx;
				sp--;

				ip = mem[0];
				botao = 0;
				System.out.println("EXECUTOU INTERRUPCAO: INT3");
			}

			ri = mem[ip];
			switch (ri) {
			case 0:// "init ax"
				ax = 0;
				stringBuffer.append("init aux" + System.lineSeparator());
				break;

			case 1:// "move ax,bx"
				ax = bx;
				stringBuffer.append("move ax,bx" + System.lineSeparator());
				break;
			case 2:// "move ax,cx",
				ax = cx;
				stringBuffer.append("move ax,cx" + System.lineSeparator());
				break;

			case 3:// "move bx,ax"
				bx = ax;
				stringBuffer.append("move bx,ax" + System.lineSeparator());
				break;

			case 4:// "move cx,ax"
				cx = ax;
				stringBuffer.append("move cx,ax" + System.lineSeparator());
				break;

			case 5:// "move ax,[",
				ax = mem[mem[ip + 1]];
				System.out.println("Executou move ax,[" + mem[ip + 1] + "]");
				stringBuffer.append("move ax,[" + mem[ip + 1] + "]" + System.lineSeparator());
				ip++;
				break;

			case 6:// "move ax,[bx+"
				ax = mem[bx + mem[ip + 1]];
				System.out.println("Executou move ax, [bx+" + mem[ip + 1] + "]");
				stringBuffer.append("move ax, [bx+" + mem[ip + 1] + "]" + System.lineSeparator());
				ip++;
				break;

			case 7:// "move ax,[bp-"
				ax = mem[bp - mem[ip + 1]];
				System.out.println("Executou move ax, [bx-" + mem[ip + 1] + "]");
				stringBuffer.append("move ax, [bx-" + mem[ip + 1] + "]" + System.lineSeparator());
				ip++;
				break;

			case 8:// "move ax,[bp+"
				ax = mem[bp + mem[ip + 1]];
				System.out.println("Executou move ax, [bp+" + mem[ip + 1] + "]");
				stringBuffer.append("move ax, [bp+" + mem[ip + 1] + "]" + System.lineSeparator());
				ip++;
				break;

			case 9:// "move ["
				mem[mem[ip + 1]] = (short) ax;
				System.out.println("Executou move [" + mem[ip + 1] + "],ax");
				stringBuffer.append("move [" + mem[ip + 1] + "],ax" + System.lineSeparator());
				ip++;
				break;

			case 10:// "move [bx+"
				mem[bx + mem[ip + 1]] = (short) ax;
				System.out.println("Executou move [bx+" + mem[ip + 1] + "],ax");
				stringBuffer.append("move [bx+" + mem[ip + 1] + "],ax" + System.lineSeparator());
				ip++;
				break;

			case 11:// "move bp,sp"
				bp = sp;
				stringBuffer.append("move bp,sp" + System.lineSeparator());
				break;

			case 12:// "move sp,bp"
				sp = bp;
				stringBuffer.append("move sp,bp" + System.lineSeparator());
				break;

			case 13:// "add ax,bx"
				ax = ax + bx;
				stringBuffer.append("add ax,bx" + System.lineSeparator());
				break;

			case 14:// "add ax,cx"
				ax = ax + cx;
				stringBuffer.append("add ax,cx" + System.lineSeparator());
				break;

			case 15:// "add bx,cx"
				bx = bx + cx;
				stringBuffer.append("add bx,cx" + System.lineSeparator());
				break;

			case 16:// "sub ax,bx"
				ax = ax - bx;
				stringBuffer.append("sub ax,bx" + System.lineSeparator());
				break;

			case 17:// "sub ax,cx"
				ax = ax - cx;
				stringBuffer.append("sub ax,cx" + System.lineSeparator());
				break;

			case 18:// "sub bx,cx"
				bx = bx - cx;
				stringBuffer.append("sub bx,cx" + System.lineSeparator());
				break;

			case 19:// "inc ax"
				ax++;
				stringBuffer.append("inc ax" + System.lineSeparator());
				break;

			case 20:// "inc bx"
				bx++;
				stringBuffer.append("inc bx" + System.lineSeparator());
				break;

			case 21:// "inc cx"
				cx++;
				stringBuffer.append("inc cx" + System.lineSeparator());
				break;

			case 22:// "dec ax"
				ax--;
				stringBuffer.append("dec ax" + System.lineSeparator());
				break;

			case 23:// "dec bx"
				bx--;
				stringBuffer.append("dec bx" + System.lineSeparator());
				break;

			case 24:// "dec cx"
				cx--;
				stringBuffer.append("dec cx" + System.lineSeparator());
				break;

			case 25:// "test ax0,"
				if (ax == 0) {
					ip = aux + mem[ip + 1] - 1; // -1 para compensar o ip++ no
												// laco
				} else {
					ip++;
				}
				stringBuffer.append("test ax0," + ip + System.lineSeparator());
				break;

			case 26:// "jmp"
				ip = aux + mem[ip + 1];
				ip--;
				stringBuffer.append("jmp" + System.lineSeparator());
				break;

			case 27:// "call"
				mem[sp] = (short) (ip + 2);
				sp--;
				ip = aux + mem[ip + 1];
				ip--; // para compensar a alteracao de ip
				stringBuffer.append("call" + System.lineSeparator());
				break;

			case 28:// "ret"
				sp++;
				ip = mem[sp];
				ip--;
				stringBuffer.append("ret" + System.lineSeparator());
				break;

			case 29:// "in ax"
				ax = Integer.parseInt(JOptionPane.showInputDialog("ax:"));
				stringBuffer.append("in ax" + System.lineSeparator());
				break;

			case 30:// "out ax"
				System.out.println("Saida: AX=" + ax);
				stringBuffer.append("out ax" + System.lineSeparator());
				break;

			case 31:// "push ax"
				mem[sp] = (short) ax;
				sp--;
				stringBuffer.append("push ax" + System.lineSeparator());
				break;

			case 32:// "push bx"
				mem[sp] = (short) bx;
				sp--;
				stringBuffer.append("push bx" + System.lineSeparator());
				break;

			case 33:// "push cx"
				mem[sp] = (short) cx;
				sp--;
				stringBuffer.append("push cx" + System.lineSeparator());
				break;

			case 34:// "push bp"
				mem[sp] = (short) bp;
				sp--;
				stringBuffer.append("push bp" + System.lineSeparator());
				break;

			case 35:// "pop bp"
				sp++;
				bp = mem[sp];
				stringBuffer.append("pop bp" + System.lineSeparator());
				break;

			case 36:// "pop cx"
				sp++;
				cx = mem[sp];
				stringBuffer.append("pop cx" + System.lineSeparator());
				break;

			case 37:// "pop bx"
				sp++;
				bx = mem[sp];
				stringBuffer.append("pop bx" + System.lineSeparator());
				break;

			case 38:// "pop ax"
				sp++;
				ax = mem[sp];
				stringBuffer.append("pop ax" + System.lineSeparator());
				break;

			case 39:// "nop"
				stringBuffer.append("nop" + System.lineSeparator());
				break;

			case 40: // "halt"
				repetir = false;
				stringBuffer.append("halt" + System.lineSeparator());
				break;

			case 41:// "dec sp"
				sp--;
				stringBuffer.append("dec sp" + System.lineSeparator());
				break;

			case 42:// "move [bp-"
				mem[aux + bp - mem[ip + 1]] = (short) ax;
				ip++;
				stringBuffer.append("move [bp-" + ip + System.lineSeparator());
				break;

			case 43:// "move [bp+"
				stringBuffer.append("move [bp+" + ip + System.lineSeparator());
				break;

			case 44:// "move ax,{"
				ax = mem[ip + 1];
				stringBuffer.append("move ax,{" + ip + "}" + System.lineSeparator());
				ip++;
				break;

			case 45:// "test axEqbx,"
				if (ax == bx) {
					ip = mem[ip + 1] - 1;
					System.out.println("Executou THEN test axEqbx -> ip" + mem[ip + 1]);
					stringBuffer.append("test axEqbx -> ip" + mem[ip + 1] + System.lineSeparator());
				} else {
					ip++;
					System.out.println("Executou ELSE test axEqbx -> ip" + ip);
					stringBuffer.append("test axEqbx -> ip" + ip + System.lineSeparator());
				}
				break;

			case 46:// "inc sp"
				sp++;
				stringBuffer.append("inc sp" + System.lineSeparator());
				break;

			case 47:// "move ax,sp"
				ax = sp;
				stringBuffer.append("move ax,sp" + System.lineSeparator());
				break;

			case 48:// "move sp,ax"
				sp = ax;
				stringBuffer.append("move sp,ax" + System.lineSeparator());
				break;

			case 49:// "move ax,bp"
				ax = bp;
				stringBuffer.append("move ax,bp" + System.lineSeparator());
				break;

			case 50:// "move bp,ax,{"
				bp = ax;
				stringBuffer.append("move bp,ax{" + System.lineSeparator());
				break;

			case 51:// "iret"
				// "pop cx"
				sp++;
				cx = mem[sp];
				// "pop bx"
				sp++;
				bx = mem[sp];
				// "pop ax"
				sp++;
				ax = mem[sp];
				// "pop bp"
				sp++;
				bp = mem[sp];
				// "ret"
				sp++;
				ip = mem[sp];
				ip--;
				stringBuffer.append("iret" + System.lineSeparator());
				break;

			case 52:// "int"
				// "push ip"
				mem[sp] = (short) (ip + 2);
				sp--;
				// "push bp"
				mem[sp] = (short) bp;
				sp--;
				// "push ax"
				mem[sp] = (short) ax;
				sp--;
				// "push bx"
				mem[sp] = (short) bx;
				sp--;
				// "push cx"
				mem[sp] = (short) cx;
				sp--;
				ip = mem[aux + mem[ip + 1]];
				ip--;
				stringBuffer.append("int" + System.lineSeparator());
				break;

			case 53:// "sub bx,ax"
				bx = bx - ax;
				stringBuffer.append("sub bx,ax" + System.lineSeparator());
				break;

			default: {
				repetir = false;
				System.out.println("Saiu");
			}
				if (ip >= mem.length) {
					System.out.println("ERRO: a memoria nao pode ser lida");
					repetir = false;
				}
			}
			ip++;
		}
		return stringBuffer.toString();
	}

	public static Short[] reverso(final String comandoAssembly) {
		final int ri = 0;
		if ("init ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 0 };
		} else if ("move ax,bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 1 };
		} else if ("move ax,cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 2 };
		} else if ("move bx,ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 3 };
		} else if ("move cx,ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 4 };
		} else if (comandoAssembly.toLowerCase().startsWith("move ax,[") && comandoAssembly.endsWith("]")) {
			return new Short[] { 5, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("[") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move ax,[bx+") && comandoAssembly.endsWith("]")) {
			return new Short[] { 6, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("+") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move ax,[bp-")
				&& comandoAssembly.toLowerCase().endsWith("]")) {
			return new Short[] { 7, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("-") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move ax,[bp+")
				&& comandoAssembly.toLowerCase().endsWith("]")) {
			return new Short[] { 8, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("+") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move [")
				&& comandoAssembly.toLowerCase().endsWith("],ax")) {
			return new Short[] { 9, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("[") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move [bx+")
				&& comandoAssembly.toLowerCase().endsWith("],ax")) {
			return new Short[] { 10 };
		} else if ("move bp,sp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 11 };
		} else if ("move sp,bp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 12 };
		} else if ("add ax,bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 13 };
		} else if ("add ax,cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 14 };
		} else if ("add bx,cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 15 };
		} else if ("sub ax,bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 16 };
		} else if ("sub ax,cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 17 };
		} else if ("move bx,cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 18 };
		} else if ("inc ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 19 };
		} else if ("inc bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 20 };
		} else if ("inc cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 21 };
		} else if ("dec ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 22 };
		} else if ("dec bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 23 };
		} else if ("dec cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 24 };
		} else if (comandoAssembly.toLowerCase().startsWith("test ax0,")) {
			return new Short[] { 25, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf(",") + 1, comandoAssembly.length())) };
		} else if (comandoAssembly.startsWith("jmp")) {
			if (!(comandoAssembly.substring(comandoAssembly.indexOf("p") + 2, comandoAssembly.length())).isEmpty()) {
				return new Short[] { 26, Short.parseShort(
						comandoAssembly.substring(comandoAssembly.indexOf("p") + 2, comandoAssembly.length())) };
			} else {
				return new Short[] { 26 };
			}
		} else if ("call".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 27 };
		} else if ("ret".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 28 };
		} else if ("in ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 29 };
		} else if ("out ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 30 };
		} else if ("push ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 31 };
		} else if ("push bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 32 };
		} else if ("push cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 33 };
		} else if ("push bp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 34 };
		} else if ("pop bp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 35 };
		} else if ("pop cx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 36 };
		} else if ("pop bx".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 37 };
		} else if ("pop ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 38 };
		} else if ("nop".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 39 };
		} else if ("halt".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 40 };
		} else if ("dec sp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 41 };
		} else if (comandoAssembly.toLowerCase().startsWith("move [bp-")
				&& comandoAssembly.toLowerCase().endsWith("]")) {
			return new Short[] { 42, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("-") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move [bp+")
				&& comandoAssembly.toLowerCase().endsWith("]")) {
			return new Short[] { 43, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("+") + 1, comandoAssembly.indexOf("]"))) };
		} else if (comandoAssembly.toLowerCase().startsWith("move ax,{")
				&& comandoAssembly.toLowerCase().endsWith("}")) {
			return new Short[] { 44, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf("{") + 1, comandoAssembly.indexOf("}"))) };
		} else if (comandoAssembly.startsWith("test axEqbx,")) {
			return new Short[] { 45, Short.parseShort(
					comandoAssembly.substring(comandoAssembly.indexOf(",") + 1, comandoAssembly.length())) };
		} else if ("inc sp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 46 };
		} else if ("move ax,sp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 47 };
		} else if ("move sp,ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 48 };
		} else if ("move ax,bp".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 49 };
		} else if ("move bp,ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 50 };
		} else if ("iret".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 51 };
		} else if ("int".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 52 };
		} else if ("sub bx,ax".equalsIgnoreCase(comandoAssembly)) {
			return new Short[] { 53 };
		}
		return null;
	}
}
