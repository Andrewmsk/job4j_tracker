package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User newUser) {
        users.putIfAbsent(newUser, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        users.get(findByPassport(passport)).add(account);
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> user: users.entrySet()) {
            if (user.getKey().getPassport().equals(passport)) {
                return user.getKey();
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (accounts == null) return null;
        for (Account account: accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount == null
                || dstAccount == null
                || srcAccount.getBalance() < amount) {
            return false;
        }
        srcAccount.setBalance(srcAccount.getBalance() - amount);
        dstAccount.setBalance(dstAccount.getBalance() + amount);
        return true;
    }
}
