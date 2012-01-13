/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.Account.dao;

import com.vn.hkt.core.Account;
import com.vn.hkt.generic.api.IGenericAPI;
import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.Account.api.IAccount;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IAccount.class)
public class AccountBN implements IAccount {

    private IGenericAPI mydao;

    public AccountBN() {

        mydao = Lookup.getDefault().lookup(IGenericAPI.class);

    }

    @Override
    public boolean insertAccount(Account account) {
        if (mydao.insertData(account)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        if (mydao.updateData(account)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean removeAccount(int id) {
        if (mydao.removeData(Account.class, id)) {

            return true;
        }
        return false;
    }

    @Override
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<Account>();
        List<Object> obs = new ArrayList<Object>();
        obs = mydao.getAllData(Account.class);
        if (!obs.isEmpty()) {
            int i;
            for (i = 0; i < obs.size(); i++) {
                list.add((Account) obs.get(i));
            }
        }
        return list;
    }

    @Override
    public Account getAccountByID(int id) {
        return (Account) mydao.getByID(Account.class, id);
    }

    @Override
    public List<Account> filterAccountByID(String id) {
        List<Object> list = new ArrayList<Object>();
        List<Account> result = new ArrayList<Account>();
        list = mydao.filterByCondition(Account.class, "userID", id);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Account) list.get(i));
            }
        }
        return result;
    }

    @Override
    public List<Account> filterAccountByName(String name) {
        List<Object> list = new ArrayList<Object>();
        List<Account> result = new ArrayList<Account>();
        list = mydao.filterByCondition(Account.class, "username", name);
        if (!list.isEmpty()) {
            int i;
            for (i = 0; i < list.size(); i++) {
                result.add((Account) list.get(i));
            }
        }
        return result;
    }
}
