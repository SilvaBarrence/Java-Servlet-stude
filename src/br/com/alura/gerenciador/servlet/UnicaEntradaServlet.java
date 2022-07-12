package br.com.alura.gerenciador.servlet;

import java.io.IOException;

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

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas list = new ListaEmpresas();
			list.executa(request, response);

		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa remove = new RemoveEmpresa();
			remove.executa(request, response);

		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa mostrar = new MostraEmpresa();
			mostrar.executa(request, response);
			
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa emp = new AlteraEmpresa();
			emp.altera(request, response);
			
		}else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa empresa = new NovaEmpresa();
			empresa.nova(request, response);
		}
	}

}
