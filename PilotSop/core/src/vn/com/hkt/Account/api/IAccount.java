/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.Account.api;

import com.vn.hkt.core.Account;
import java.util.List;

/**
 *
 * @author duong
 */
public interface IAccount {

    public boolean insertAccount(Account account);

    public boolean updateAccount(Account account);

    public boolean removeAccount(int id);

    public List<Account> getAllAccount();

    public Account getAccountByID(int id);

    public List<Account> filterAccountByID(String id);

    public List<Account> filterAccountByName(String name);
}
