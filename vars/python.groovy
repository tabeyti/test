/**
 * Executes a formatted python script/string, with an option to return
 * the output to the caller.
 * 
 * EXAMPLE USAGES:
 *
 * python """
 * import os
 * print os.environ['BUILD_TAG']
 * """
 * 
 * python("""
 * import sys
 * if sys.maxsize > 4:
 *   print 'Yep!'
 * """)
 *
 * def output = python """
 * import os
 * for i in range(1,10):
 *   print i
 * """, true
 * 
 * @param  script - The script content to execute.
 * @param  stdoutRedir - Whether to consume the output as a string and return
 * back to the caller.
 * @return The execution output.
 */
def call(script, stdoutRedir = false) {
    sh returnStdout: stdoutRedir, script: """python - <<EOF
${script}
EOF"""
}