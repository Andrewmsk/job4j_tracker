package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User newUser) {
        users.putIfAbsent(newUser, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = users.get(user);
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
