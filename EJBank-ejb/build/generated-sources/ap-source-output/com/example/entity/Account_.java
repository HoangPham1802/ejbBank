package com.example.entity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-08-17T20:57:01")
@StaticMetamodel(Account.class)
public class Account_ { 

    public static volatile SingularAttribute<Account, Integer> accountid;
    public static volatile SingularAttribute<Account, BigInteger> balance;
    public static volatile SingularAttribute<Account, String> accname;

}