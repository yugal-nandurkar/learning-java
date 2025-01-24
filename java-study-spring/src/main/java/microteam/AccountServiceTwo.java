package microteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class AccountServiceTwo {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private AccountRepository accountRepository;

    public void transferFunds(Long fromAccountId, Long toAccountId, Double amount) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("transferFundsTransaction");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow();
            Account toAccount = accountRepository.findById(toAccountId).orElseThrow();

            fromAccount.debit(amount);
            toAccount.credit(amount);

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);

            transactionManager.commit(status);
        } catch (Exception ex) {
            transactionManager.rollback(status);
            throw ex;
        }
    }
}

