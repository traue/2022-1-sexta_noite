package br.sisacademico.controllers;

import br.sisacademico.dao.CursoDao;
import br.sisacademico.model.Curso;
import br.sisacademico.util.AcaoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CursoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            AcaoDao acao = AcaoDao.valueOf(request.getParameter("acao"));
            CursoDao cDao = new CursoDao();

            switch (acao) {
                case LEITURA:
                    Map<Curso, Integer> listaCursos = cDao.getCursosCountAlunos();
                    
                    HttpSession session = request.getSession();
                    
                    session.setAttribute("listaDeCursos", listaCursos);
                    
                    response.sendRedirect("./relatorio/curso.jsp");
                    
                    break;
                case CADASTRO:
                    Curso curso = new Curso();
                    curso.setNomeCurso(request.getParameter("nomeCurso"));
                    curso.setTipoCurso(request.getParameter("tipoCurso"));
                    if(cDao.insereCurso(curso)) {
                        response.sendRedirect("./relatorio/loader.jsp?pagina=curso");
                    }
                    break;
                case EDICAO:
                    break;
                case EXCLUSAO:
                    int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                    if(cDao.deleteCurso(idCurso)) {
                        response.sendRedirect("./relatorio/loader.jsp?pagina=curso");
                    }
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
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CursoController.class.getName()).log(Level.SEVERE, null, ex);
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
