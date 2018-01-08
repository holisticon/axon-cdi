package org.axonframework.extension.example.minimal.core;

import org.axonframework.extension.example.minimal.core.api.AccountCreatedEvent;
import org.axonframework.extension.example.minimal.core.api.CreateAccountCommand;
import org.axonframework.extension.example.minimal.core.impl.Account;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.junit.Test;

public class AccountTest {

  private AggregateTestFixture<Account> account = new AggregateTestFixture<>(Account.class);
  @Test
  public void testAccountCreate() {
    account.givenNoPriorActivity()
      .when(new CreateAccountCommand("4711", 100))
      .expectEvents(new AccountCreatedEvent("4711", 100));
  }
}
