import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Categories.class)
   // @Categories.ExcludeCategory({Test_Log_In_Out.Category2.class, Test_Log_In_Out.Category3.class})
    @Suite.SuiteClasses( { TestIFrame.class })
    public class Runner {
    }

