/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.entity;

import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hoang
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> implements AccountFacadeLocal {

    @PersistenceContext(unitName = "EJBank-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public Account CheckAccount(int id) {
        Query query = em.createNamedQuery("Account.findByACCOUNTID");
        query.setParameter("ACCOUNTID", id);
        try{
            return(Account)query.getSingleResult();
        }
        catch(Exception E){
            return null;
        }
    }

    @Override
    public String Payment(int id, double total) {
        if(CheckAccount(id)!=null){
            Account acc = CheckAccount(id);
            int pay = (int) (acc.getBalance().intValue()-total);
            acc.setBalance(BigInteger.valueOf(pay));
            return "Customer "+acc.getAccname()+" pay succesful: Your balance now is: "+acc.getBalance().toString();
        }
        return "payment fail";
    }
}
