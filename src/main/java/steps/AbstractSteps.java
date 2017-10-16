package steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContext;

public abstract class AbstractSteps {

    @Autowired
    protected TestContext context;
}