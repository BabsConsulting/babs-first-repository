/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mscchoir.donate.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.mscchoir.donate.util.Status;
import net.mscchoir.donate.util.ValidInput;
import net.mscchoir.donate.domain.entity.Donation;
import net.mscchoir.donate.domain.entity.Donor;
import net.mscchoir.donate.domain.services.DonationService;
import net.mscchoir.donate.domain.services.DonorSearchType;
import net.mscchoir.donate.domain.services.DonorService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestHandler;

/**
 *
 * @author bossbabs
 */
public class DonateServlet implements HttpRequestHandler {

    private DonationService donationService;

    private DonorService donorService;
    private static final String PLS_ENTER = "Please enter a valid ";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Declare the dispatcher for the View
        RequestDispatcher view = null;

        Status status = new Status();
        request.setAttribute("status", status);

        String firstName = request.getParameter("FIRST_NAME");
        String lastName = request.getParameter("LAST_NAME");
        String email = request.getParameter("EMAIL");
        String referer = request.getParameter("REFERER");
        BigDecimal amount = BigDecimal.valueOf(Double.parseDouble((request.getParameter("amount") != null)?request.getParameter("amount"):"0"));

        //Validations

        if (!ValidInput.isValidString(firstName)) {
            status.addException(new Exception(PLS_ENTER + "first name."));
        }
        if (!ValidInput.isValidString(lastName)) {
            status.addException(new Exception(PLS_ENTER + "last name"));
        }
        if (!ValidInput.isValidString(email) || !ValidInput.isValidEmail(email)) {
            status.addException(new Exception(PLS_ENTER + "e-mail address"));
        }

        if (!status.isSuccessful()) {
            view = request.getRequestDispatcher("index.jsp");
            view.forward(request, response);
            return;
        }

        Map<DonorSearchType, String> searchCriteria = new HashMap<DonorSearchType, String>();
        searchCriteria.put(DonorSearchType.EMAIL, email);
        List donors = null;
        Donor donor = null;
        try {
            
            donors = donorService.searchByCriteria(searchCriteria);
        } catch (Exception ex) {
            status.addException(ex);
            Logger.getLogger(DonateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (CollectionUtils.isEmpty(donors)) {
            donor = new Donor();
        } else {
            donor = (Donor) donors.get(0);   //There must be only one result
        }
        donor.setFirstName(firstName);
        donor.setLastName(lastName);
        donor.setEmail(email);
        try {
            Donation donation = donationService.createDonation(donor, amount, referer);
            donor = donation.getDonor();
        } catch (Exception ex) {
            status.addException(ex);
            Logger.getLogger(DonateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("donor", donor);
        view = request.getRequestDispatcher("thankYou.jsp");
        view.forward(request, response);
    }
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws ServletException, IOException {
        this.processRequest(hsr, hsr1);
    }

    /**
     * @param donationService the donationService to set
     */
    public void setDonationService(DonationService donationService) {
        this.donationService = donationService;
    }

    /**
     * @param donorService the donorService to set
     */
    public void setDonorService(DonorService donorService) {
        this.donorService = donorService;
    }
}
