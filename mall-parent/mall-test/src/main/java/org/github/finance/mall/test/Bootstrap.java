package org.github.finance.mall.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.github.finance.mall.test.account.UserOnline;
import org.github.finance.mall.test.account.UserRegister;
import org.springframework.stereotype.Component;

/**
 * @author ligaofeng 2017年1月16日 下午4:13:58
 */
@Component
public class Bootstrap {

    private ExecutorService executor = Executors.newFixedThreadPool(8);

    @PostConstruct
    public void start() {
        //test register
        executor.execute(new UserRegister());
        //user online
        executor.execute(new UserOnline());
    }

}
