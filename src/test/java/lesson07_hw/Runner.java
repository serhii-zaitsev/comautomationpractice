package lesson07_hw;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Categories.class)
    @Categories.ExcludeCategory(Test_Log_In_Out.Category2.class)
    @Suite.SuiteClasses( { Test_Log_In_Out.class })
    public class Runner {
    }

