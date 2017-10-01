package tests.lib

import tests.testSupport.PipelineTestBase
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition
import org.jenkinsci.plugins.workflow.job.WorkflowJob
import hudson.model.Result

/**
 * Tests shared vars 'step's.
 */
class StepTests extends PipelineTestBase  {

  void "tests the nodex step"() {
    given:
        WorkflowJob p = j.createProject(WorkflowJob.class, "p");

    when:
      p.setDefinition(new CpsFlowDefinition("""
            
            nodex("master"){ 
                println 'IN A NODEX BLOCK!!'
            }"""
        ));

    then:
    println ""
    j.assertBuildStatusSuccess(p.scheduleBuild2(0));
  }
}