package br.sisacademico.controllers;

import br.sisacademico.dao.AlunoDao;
import br.sisacademico.dao.CursoDao;
import br.sisacademico.model.Aluno;
import br.sisacademico.util.AcaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AlunoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            AcaoDao acao = AcaoDao.valueOf(request.getParameter("acao"));
            AlunoDao aDao = new AlunoDao();
            CursoDao cDao = new CursoDao();
            HttpSession session = request.getSession();
            switch (acao) {
                case LEITURA:
                    ArrayList<Aluno> alunos;
                    alunos = aDao.getAlunos();
                    session.setAttribute("listaDeAlunos", alunos);
                    response.sendRedirect("./relatorio/alunos.jsp");
                    break;
                case EXCLUSAO:
                    int idAluno = Integer.parseInt(request.getParameter("idAluno"));
                    if(aDao.deleteAluno(idAluno)) {
                        response.sendRedirect("./relatorio/loader.jsp?pagina=aluno");
                    }
                case CARREGAMENTO:
                    session.setAttribute("listaCursos", cDao.getTodosCursos());
                    response.sendRedirect("./cadastro/aluno.jsp");                    
                case CADASTRO:
                    //paramos aqui
                    break;
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
