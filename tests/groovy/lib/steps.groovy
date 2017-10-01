package tests.lib

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith 
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameter
import org.junit.runners.Parameterized.Parameters
import testSupport.LibTestBase
import com.lesfurets.jenkins.unit.BasePipelineTest

/**
 * Tests shared vars 'step's.
 */
class StepTests extends BasePipelineTest  {

  @Override
  @Before
  void setUp() throws Exception {
    scriptRoots += 'var'
    scriptRoots += 'src/org/classic'
    super.setUp()
    binding.setVariable('scm', [branch: 'master'])
  }

  @Test
  void pkill_smoke() throws Exception {
    println "----------------------------------------"
    println "HEY YOU"
    println "----------------------------------------"
    sleep(1000)
  }
}