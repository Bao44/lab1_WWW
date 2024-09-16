package vn.edu.iuh.fit.lab_01.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.lab_01.entyties.Account;
import vn.edu.iuh.fit.lab_01.reponsitories.AccountRepository;
import vn.edu.iuh.fit.lab_01.reponsitories.GrantAccessRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/action")
public class ControllerServlet extends HttpServlet {
    private AccountRepository accountRepository = new AccountRepository();
    private GrantAccessRepository grantAccessRepository = new GrantAccessRepository();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "checkLogin":
                try {
                    login(req, resp);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "addAccount":
                boolean rs = false;
                Account accountLogin = (Account) session.getAttribute("accountLogin");
                Account newAccount = new Account();
                newAccount.setAccountId(req.getParameter("accountID"));
                newAccount.setFullName(req.getParameter("fullName"));
                newAccount.setPassword(req.getParameter("password"));
                newAccount.setEmail(req.getParameter("email"));
                newAccount.setPhone(req.getParameter("phone"));
                newAccount.setStatus(1);
                try {
                    rs = accountRepository.addAccount(newAccount);
                    if(rs) {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Them account thanh cong!'); location='dashboard.jsp' </script>");
                    } else {
                        PrintWriter out = resp.getWriter();
                        out.println("<script type=\"text/javascript\"> alert('Them khong thanh cong!'); location='add_account.jsp' </script>");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String action = req.getParameter("action");
        switch (action) {
            case "listAllAccount":
                try {
                    Account account = (Account) session.getAttribute("accountLogin");
                    List<Account> list = accountRepository.getAllAccount();
                    session.setAttribute("listAccount", list);
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                req.getRequestDispatcher("/list_account.jsp").forward(req, resp);
                break;
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = req.getSession(true);
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String url = "";
        if (accountRepository.login(email, password).isPresent()) {
            session.setAttribute("accountLogin", accountRepository.login(email, password).get());
            Account acc = (Account) session.getAttribute("accountLogin");
            session.setAttribute("grant_accessLogin", grantAccessRepository.getRoleOfGrantAccessLoginById(acc.getAccountId()));
            String grant_access = session.getAttribute("grant_accessLogin").toString();
            if (grant_access.equals("admin")) {
                url = "/dashboard.jsp";
            } else {
                url = "/dashboard_user.jsp";
            }
        } else {
            resp.setContentType("text/html");
            url = "/index.jsp";
            PrintWriter out = resp.getWriter();
            out.println("<script type=\"text/javascript\"> alert('Không tồn tại account này!') </script>");
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.include(req, resp);
    }
}
