/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbBankService;

import com.example.entity.AccountFacadeLocal;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author hoang
 */
@WebService(serviceName = "paymentServices")
public class paymentServices {
    private AccountFacadeLocal accountFacade;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "servicePayment")
    public String servicePayment(@WebParam(name = "ACCOUNTID") int accountID, @WebParam(name="total") double total) {
        return accountFacade.Payment(accountID, total);
    }
}
