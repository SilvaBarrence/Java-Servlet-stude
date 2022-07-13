package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		final String paramAcao = request.getParameter("acao");
		String name = null;

		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas list = new ListaEmpresas();
			name = list.executa(request, response);

		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa remove = new RemoveEmpresa();
			name = remove.executa(request, response);

		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa mostrar = new MostraEmpresa();
			name = mostrar.executa(request, response);

		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa emp = new AlteraEmpresa();
			name = emp.altera(request, response);

		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa empresa = new NovaEmpresa();
			name = empresa.nova(request, response);
		}

		String[] tipoEndereco = name.split(":");

		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}
}
